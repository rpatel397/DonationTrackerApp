package com.example.rahul.donationtrackerapp.Model;

import com.example.rahul.donationtrackerapp.Controllers.Location;

import java.util.ArrayList;
import java.util.List;

public class SimpleModel {

    public static final SimpleModel INSTANCE = new SimpleModel();

    private List<Location> locations;







    private SimpleModel() {
        locations = new ArrayList<>();
    }



    public void addItem(Location item) {
        locations.add(item);
    }

    public List<Location> getItems() {
        return locations;
    }

    public Location findItemById(int id) {
        for (Location location : locations) {
            if (location.getKey() == id) return location;
        }
        return null;
    }
}
