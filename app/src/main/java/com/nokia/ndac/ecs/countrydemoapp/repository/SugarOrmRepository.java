package com.nokia.ndac.ecs.countrydemoapp.repository;

import android.content.Context;

import com.nokia.ndac.ecs.countrydemoapp.model.Country;
import com.orm.SugarContext;

import java.util.List;

public class SugarOrmRepository implements Repository {
    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Country> getCountries(String query) {
        return null;
    }
}
