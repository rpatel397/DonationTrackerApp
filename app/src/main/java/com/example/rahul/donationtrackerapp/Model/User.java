package com.example.rahul.donationtrackerapp.Model;

public class User {
    private String name;
    private String id;
    private String password;
    private accountType type;
    private boolean accountState;

    public User(String name, String id, String password, boolean accountState, accountType type) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.accountState = accountState;
        this.type = type;
    }

    //Add getters and setters for user

}