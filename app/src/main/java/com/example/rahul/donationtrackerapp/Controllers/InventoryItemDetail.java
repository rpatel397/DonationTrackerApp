package com.example.rahul.donationtrackerapp.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.EditText;
import android.widget.Spinner;

public class InventoryItemDetail extends AppCompatActivity {


    private EditText value;
    private EditText category;
    private EditText fullDescription;
    private EditText location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_item_detail);

        value = findViewById(R.id.editText_Value);
        location = findViewById(R.id.editText_location);
        fullDescription =  findViewById(R.id.editText_fullDescription);
        category = findViewById(R.id.editText_category);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width * 0.8), (int)(height * 0.8));
    }
}
