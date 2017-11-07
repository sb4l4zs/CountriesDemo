package com.nokia.ndac.ecs.countrydemoapp.interactor.country;

import com.nokia.ndac.ecs.countrydemoapp.CountryDemoApplication;
import com.nokia.ndac.ecs.countrydemoapp.interactor.BaseInteractor;
import com.nokia.ndac.ecs.countrydemoapp.interactor.country.events.CountriesEvent;
import com.nokia.ndac.ecs.countrydemoapp.model.CountriesResult;
import com.nokia.ndac.ecs.countrydemoapp.model.RestResponse;
import com.nokia.ndac.ecs.countrydemoapp.network.CountriesApi;
import com.nokia.ndac.ecs.countrydemoapp.repository.DataManager;
import com.nokia.ndac.ecs.countrydemoapp.repository.Repository;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class CountryInteractor extends BaseInteractor {

    @Inject
    CountriesApi countriesApi;

    @Inject
    Repository repository;

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
            event.setCountries(new RestResponse(new ArrayList<String>() {{
                add("Countries from memory");
            }}, DataManager.INSTANCE.getCountries()));
            EventBus.getDefault().post(event);
        }
    }
}
