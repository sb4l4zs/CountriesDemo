package com.nokia.ndac.ecs.countrydemoapp;

import android.app.Application;

import com.nokia.ndac.ecs.countrydemoapp.repository.Repository;
import com.nokia.ndac.ecs.countrydemoapp.ui.UIModule;

import javax.inject.Inject;

public class CountryDemoApplication extends Application {

    @Inject
    Repository repository;

    public static CountryDemoApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerCountryDemoApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
        injector.inject(this);
        repository.open(getApplicationContext());
    }
}