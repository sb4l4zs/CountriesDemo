package com.nokia.ndac.ecs.countrydemoapp.ui.main;

import android.content.Context;

import com.nokia.ndac.ecs.countrydemoapp.model.RestResponse;

import java.util.List;

public interface MainScreen {
    Context getContext();

    void showResponse(RestResponse response);
}
