package com.nokia.ndac.ecs.countrydemoapp.network;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Request;

public class NetworkInterceptor implements Interceptor {
    @Inject
    CountriesApi countriesApi;

    public static boolean isRefreshingToken = false;

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        //TODO get token from storage
        String userToken = "akdhfkashdjfkhdsf";

        Request.Builder builder = chain.request().newBuilder();

        if (userToken == null) {
            //TODO log in

        } else {
            if (!isRefreshingToken) {
                if (isTokenExpired()) {
                    refreshToken(new ApiFinishedListener() {
                        @Override
                        public void onFinished(boolean isSuccess) {
                            if (!isSuccess) {
                                //TODO check internet connection

                            }
                        }
                    });
                }
            }
            builder.addHeader("Authorization", "Bearer " + userToken);
        }

        return chain.proceed(builder.build());
    }

    public boolean isTokenExpired() {
        //TODO validate token expiry
        return false;
    }

    public void refreshToken(final ApiFinishedListener finishedListener) {
        isRefreshingToken = true;
        //TODO implement refresh token

    }
}