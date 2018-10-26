package com.example.rahul.donationtrackerapp.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Model {

    private List<Location> locations;
    private List<Item> backupDonations;
    private  List<Item> queryList;
    private List<Item> donations;

    public static final Model INSTANCE = new Model();

    private Model() {
       locations = new ArrayList<>();
       queryList = new ArrayList<>();
       backupDonations = new ArrayList<>();
       donations = backupDonations;
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
        donations = backupDonations;
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

    public int queryItemsBasedOnCategory(String location, donationType category) {
        queryList.clear();
        donations = queryList;
        for (Item it : donations) {
            if (location.equals("Any")) {
                if (it.getCategory() == category) {
                    queryList.add(it);
                }
            } else {
                if (it.getCategory() == category && it.getLocation().equals(location)) {
                    queryList.add(it);
                }
            }

        }
        return queryList.size();
    }
    public int queryItemsBasedOnName(String location, String name) {
        queryList.clear();
        donations = queryList;
        for (Item it : donations) {
            if (location.equals("Any")) {
                if (it.getShortDescription().toLowerCase().contains(name.toLowerCase())) {
                    queryList.add(it);
                }
            } else {
                if (it.getShortDescription().toLowerCase().contains(name.toLowerCase())
                        && it.getLocation().equals(location)) {
                    queryList.add(it);
                }
            }

        }
        return queryList.size();
    }
}
