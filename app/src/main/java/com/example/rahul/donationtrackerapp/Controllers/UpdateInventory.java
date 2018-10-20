package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class UpdateInventory extends AppCompatActivity {


    private EditText value;
    private EditText briefDetails;
    private EditText fullDescription;
    private Spinner category;
    private Spinner location;
    private Button donate_button;
    private Button cancel_button;
    private static List<String> legalCategories = Arrays.asList("Clothing", "Hats", "Kitchen", "Electronics", "Household", "other");
    private static List<String> legalLocations = Arrays.asList("AFD Station 4","Boys & Girls Club W.W. Woolfolk",
            "Pathway Upper Room Christian Ministries", "Pavilion of Hope", "D&D Convenience Store", "Keep North Fulton Beautiful");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_inventory);
        value = findViewById(R.id.editText_value);
        briefDetails = findViewById(R.id.editText_BriefDetails);
        fullDescription =  findViewById(R.id.editText_fullDescription);
        category = findViewById(R.id.spinner_Category);
        location = findViewById(R.id.spinner_Location);
        donate_button = findViewById(R.id.button_Donate);
        cancel_button = findViewById(R.id.button_Cancel);



        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, legalCategories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, legalLocations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        location.setAdapter(adapter2);

    }

    public void onDontate(View view){
            double Mvalue;
            try {
                Mvalue = Double.parseDouble(value.getText().toString());
                if (Mvalue < 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                Toast.makeText(this, "Enter valid value", Toast.LENGTH_SHORT).show();
            }

            String brief_description = briefDetails.getText().toString();
            String full_description = fullDescription.getText().toString();

            String CATEGORY = category.getSelectedItem().toString();
            String LOCATION = location.getSelectedItem().toString();

            //Inventory inventory = new Inventory();
            //inventory.addItem(value, timeStamp, brief_description, full_description, CATEGORY, LOCATION);


        Intent intent = new Intent(UpdateInventory.this, LocationInventory.class);
        startActivity(intent);

        }






    }


