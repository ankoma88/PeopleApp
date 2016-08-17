package com.ankoma88.peopleapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ankoma88.peopleapp.R;
import com.ankoma88.peopleapp.model.Person;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PersonViewHolder> {
    private List<Person> people = new ArrayList<>();
    private Context context;

    public PeopleAdapter(List<Person> people, Context context) {
        if (people != null) {
            this.people = people;
        }
        this.context = context;
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_avatar)
        public SimpleDraweeView ivPortrait;
        @Bind(R.id.tv_name)
        public TextView tvName;
        @Bind(R.id.tv_sex)
        public TextView tvSex;
        @Bind(R.id.tv_born)
        public TextView tvBorn;
        @Bind(R.id.tv_died)
        public TextView tvDied;
        @Bind(R.id.tv_birthday)
        public TextView tvBirthday;
        @Bind(R.id.tv_death_day)
        public TextView tvDeathDay;
        @Bind(R.id.tv_birth_place)
        public TextView tvBirthPlace;
        @Bind(R.id.tv_death_place)
        public TextView tvDeathPlace;
        @Bind(R.id.tv_birth_location)
        public TextView tvBirthLocation;
        @Bind(R.id.tv_death_location)
        public TextView tvDeathLocation;


        public PersonViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @SuppressLint("SetTextI18n")
        public void bind(final Person person) {
            tvName.setText(person.getFirstName() + " " + person.getLastname());
            tvSex.setText(person.getSex());
            tvBirthday.setText(person.getBirth());
            tvBirthPlace.setText(person.getBirthPlace());
            tvBirthLocation.setText(person.getBirthLatitude() + " " + person.getBirthLongitude());

            if (person.getDeath() != null) {
                tvDied.setVisibility(View.VISIBLE);
                tvDeathDay.setText(person.getDeath());
                tvDeathPlace.setText(person.getDeathPlace());
                tvDeathLocation.setText(person.getDeathLatitude() + " " + person.getDeathLongitude());
            }

            String portrait = person.getPortrait();
            if (portrait != null && !portrait.isEmpty()) {
                Log.e("portrait", portrait);
                ivPortrait.setImageURI(Uri.parse(person.getPortrait()));
            }
        }
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_person, parent, false);

        return new PersonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.bind(people.get(position));
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

}
