package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rahul.donationtrackerapp.Model.Model;

public class InventoryScreen extends AppCompatActivity {
    private Button addItem_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_screen);

        addItem_button = findViewById(R.id.button_addItem);
    }

    public void onAddItemPressed(View view) {
        Intent intent = new Intent(InventoryScreen.this, UpdateInventory.class);
        startActivity(intent);
    }

    public void onItemList(View view) {
        Model.INSTANCE.setFullDonations();
        Intent intent = new Intent(InventoryScreen.this, DonationList.class);
        startActivity(intent);
    }

    public void OnSearch (View view) {
        Intent intent = new Intent(InventoryScreen.this, Search.class);
        startActivity(intent);
    }


}
