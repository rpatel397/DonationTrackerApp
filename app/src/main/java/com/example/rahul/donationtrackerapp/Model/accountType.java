package com.example.rahul.donationtrackerapp.Model;

public enum accountType {
    USER("User"),
    LOCATIONEMPLOYEE("Location Employee"),
    ADMIN("Admin"),
    MANAGER("Manager");

    private String type;
    accountType(String type){
        this.type = type;
    }

    @Override
    public String toString(){
        return this.type;
    }
}
