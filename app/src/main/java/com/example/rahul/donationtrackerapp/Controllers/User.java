package com.example.rahul.donationtrackerapp.Controllers;

import android.widget.EditText;

import java.util.Arrays;
import java.util.List;

public class User {
    public static List<String> legalAccounts = Arrays.asList("USER", "Location Employee", "Admin", "Manager");

    private String name;
    private String id;
    private String password;
    private String accountType;
    private boolean accountState;

    public User(String name, String id, String password, String accountType, boolean accountState) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.accountType = accountType;
        this.accountState = accountState;
    }
}
