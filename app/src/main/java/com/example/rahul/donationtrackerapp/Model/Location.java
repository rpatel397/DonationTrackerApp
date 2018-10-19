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

    //change to enum eventually
    private String type;

    private String phone;
    private String website;

    public Location(int key, String name, double latitude, double longitude, String address,
                    String city, String state, int zip, String type, String phone, String website) {
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
    @Override
    public String toString() { return name + " " + key; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state;}

    public int getZip() { return zip; }
    public void setZip(int zip) { this.zip = zip; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }

    //Doesn't need a setter
    public int getKey() { return key; }
}