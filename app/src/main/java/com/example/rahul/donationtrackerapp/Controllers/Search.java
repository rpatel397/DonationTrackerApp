package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rahul.donationtrackerapp.Model.Model;
import com.example.rahul.donationtrackerapp.Model.donationType;

import java.util.Arrays;
import java.util.List;

/**
 * Search class implements the ability to search through inventory
 */
public class Search extends AppCompatActivity {

    private static final List<String> legalLocations = Arrays.asList
            ("Any","AFD Station 4","Boys & Girls Club W.W. Woolfolk",
            "Pathway Upper Room Christian Ministries", "Pavilion of Hope", "D&D Convenience Store",
                    "Keep North Fulton Beautiful");

    private EditText name;
    //private Button searchName;
    //private Button searchCategory;
    private Spinner location;
    private Spinner category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        name = findViewById(R.id.textview_Search);
        //searchCategory = findViewById(R.id.button_searchCategory);
        //searchName = findViewById(R.id.button_searchName);
        location = findViewById(R.id.spinner_location);
        category = findViewById(R.id.spinner_category);

        ArrayAdapter<donationType> adapter = new ArrayAdapter<>
                (this,android.R.layout.simple_spinner_item, donationType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>
                (this,android.R.layout.simple_spinner_item, legalLocations);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        location.setAdapter(adapter2);

    }

    /**
     * @param view
     * method implements search by Name
     */
    public void onSearchNamePressed(View view) {
        Intent intent = new Intent(Search.this, DonationList.class);
        Model.INSTANCE.setFullDonations();
        if (Model.INSTANCE.queryItemsBasedOnName(location.getSelectedItem()+"",
                name.getText()+"") > 0){
            startActivity(intent);
        } else {
            Toast incompleteField = Toast.makeText
                    (Search.this, "There are no items with" + name.getText()+""
                    + " in the inventory.", Toast.LENGTH_SHORT);
            incompleteField.show();
        }
    }

    /**
     * @param view
     * method implements search by category
     */
    public void onSearchCategoryPressed(View view) {
        Model.INSTANCE.setFullDonations();
        Intent intent = new Intent(Search.this, DonationList.class);
        if (Model.INSTANCE.queryItemsBasedOnCategory(location.getSelectedItem()+"",
                category.getSelectedItem()+"") > 0) {
            startActivity(intent);
        } else {
            Toast incompleteField = Toast.makeText(Search.this, "There are no items with" +
                    category.getSelectedItem()+""
                    + " in the inventory.", Toast.LENGTH_SHORT);
            incompleteField.show();
        }

    }

}
