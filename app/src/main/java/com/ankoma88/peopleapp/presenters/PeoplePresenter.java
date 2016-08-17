package com.ankoma88.peopleapp.presenters;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.ankoma88.peopleapp.callbacks.PeopleLoadListener;
import com.ankoma88.peopleapp.model.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by ankoma88 on 17.08.16.
 */
public class PeoplePresenter {
    private static final String TAG = PeoplePresenter.class.getSimpleName();
    public static final String SOURCE = "data.json";

    private Context context;
    private PeopleLoadListener listener;

    public PeoplePresenter(Context context) {
        this.context = context;
    }

    public void loadPeople(PeopleLoadListener listener) {
        this.listener = listener;
        ReadTask task = new ReadTask();
        task.execute();
    }

    private String readDataAsText(Context context, String name) {
        BufferedReader in = null;
        try {
            InputStream is = context.getAssets().open(name);
            in = new BufferedReader(new InputStreamReader(is));

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            return new String(buffer);

        } catch (IOException e) {
            Log.e(TAG, "Error opening asset " + name);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    Log.e(TAG, "Error closing asset " + name);
                }
            }
        }

        return null;
    }

    private class ReadTask extends AsyncTask<Void, Void, List<Person>> {

        @Override
        protected List<Person> doInBackground(Void... params) {
            String data = readDataAsText(context, SOURCE);
            Gson gson = new Gson();
            Type collectionType = new TypeToken<List<Person>>() {}.getType();
            return gson.fromJson(data, collectionType);
        }

        @Override
        protected void onPostExecute(List<Person> people) {
            super.onPostExecute(people);
            listener.onPeopleLoaded(people);
        }
    }
}
