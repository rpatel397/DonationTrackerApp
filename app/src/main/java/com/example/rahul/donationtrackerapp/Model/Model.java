package com.example.rahul.donationtrackerapp.Model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<Location> locations;
    private List<Item> donations;

    public static final Model INSTANCE = new Model();

    private Model() {
       locations = new ArrayList<>();
       donations = new ArrayList<>();
    }

    public void clearLocations(){
        locations = new ArrayList<>();
    }

    public void clearDonations(){
        donations = new ArrayList<>();
    }

    public void add(Location location){
        locations.add(location);
    }

    public void add(Item item){
        donations.add(item);
    }

    public List<Location> getLocations(){
        return locations;
    }

    public List<Item> getDonations(){
        return donations;
    }


    public Location findLocationByKey(int id) {
        for (Location location : locations) {
            if (location.getKey() == id) return location;
        }
        return null;
    }

    public Item findDonationByKey(int id) {
        for (Item item : donations) {
            if (item.getKey() == id) return item;
        }
        return null;
    }
}
