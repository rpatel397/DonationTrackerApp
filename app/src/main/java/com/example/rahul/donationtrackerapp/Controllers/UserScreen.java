package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;

/**
 * method that shows user screen
 */
public class UserScreen extends AppCompatActivity {

    //private Button logOut_button;
    //private Button location_button;
    //private Button inventory_button;
   // private Button map_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);
        //logOut_button= findViewById(R.id.logoutButton);
        //location_button = findViewById(R.id.locationButton);
        //inventory_button = findViewById(R.id.button_Inventory);
        //map_button = findViewById(R.id.mapButton);
    }

    /**
     * @param view
     * method that functions to log out of app on click
     */
    public void logoutOnPressed(View view) {
        Intent intent = new Intent(this, WelcomeScreen.class);
        startActivity(intent);
        finish();
    }

    /**
     * @param view
     * method that opens location list activity on click
     */
    public void locationListOnPressed(View view) {
        Intent intent = new Intent(this, LocationList.class);
        startActivity(intent);
    }

    /**
     * @param view
     * on click leads to inventory
     */
    public void inventoryOnPressed(View view) {
        Intent intent = new Intent(this, InventoryScreen.class);
        startActivity(intent);
    }

    /**
     * @param view
     * on click leads to map
     */
    public void mapOnPressed(View view) {
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }
}
