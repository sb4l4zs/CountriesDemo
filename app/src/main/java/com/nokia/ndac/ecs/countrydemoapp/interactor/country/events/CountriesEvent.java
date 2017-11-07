package com.nokia.ndac.ecs.countrydemoapp.interactor.country.events;

import com.nokia.ndac.ecs.countrydemoapp.model.RestResponse;

import java.util.List;

public class CountriesEvent {
    private int code;
    private RestResponse countries;
    private Throwable throwable;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public RestResponse getCountries() {
        return countries;
    }

    public void setCountries(RestResponse countries) {
        this.countries = countries;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
