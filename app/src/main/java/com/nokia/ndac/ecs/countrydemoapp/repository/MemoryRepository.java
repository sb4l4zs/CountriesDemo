package com.nokia.ndac.ecs.countrydemoapp.repository;

import android.content.Context;

import com.nokia.ndac.ecs.countrydemoapp.model.CountriesResult;
import com.nokia.ndac.ecs.countrydemoapp.model.Country;
import com.nokia.ndac.ecs.countrydemoapp.network.CountriesApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Query;

public class MemoryRepository implements Repository {

    @Override
    public void open(Context context) {
        DataManager.INSTANCE.setCountries(new ArrayList<Country>());
        DataManager.INSTANCE.getCountries().add(new Country("Hungary", "hu", "hun"));
    }

    @Override
    public void close() {

    }

    @Override
    public List<Country> getCountries(String query) {
        return null;
    }
}
