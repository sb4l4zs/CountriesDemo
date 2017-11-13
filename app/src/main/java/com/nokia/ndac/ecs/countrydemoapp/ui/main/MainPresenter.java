package com.nokia.ndac.ecs.countrydemoapp.ui.main;

import com.nokia.ndac.ecs.countrydemoapp.CountryDemoApplication;
import com.nokia.ndac.ecs.countrydemoapp.di.Network;
import com.nokia.ndac.ecs.countrydemoapp.interactor.country.CountryInteractor;
import com.nokia.ndac.ecs.countrydemoapp.interactor.country.events.CountriesEvent;
import com.nokia.ndac.ecs.countrydemoapp.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import okhttp3.internal.NamedRunnable;

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    CountryInteractor countryInteractor;

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        CountryDemoApplication.injector.inject(this);
        EventBus.getDefault().register(this);
        countryInteractor.setContext(screen.getContext());
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        EventBus.getDefault().unregister(this);
    }


    public void getCountries(final String countryQuery) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                countryInteractor.getCountries(countryQuery);
            }
        });
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final CountriesEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
        } else {
            if (screen != null) {
                screen.showResponse(event.getCountries());
            }
        }
    }
}
