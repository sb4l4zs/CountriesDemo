package com.nokia.ndac.ecs.countrydemoapp.network;

public interface ApiFinishedListener {
    /**
     * Api call was finished
     *
     * @param isSuccess True if with success, false otherwise
     */
    void onFinished(boolean isSuccess);
}
