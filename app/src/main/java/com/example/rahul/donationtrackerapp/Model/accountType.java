package com.example.rahul.donationtrackerapp.Model;

import android.support.annotation.NonNull;

/**
 * Enum for a user's type of account
 */
public enum accountType {
    USER("User"),
    LOCATIONEMPLOYEE("Location Employee"),
    ADMIN("Admin"),
    MANAGER("Manager");

    private final String type;
    accountType(String type){
        this.type = type;
    }

    @Override
    @NonNull
    public String toString(){
        return this.type;
    }
}
