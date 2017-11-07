package com.nokia.ndac.ecs.countrydemoapp.repository;

import com.nokia.ndac.ecs.countrydemoapp.model.Country;

import java.util.List;

public enum DataManager {
    INSTANCE;

    private List<Country> countries;

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
