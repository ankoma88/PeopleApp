package com.ankoma88.peopleapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ankoma88.peopleapp.R;
import com.ankoma88.peopleapp.adapters.PeopleAdapter;
import com.ankoma88.peopleapp.callbacks.PeopleCallback;
import com.ankoma88.peopleapp.callbacks.PeopleLoadListener;
import com.ankoma88.peopleapp.model.Person;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ankoma88 on 17.08.16.
 */
public class PeopleFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, PeopleLoadListener {
    private static final String TAG = PeopleFragment.class.getSimpleName();
    private static final String PEOPLE = "peopleData";

    private PeopleCallback dataLoader;
    private ArrayList<Person> people;

    @Bind(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    @Bind(R.id.rvPeople)
    RecyclerView rvPeople;

    public PeopleFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_people, container, false);
        ButterKnife.bind(this, rootView);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvPeople.setLayoutManager(layoutManager);
        refreshLayout.setOnRefreshListener(this);

        return rootView;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            people = savedInstanceState.getParcelableArrayList(PEOPLE);
            setAdapter(people);
        } else {
            dataLoader.loadPeople(this);
        }
    }

    @Override
    public void onRefresh() {
        dataLoader.loadPeople(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(PEOPLE, people);
    }

    private void setAdapter(ArrayList<Person> personArrayList) {
        final PeopleAdapter adapter = new PeopleAdapter(personArrayList, getActivity());
        rvPeople.setAdapter(adapter);
    }

    @Override
    public void onPeopleLoaded(List<Person> personList) {
        this.people = (ArrayList<Person>) personList;
        setAdapter(people);

        if (refreshLayout.isRefreshing()) {
            refreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataLoader = (PeopleCallback) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        dataLoader = null;
    }
}
