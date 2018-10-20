package com.example.rahul.donationtrackerapp.Model;

public enum locationType {
    DROPOFF("Dropoff"),
    STORE("Store"),
    WAREHOUSE("Warehouse");

    private String type;
    locationType(String type){
        this.type = type;
    }

    @Override
    public String toString(){
        return this.type;
    }
}
