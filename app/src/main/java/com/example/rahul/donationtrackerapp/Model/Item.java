package com.example.rahul.donationtrackerapp.Model;

import java.sql.Timestamp;

public class Item {
    private double value;
    private Timestamp timeStamp;
    private String shortDescription;
    private String fullDescription;
    private String comments;
    private String location;
    private donationType category;

    private enum Category {
        CLOTHING("Clothing", 0), HAT("Hat", 1), KITCHEN("Kitchen", 2), ELECTRONICS("Electronics", 3), HOUSEHOLD("Household", 4), OTHER("Other", 5);

        private final int index;
        private final String category;
        Category(String category, int index) {
            this.category = category;
            this.index = index;
        }

        public int getIndex(){
            return index;
        }
        public String getCategory(){
            return category;
        }
        public String toString() {
            return category;
        }
    }

    public Item(){ }

    public Item(double value, Timestamp timeStamp, String shortDescription, String fullDescription, String comments, donationType category, String location) {
        this.value = value;
        this.timeStamp = timeStamp;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.comments = comments;
        this.category = category;
        this.location = location;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
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
}
