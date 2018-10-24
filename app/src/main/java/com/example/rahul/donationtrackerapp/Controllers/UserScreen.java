package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserScreen extends AppCompatActivity {

    private Button logOut_button;
    private Button location_button;
    private Button inventory_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);
        logOut_button= findViewById(R.id.logoutButton);
        location_button = findViewById(R.id.locationButton);
        inventory_button = findViewById(R.id.button_Inventory);
    }

    public void logoutOnPressed(View view) {
        Intent intent = new Intent(this, WelcomeScreen.class);
        startActivity(intent);
        finish();
    }

    public void locationListOnPressed(View view) {
        Intent intent = new Intent(this, LocationList.class);
        startActivity(intent);
    }

    public void inventoryOnPressed(View view) {
        Intent intent = new Intent(this, InventoryScreen.class);
        startActivity(intent);
    }
}
