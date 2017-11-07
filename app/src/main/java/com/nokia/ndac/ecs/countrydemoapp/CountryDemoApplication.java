package com.nokia.ndac.ecs.countrydemoapp;

import android.app.Application;

import com.nokia.ndac.ecs.countrydemoapp.ui.UIModule;

public class CountryDemoApplication extends Application {

    public static CountryDemoApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerCountryDemoApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}