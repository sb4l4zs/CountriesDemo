package com.nokia.ndac.ecs.countrydemoapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("alpha2_code")
    @Expose
    private String alpha2_code;
    @SerializedName("alpha3_code")
    @Expose
    private String alpha3_code;

    public Country() {
    }

    public Country(String name, String alpha2_code, String alpha3_code) {
        this.name = name;
        this.alpha2_code = alpha2_code;
        this.alpha3_code = alpha3_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha2_code() {
        return alpha2_code;
    }

    public void setAlpha2_code(String alpha2_code) {
        this.alpha2_code = alpha2_code;
    }

    public String getAlpha3_code() {
        return alpha3_code;
    }

    public void setAlpha3_code(String alpha3_code) {
        this.alpha3_code = alpha3_code;
    }
}
