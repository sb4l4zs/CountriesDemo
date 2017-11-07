package com.nokia.ndac.ecs.countrydemoapp.interactor;

import com.nokia.ndac.ecs.countrydemoapp.interactor.country.CountryInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public CountryInteractor provideCountryInteractor() {
        return new CountryInteractor();
    }
}
