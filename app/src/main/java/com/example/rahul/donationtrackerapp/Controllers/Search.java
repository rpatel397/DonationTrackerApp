package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rahul.donationtrackerapp.Model.Item;
import com.example.rahul.donationtrackerapp.Model.Model;
import com.example.rahul.donationtrackerapp.Model.donationType;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.List;

public class Search extends AppCompatActivity {

    private static List<String> legalLocations = Arrays.asList("Any","AFD Station 4","Boys & Girls Club W.W. Woolfolk",
            "Pathway Upper Room Christian Ministries", "Pavilion of Hope", "D&D Convenience Store", "Keep North Fulton Beautiful");

    private EditText name;
    private Button searchName;
    private Button searchCategory;
    private Spinner location;
    private Spinner category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        name = findViewById(R.id.textview_Search);
        searchCategory = findViewById(R.id.button_searchCategory);
        searchName = findViewById(R.id.button_searchName);
        location = findViewById(R.id.spinner_location);
        category = findViewById(R.id.spinner_category);

        ArrayAdapter<donationType> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, donationType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, legalLocations);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        location.setAdapter(adapter2);

    }

    public void onsearchNamePressed(View view) {
        Intent intent = new Intent(Search.this, DonationList.class);
        Model.INSTANCE.setFullDonations();
        if (Model.INSTANCE.queryItemsBasedOnName(location.getSelectedItem().toString(),
                name.getText().toString()) > 0){
            startActivity(intent);
        } else {
            Toast.makeText(Search.this, "There are no items with" + name.getText().toString()
                    + " in the inventory.", Toast.LENGTH_SHORT).show();
        }
    }
    public void onsearchCategoryPressed(View view) {
        Model.INSTANCE.setFullDonations();
        Intent intent = new Intent(Search.this, DonationList.class);
        if (Model.INSTANCE.queryItemsBasedOnCategory(location.getSelectedItem().toString(),
                category.getSelectedItem().toString()) > 0) {
            startActivity(intent);
        } else {
            Toast.makeText(Search.this, "There are no items with" + category.getSelectedItem().toString()
                    + " in the inventory.", Toast.LENGTH_SHORT).show();
        }

    }

}
