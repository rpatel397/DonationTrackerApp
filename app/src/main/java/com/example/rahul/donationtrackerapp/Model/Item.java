package com.example.rahul.donationtrackerapp.Model;

import java.sql.Timestamp;

public class Item {
    private int key;
    private double value;
    private String timeStamp;
    private String shortDescription;
    private String fullDescription;
    private String comments;
    private String location;
    private donationType category;

    public Item(){ }

    public Item(double value, Timestamp timeStamp, String shortDescription, String fullDescription, String comments, donationType category, String location) {
        this.key = timeStamp.hashCode();
        this.value = value;
        this.timeStamp = timeStamp.toString();
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.comments = comments;
        this.category = category;
        this.location = location;
    }

    public int getKey() {
        return key;
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }
    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }

    public donationType getCategory() {
        return category;
    }
    public void setCategory(donationType category) {
        this.category = category;
    }


    public String getLocations(){
        return location;
    }
    public void setLocations(String location){
        this.location = location;
    }
}
