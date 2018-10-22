package com.example.rahul.donationtrackerapp.Model;

public enum donationType {
    CLOTHING("Clothing", 0),
    HAT("Hat", 1),
    KITCHEN("Kitchen", 2),
    ELECTRONICS("Electronics", 3),
    HOUSEHOLD("Household", 4),
    OTHER("Other", 5);

    private int index;
    private String category;
    donationType(String category, int index) {
        this.category = category;
        this.index = index;
    }

    public int getIndex(){
        return index;
    }
    public String getCategory(){
        return category;
    }

    @Override
    public String toString() {
        return this.category;
    }
}



