package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class LocationInventory extends AppCompatActivity {
    private Button addItem_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_inventory);

        addItem_button = findViewById(R.id.button_addItem);


        //ArrayAdapter<Item> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);

        //ListView listView = (ListView)findViewById(R.id.List_Item);
        //listView.setAdapter(adapter);


    }

    public void onaddItemPressed(View view) {
        Intent intent = new Intent(LocationInventory.this, UpdateInventory.class);
        startActivity(intent);
    }
}
