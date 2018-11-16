package com.example.rahul.donationtrackerapp.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Model class that holds data temporary
 */
public final class Model {

    private List<Location> locations;
    private final List<Item> backupDonations;
    private final List<Item> queryList;
    private List<Item> donations;

    public static final Model INSTANCE = new Model();

    private Model() {
       locations = new ArrayList<>();
       queryList = new ArrayList<>();
       backupDonations = new ArrayList<>();
       donations = backupDonations;
    }

    /**
     * Clears the locations
     */
    public void clearLocations(){
        locations = new ArrayList<>();
    }

    /**
     * clears the donations
     */
    public void clearDonations(){
        donations = backupDonations;
        donations.clear();
    }

    /**
     * adds locations
     * @param location the actual location
     */
    public void add(Location location){
        locations.add(location);
    }

    /**
     * Adds items
     * @param item the actual item
     */
    public void add(Item item){
        donations = backupDonations;
        donations.add(item);
    }

    /**
     * gets the list of locations
     * @return the list of locations
     */
    public List<Location> getLocations(){
        Location[] copy = new Location[locations.size()];
        int index = 0;
        for (Location l : locations) {
            copy[index] = l;
            index = index + 1;
        }
        return Arrays.asList(copy);
    }

    /**
     * gets the list of donations
     * @return the list of donations
     */
    public List<Item> getDonations(){
        Item[] copy = new Item[donations.size()];
        int index = 0;
        for (Item l : donations) {
            copy[index] = l;
            index = index + 1;
        }
        return Arrays.asList(copy);
    }

    /**
     * finds the location by key
     * @param id the key
     * @return the location with that key
     */
    public Location findLocationByKey(int id) {
        for (Location location : locations) {
            if (location.getKey() == id){ return location; }
        }
        return null;
    }

    /**
     * finds donation by key
     * @param id the key
     * @return the donation with the key
     */
    public Item findDonationByKey(int id) {
        donations = backupDonations;
        for (Item item : donations) {
            if (item.getKey() == id){ return item;}
        }
        return null;
    }

    /**
     * Filters items based on category and location
     * @param location location name
     * @param category name of the category
     * @return numbers of matched items
     */
    public int queryItemsBasedOnCategory(String location, String category) {
        queryList.clear();

        for (Item it : donations) {
            String itemLocation = it.getLocation();
            String itemCategory = it.getCategory() + "";
            if ("Any".equalsIgnoreCase(location)) {
                if (itemCategory.equalsIgnoreCase(category)) {
                    queryList.add(it);
                }
            } else {
                if (itemCategory.equalsIgnoreCase(category)
                        && itemLocation.equalsIgnoreCase(location)) {
                    queryList.add(it);

                }
            }

        }
        donations = queryList;
        return queryList.size();
    }

    /**
     * filters the original list to get matched items
     * @param location location name
     * @param name the name of the item
     * @return the number of matched items
     */
    public int queryItemsBasedOnName(String location, String name) {
        queryList.clear();
        for (Item it : donations) {
            String itemLocation = it.getLocation();
            String itemName = it.getShortDescription();
            itemName = itemName.toLowerCase();
            if ("Any".equalsIgnoreCase(location)) {
                if (itemName.contains(name.toLowerCase())) {
                    queryList.add(it);
                }
            } else if ("".equalsIgnoreCase(name)) {
                if (itemLocation.equalsIgnoreCase(location)) {
                    queryList.add(it);
                }

            }else {
                if (itemName.contains(name.toLowerCase())
                        && itemLocation.equalsIgnoreCase(location)) {
                    queryList.add(it);
                }
            }

        }
        donations = queryList;
        return queryList.size();
    }

    /**
     * Sets the donation pointer to the backup donation or full list
     */
    public void setFullDonations() {
        donations = backupDonations;
    }
}
