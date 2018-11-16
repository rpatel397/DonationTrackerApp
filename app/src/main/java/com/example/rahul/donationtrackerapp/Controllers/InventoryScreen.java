package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;

import com.example.rahul.donationtrackerapp.Model.Model;

/**
 * Class that allows for the inventory to be displayed on the screen of the device
 */
public class InventoryScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Button addItem_button;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_screen);
        //addItem_button = findViewById(R.id.button_addItem);
    }

    /**
     * Method detailing what happens when the button for adding items gets pressed (takes the user
     * to the page for adding items)
     * @param view the current view being passed in
     */
    public void onaddItemPressed(View view) {
        Intent intent = new Intent(InventoryScreen.this, UpdateInventory.class);
        startActivity(intent);
    }

    /**
     * Method that takes the user from the current view to the list of items in the inventory
     * @param view the current view being passed in
     */
    public void onItemList(View view) {
        Model.INSTANCE.setFullDonations();
        Intent intent = new Intent(InventoryScreen.this, DonationList.class);
        startActivity(intent);
    }

    /**
     * Method that takes the user to a page allowing for them to search for items
     * @param view the current view being passed in
     */
    public void OnSearch (View view) {
        Intent intent = new Intent(InventoryScreen.this, Search.class);
        startActivity(intent);
    }


}
