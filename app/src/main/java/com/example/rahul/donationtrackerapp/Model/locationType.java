package com.example.rahul.donationtrackerapp.Model;

import android.support.annotation.NonNull;

/**
 * Enum class that represents location
 */
public enum locationType {
    DROPOFF("Dropoff"),
    STORE("Store"),
    WAREHOUSE("Warehouse");

    private final String type;
    locationType(String type){
        this.type = type;
    }

    @NonNull
    @Override
    public String toString(){
        return this.type;
    }
}
