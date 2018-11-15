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
        donations = backupDonations;
        donations.clear();
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
        donations = backupDonations;
        for (Item item : donations) {
            if (item.getKey() == id) return item;
        }
        return null;
    }
    public int queryItemsBasedOnCategory(String location, String category) {
        queryList.clear();

        for (Item it : donations) {
            if (location.equals("Any")) {
                if (it.getCategory().getCategory().equalsIgnoreCase(category)) {
                    queryList.add(it);
                }
            } else {
                if (it.getCategory().getCategory().equalsIgnoreCase(category) && it.getLocation().equals(location)) {
                    queryList.add(it);

                }
            }

        }
        donations = queryList;
        return queryList.size();
    }

    /**
     * @param location
     * @param name
     * @return
     */
    public int queryItemsBasedOnName(String location, String name) {
        queryList.clear();
        for (Item it : donations) {
            if (location.equals("Any")) {
                if (it.getShortDescription().toLowerCase().contains(name.toLowerCase())) {
                    queryList.add(it);
                }
            } else if (name.equalsIgnoreCase("")) {
                if (it.getLocation().equals(location)) {
                    queryList.add(it);
                }

            }else {
                if (it.getShortDescription().toLowerCase().contains(name.toLowerCase())
                         && it.getLocation().equals(location)) {
                    queryList.add(it);
                }
            }

        }
        donations = queryList;
        return queryList.size();
    }

    public void setFullDonations() {
        donations = backupDonations;
    }
}
