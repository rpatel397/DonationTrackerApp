package com.example.rahul.donationtrackerapp.Controllers;

import java.util.ArrayList;
import java.util.List;

public class SimpleModel {

    public static final SimpleModel INSTANCE = new SimpleModel();

    private List<LocationItem> items;

    private SimpleModel() {
        items = new ArrayList<>();
    }

    public void addItem(LocationItem item) {
        items.add(item);
    }

    public List<LocationItem> getItems() {
        return items;
    }

    public LocationItem findItemById(int id) {
        for (LocationItem location : items) {
            if (location.getKey() == id) return location;
        }
        return null;
    }
}
