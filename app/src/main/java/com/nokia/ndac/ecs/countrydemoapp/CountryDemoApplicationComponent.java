package com.nokia.ndac.ecs.countrydemoapp;

import com.nokia.ndac.ecs.countrydemoapp.interactor.InteractorModule;
import com.nokia.ndac.ecs.countrydemoapp.interactor.country.CountryInteractor;
import com.nokia.ndac.ecs.countrydemoapp.network.NetworkModule;
import com.nokia.ndac.ecs.countrydemoapp.ui.UIModule;
import com.nokia.ndac.ecs.countrydemoapp.ui.main.MainActivity;
import com.nokia.ndac.ecs.countrydemoapp.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class, InteractorModule.class})
public interface CountryDemoApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(MainPresenter mainPresenter);

    void inject(CountryInteractor countryInteractor);

    void inject(CountryDemoApplication countryDemoApplication);
}
