package com.example.rahul.donationtrackerapp.Model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    public static List<Location> locations = new ArrayList<>();
    public static List<Item> items = new ArrayList<>();

    public static Location findLocationByKey(int id) {
        for (Location location : locations) {
            if (location.getKey() == id) return location;
        }
        return null;
    }

}
