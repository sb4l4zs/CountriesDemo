package com.nokia.ndac.ecs.countrydemoapp.repository;

import android.content.Context;

import com.nokia.ndac.ecs.countrydemoapp.model.Country;

import java.util.List;

public interface Repository {
    void open(Context context);
    void close();

    List<Country> getCountries(String query);
}
