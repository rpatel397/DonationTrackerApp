package com.example.rahul.donationtrackerapp.Model;

import android.support.annotation.NonNull;

/**
 * Enum for the type of donation being donated
 */
public enum donationType {
    CLOTHING("Clothing", 0),
    HAT("Hat", 1),
    KITCHEN("Kitchen", 2),
    ELECTRONICS("Electronics", 3),
    HOUSEHOLD("Household", 4),
    OTHER("Other", 5);

    private final int index;
    private final String category;
    donationType(String category, int index) {
        this.category = category;
        this.index = index;
    }

    /**
     * Getting the index of a donation
     * @return int- the index of the donation
     */
    public int getIndex(){
        return index;
    }

    /**
     * Get the category of the donation
     * @return string - the category of the donation
     */
    public String getCategory(){
        return category;
    }

    @Override
    @NonNull
    public String toString() {
        return this.category;
    }
}



