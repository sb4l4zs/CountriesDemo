package com.nokia.ndac.ecs.countrydemoapp.interactor.country;

import android.content.Context;

import com.nokia.ndac.ecs.countrydemoapp.CountryDemoApplication;
import com.nokia.ndac.ecs.countrydemoapp.interactor.InteractorSelector;
import com.nokia.ndac.ecs.countrydemoapp.interactor.country.events.CountriesEvent;
import com.nokia.ndac.ecs.countrydemoapp.model.CountriesResult;
import com.nokia.ndac.ecs.countrydemoapp.network.CountriesApi;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class CountryInteractor extends InteractorSelector {

    @Inject
    CountriesApi countriesApi;

    public CountryInteractor() {
        CountryDemoApplication.injector.inject(this);
    }

    public void getCountries(String countryQuery) {
        if (isOnline()) {
            Call<CountriesResult> countriesQueryCall = countriesApi.getCountries(countryQuery);
            CountriesEvent event = new CountriesEvent();
            try {
                Response<CountriesResult> response = countriesQueryCall.execute();
                if (response.code() != 200) {
                    throw new Exception("Result code is not 200");
                }
                event.setCode(response.code());
                event.setCountries(response.body().getRestResponse());
                EventBus.getDefault().post(event);
            } catch (Exception e) {
                event.setThrowable(e);
                EventBus.getDefault().post(event);
            }
        } else {
            CountriesEvent event = new CountriesEvent();
            EventBus.getDefault().post(event);
        }
    }
}
