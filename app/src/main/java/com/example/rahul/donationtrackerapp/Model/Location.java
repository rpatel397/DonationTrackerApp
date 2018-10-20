package com.example.rahul.donationtrackerapp.Model;

public class Location {

    private int key;
    private String name;
    private double latitude;
    private double longitude;
    private String address;
    private String city;
    private String state;
    private int zip;
    private locationType type;
    private String phone;
    private String website;

    public Location(){

    }

    public Location(int key, String name, double latitude, double longitude, String address, String city, String state, int zip, locationType type, String phone, String website) {
        this.key = key;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.type = type;
        this.phone = phone;
        this.website = website;
    }

    public String toString() { return name + " " + key; }
    public String getName() { return name; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public int getZip() {  return zip; }
    public locationType getType() { return type; }
    public String getPhone() { return phone; }
    public String getWebsite() { return website; }
    public int getKey() { return key; }
}
