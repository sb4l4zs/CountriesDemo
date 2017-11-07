package com.nokia.ndac.ecs.countrydemoapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RestResponse {
    @SerializedName("messages")
    @Expose
    private List<String> messages = new ArrayList<>();
    @SerializedName("result")
    @Expose
    private List<Country> countries = new ArrayList<>();

    public RestResponse() {
    }

    public RestResponse(List<String> messages, List<Country> countries) {
        this.messages = messages;
        this.countries = countries;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
