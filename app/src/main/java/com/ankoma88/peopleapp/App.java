package com.ankoma88.peopleapp;

import android.app.Application;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by ankoma88 on 04.08.16.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }

}
