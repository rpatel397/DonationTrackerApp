package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Timestamp;

import com.example.rahul.donationtrackerapp.Model.Item;

import com.example.rahul.donationtrackerapp.Model.donationType;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Class that updates inventory after adding donation
 */
public class UpdateInventory extends AppCompatActivity {

    private EditText value;
    private EditText briefDetails;
    private EditText fullDescription;
    private Spinner categorySpinner;
    private Spinner locationSpinner;
    //private Button donate_button;
    //private Button cancel_button;
    private static final List<String> legalLocations = Arrays.asList
            ("AFD Station 4","Boys & Girls Club W.W. Woolfolk",
            "Pathway Upper Room Christian Ministries", "Pavilion of Hope", "D&D Convenience Store",
                    "Keep North Fulton Beautiful");
    private final DatabaseReference itemDatabase =
            FirebaseDatabase.getInstance().getReference("items");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_inventory);

        value = findViewById(R.id.editText_value);
        briefDetails = findViewById(R.id.editText_BriefDetails);
        fullDescription =  findViewById(R.id.editText_fullDescription);
        categorySpinner = findViewById(R.id.spinner_Category);
        locationSpinner = findViewById(R.id.spinner_Location);
        //donate_button = findViewById(R.id.button_Donate);
        //cancel_button = findViewById(R.id.button_Cancel);

        ArrayAdapter<donationType> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, donationType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>
                (this,android.R.layout.simple_spinner_item, legalLocations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(adapter2);
    }

    /**
     * @param view
     * when donate is pushed method is called to save details
     */
    public void onDonate(View view) {
        if ((("").equals(value.getText()+"")) || (("").equals(briefDetails.getText()+"")) ||
                (("").equals(fullDescription.getText()+""))){
            Toast.makeText(UpdateInventory.this, "Please complete all fields",
                    Toast.LENGTH_SHORT).show();
            value.setText("");
            briefDetails.setText("");
            fullDescription.setText("");
            return;
        }

        Double M_value = Double.parseDouble(value.getText()+"");
        String brief_description = briefDetails.getText()+"";
        String full_description = fullDescription.getText()+"";
        donationType CATEGORY = (donationType) categorySpinner.getSelectedItem();
        String LOCATION = locationSpinner.getSelectedItem()+"";
        String comments = "";
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        String key = itemDatabase.push().getKey();

        Item item = new Item(M_value, timeStamp, brief_description, full_description, comments,
                CATEGORY, LOCATION);
        itemDatabase.child(Objects.requireNonNull(key));
        itemDatabase.setValue(item);
        PullFromDatabase.updateDonations();

        Intent intent = new Intent(UpdateInventory.this, InventoryScreen.class);
        finish();
        startActivity(intent);
    }

    /**
     * @param view
     * method implements cancel button to go back to the Inventory Screen
     */
    public void cancelOnPressed(View view) {
        Intent backToWelcome = new Intent
                (UpdateInventory.this, InventoryScreen.class);
        finish();
        startActivity(backToWelcome);
    }
}


