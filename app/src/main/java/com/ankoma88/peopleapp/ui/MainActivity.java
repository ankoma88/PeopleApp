package com.ankoma88.peopleapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ankoma88.peopleapp.R;
import com.ankoma88.peopleapp.callbacks.PeopleCallback;
import com.ankoma88.peopleapp.callbacks.PeopleLoadListener;
import com.ankoma88.peopleapp.presenters.PeoplePresenter;
import com.ankoma88.peopleapp.model.Person;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PeopleCallback {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String TAG_PEOPLE_FRAGMENT = "peopleFragment";

    private PeoplePresenter presenter;
    private List<Person> people;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        presenter = new PeoplePresenter(this);
        showPeopleFragment(savedInstanceState);
    }

    private void showPeopleFragment(Bundle savedInstanceState) {
        PeopleFragment peopleFragment;
        if (savedInstanceState == null) {
            peopleFragment = new PeopleFragment();
        } else {
            peopleFragment = (PeopleFragment) getSupportFragmentManager().findFragmentByTag(TAG_PEOPLE_FRAGMENT);
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, peopleFragment, TAG_PEOPLE_FRAGMENT)
                .commit();
    }


    @Override
    public void loadPeople(PeopleLoadListener listener) {
        presenter.loadPeople(listener);
    }
}
