package com.example.rahul.donationtrackerapp.Controllers;

public class LocationItem {

    private int key;
    private String name;
    private double latitude;
    private double longitude;
    private String address;
    private String city;
    private String state;
    private int zip;

    //change to enum eventually
    private String type;

    private String phone;
    private String website;

    public LocationItem(int key, String name, double latitude, double longitude, String address, String city, String state, int zip, String type, String phone, String website) {
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
    public String toString() {
            return name + " " + key;
        }
    public String getName() { return name; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public int getZip() { return zip; }
    public String getType() { return type; }
    public String getPhone() { return phone; }
    public String getWebsite() { return website; }
    public int getKey() { return key; }


}
