package com.ankoma88.peopleapp.callbacks;

import com.ankoma88.peopleapp.model.Person;

import java.util.List;

/**
 * Created by ankoma88 on 17.08.16.
 */
public interface PeopleLoadListener {
    void onPeopleLoaded(List<Person> personList);
}
