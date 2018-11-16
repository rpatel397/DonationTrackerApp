package com.example.rahul.donationtrackerapp.Model;

import android.support.annotation.NonNull;

/**
 * Class to represent locations of donation sites
 */
public class Location {

    private int key;
    private String name;
    private double latitude;
    private double longitude;
    private String address;
    //private String city;
    //private String state;
    //private int zip;
    private locationType type;
    private String phone;
    //private String website;

    /**
     * No-arg constructor for locations NECESSARY
     */
    public Location(){

    }

    /**
     * Parameterized constructor for a location. More commonly used
     * @param key - int - the key number of the location
     * @param name - String - the name of the location
     * @param latitude - double - the latitude of the location
     * @param longitude - double - the longitude of the location
     * @param address - String - the written address of the location
     * @param city - String - the city the location is in (currently not used)
     * @param state - String - the state the location is in (currently not used)
     * @param zip - int - the zip code of the location (currently not used)
     * @param type - locationType - the category of location
     * @param phone - String - the location's phone number
     * @param website - String - the website address of the location (currently not used)
     */
    public Location(int key, String name, double latitude, double longitude,
                    String address, String city, String state, int zip,
                    locationType type, String phone, String website) {
        this.key = key;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        //this.city = city;
        //this.state = state;
        //this.zip = zip;
        this.type = type;
        this.phone = phone;
        //this.website = website;
    }


    @Override
    @NonNull
    public String toString() { return name + " " + key; }

    /**
     * Gets the name of the location
     * @return String - the name of the location
     */
    public String getName() { return name; }

    /**
     * Gets the latitude of the location
     * @return double - latitude of location
     */
    public double getLatitude() { return latitude; }

    /**
     * Gets the longitude of the location
     * @return double - longitude of location
     */
    public double getLongitude() { return longitude; }

    /**
     * Gets the location's address
     * @return String - the address of the location
     */
    public CharSequence getAddress() { return address; }
    //public String getCity() { return city; }

    //public String getState() { return state; }
    //public int getZip() {  return zip; }

    /**
     * Gets the type of location
     * @return locationType - category of location
     */
    public locationType getType() { return type; }

    /**
     * Gets the phone number of the location
     * @return String - the phone number of the location
     */
    public String getPhone() { return phone; }
    //public String getWebsite() { return website; }

    /**
     * Gets the location's key number
     * @return int - the key int representation of the location
     */
    public int getKey() { return key; }
}
