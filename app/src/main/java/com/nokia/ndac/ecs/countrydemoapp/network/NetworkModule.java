package com.nokia.ndac.ecs.countrydemoapp.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    @Provides
    @Singleton
    public Retrofit provideRetrofit() {

        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(new NetworkInterceptor())
                .build();

        return new Retrofit.Builder()
                .baseUrl(NetworkConfig.ENDPOINT_ADDRESS)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public CountriesApi provideCountriesApi(Retrofit retrofit) {
        return retrofit.create(CountriesApi.class);
    }
}
