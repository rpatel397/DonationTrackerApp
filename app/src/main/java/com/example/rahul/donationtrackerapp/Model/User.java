package com.example.rahul.donationtrackerapp.Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private String name;
    private String id;
    private String password;
    private accountType type;
    private boolean accountState;
    private int loginAttempts;

    public User(){
    }

    public User(String name, String id, String password, boolean accountState, accountType type) {
        this.name = name;
        this.id = id;
        this.password = passwordHash(password);
        this.accountState = accountState;
        this.type = type;
        this.loginAttempts = 0;
    }

    public String getName(){ return name; }
    public String getId(){ return id; }
    public String getPassword(){ return password;}
    public accountType getType() { return type;}

    public boolean getAccountState() { return (loginAttempts < 4 ); }
    public void setAccountState() { this.accountState = accountState; }

    public int getLoginAttempts() { return loginAttempts; }
    public void incrementAttempts() { this.loginAttempts++; }
    public void resetAttempts() { this.loginAttempts = 0; }

    public static String passwordHash(String original){
       try{
           MessageDigest md = MessageDigest.getInstance("SHA-256");
           byte[] hashInBytes = md.digest(original.getBytes());

           StringBuilder sb = new StringBuilder();
           for (byte b : hashInBytes) {
               sb.append(String.format("%02x", b));
           }
           return sb.toString();
       } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
       }
        return null;
    }
}