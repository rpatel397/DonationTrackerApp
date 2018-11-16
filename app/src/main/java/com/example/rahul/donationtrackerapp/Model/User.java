package com.example.rahul.donationtrackerapp.Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * User class
 */
public class User {
    private String name;
    private String id;
    private String password;
    private accountType type;
    private boolean accountState;
    private int loginAttempts;

    /**
     * Default constructor
     */
    public User(){
    }

    /**
     * Constructor with parameters
     * @param name name of the person
     * @param id the unique id
     * @param password the password of the person
     * @param accountState locked or unlocked
     * @param type the type of user
     */
    public User(String name, String id, String password, boolean accountState, accountType type) {
        this.name = name;
        this.id = id;
        this.password = passwordHash(password);
        this.accountState = accountState;
        this.type = type;
        this.loginAttempts = 0;
    }

    /**
     * Gets name
     * @return name
     */
    public String getName(){ return name; }

    /**
     * gets id
     * @return id
     */
    public String getId(){ return id; }

    /**
     * gets password
     * @return password
     */
    public String getPassword(){ return password;}

    /**
     * gets the type of user
     * @return user type
     */
    public accountType getType() { return type;}

    /**
     * gets account state
     * @return account state
     */
    public boolean getAccountState() { return (loginAttempts < 4 ); }

    /**
     * sets the account state
     * @param accountState locked or unlocked
     */
    public void setAccountState(boolean accountState) { this.accountState = accountState; }

    /**
     * gets login attempt
     * @return login attempts
     */
    public int getLoginAttempts() { return loginAttempts; }

//    /**
//     * increments attempt
//     */
//    public void incrementAttempts() { this.loginAttempts++; }

//    /**
//     * resets attempts to 0
//     */
//    public void resetAttempts() { this.loginAttempts = 0; }

    /**
     * Hashes the password
     * @param original the actual password
     * @return hashed password
     */
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

// --Commented out by Inspection START (11/15/2018 4:51 PM):
//    /**
//     * Checks the password
//     * @param password password entered by user
//     * @return if the password is correct
//     */
//
//    public boolean checkPassword(String password){
//        if (password == null) {
//            return false;
//        } else {
//            return (this.password.equals(passwordHash(password)));
//        }
//
//    }
// --Commented out by Inspection STOP (11/15/2018 4:51 PM)

}