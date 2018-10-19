package com.example.rahul.donationtrackerapp.Model;


import java.util.Arrays;
import java.util.List;

enum accountType {USER, LocationEmployee, Admin, Manager}

public class User {
    public static List<String> legalAccounts = Arrays.asList("USER", "Location Employee", "Admin", "Manager");
    private String name;
    private String id;
    private String password;
    private accountType permissions;
    private boolean accountState;

    public User(String name, String id, String password, boolean accountState, String permissions) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.accountState = accountState;
        this.permissions = accountType.valueOf(permissions);
    }
}
