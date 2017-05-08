package com.mymarvel.core;

import android.app.Application;
import com.squareup.leakcanary.LeakCanary;

public class MyMarvelApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
