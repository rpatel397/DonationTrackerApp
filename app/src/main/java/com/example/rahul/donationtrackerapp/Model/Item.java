package com.example.rahul.donationtrackerapp.Model;

import java.sql.Timestamp;

/**
 * Class to represent a donation item
 */
public class Item {
    private int key;
    private double value;
    private String timeStamp;
    private String shortDescription;
    private String fullDescription;
    //private String comments;
    private String location;
    private donationType category;

    /**
     * No-arg constructor for donated items NECESSARY
     */
    public Item(){ }

    /**
     * The constructor for item mainly used with a bunch of parameters
     * @param value double - the cost of the donation item
     * @param timeStamp - Timestamp - the time the donation was made
     * @param shortDescription - String - small description of the donation
     * @param fullDescription - String - large, in-depth description of the donation
     * @param comments - String - comments about the donation (currently not in use)
     * @param category - donationType - type of donation made aka category of ite
     * @param location - Location - where the donation was made
     */
    public Item(double value, Timestamp timeStamp, String shortDescription, String fullDescription,
                String comments, donationType category, String location) {
        this.key = timeStamp.hashCode();
        this.value = value;
        this.timeStamp = timeStamp.toString();
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        //this.comments = comments;
        this.category = category;
        this.location = location;
    }

    /**
     * Gets the key of the item
     * @return int - the item's key
     */
    public int getKey() {
        return key;
    }

    /**
     * Gets the value of the item
     * @return double - the cost of the item
     */
    public double getValue() {
        return value;
    }


//    public void setValue(double value) {
//        this.value = value;
//    }

    /**
     * Gets the time the item was donated
     * @return String - The time of the item's donation
     */
    public CharSequence getTimeStamp() {
        return timeStamp;
    }
//    public void setTimeStamp(String timeStamp) {
//        this.timeStamp = timeStamp;
//    }

    /**
     * Gets a small description of the item
     * @return String - the small description of the item
     */
    public String getShortDescription() {
        return shortDescription;
    }
//    public void setShortDescription(String shortDescription) {
//        this.shortDescription = shortDescription;
//    }

    /**
     * Gets the large description of the item
     * @return String - the complete description of the item
     */
    public CharSequence getFullDescription() {
        return fullDescription;
    }
//    public void setFullDescription(String fullDescription) {
//        this.fullDescription = fullDescription;
//    }

//    public String getComments() {
//        return comments;
//    }
//    public void setComments(String comments) {
//        this.comments = comments;
//    }

    /**
     * Gets the category of the donation
     * @return donationType - the type of donation made
     */
    public donationType getCategory() {
        return category;
    }


//    public void setCategory(donationType category) {
//        this.category = category;
//    }

    /**
     * Gets the location of the donation
     * @return Location - where the item was donated
     */
    public String getLocation(){
        return location;
    }


//    public void setLocation(String location){this.location = location;
//    }

}
