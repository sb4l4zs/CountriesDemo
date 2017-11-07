package com.nokia.ndac.ecs.countrydemoapp.network;

import com.nokia.ndac.ecs.countrydemoapp.model.CountriesResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CountriesApi{
    @GET("search")
    Call<CountriesResult> getCountries(@Query("text") String query);
}
