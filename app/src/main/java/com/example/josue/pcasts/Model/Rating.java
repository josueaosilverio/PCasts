package com.example.josue.pcasts.Model;

/**
 * Created by josue on 03/01/2018.
 */

public class Rating {
    public String scheme;
    public String value;

    public Rating(String scheme, String value) {
        this.scheme = scheme;
        this.value = value;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}