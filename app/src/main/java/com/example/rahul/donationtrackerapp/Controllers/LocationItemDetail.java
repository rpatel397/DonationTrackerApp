package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

/**
 * Used by LocationList.java to display a list of locations
 * that can be clicked on to display additional pertinent
 * information on a separate screen. Utilizes the
 * LocationItemDetailFragment.java to display the location
 * details
 */
public class LocationItemDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_item_detail);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            Intent currentIntent = getIntent();
            arguments.putInt(LocationItemDetailFragment.ARG_ITEM_ID,
                    currentIntent.getIntExtra(LocationItemDetailFragment.ARG_ITEM_ID, 1000));
            LocationItemDetailFragment fragment = new LocationItemDetailFragment();
            fragment.setArguments(arguments);


            FragmentManager supportFragManager =  getSupportFragmentManager();
            FragmentTransaction transaction = supportFragManager.beginTransaction();
            transaction.add(R.id.locationitem_detail_container, fragment);
            transaction.commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, LocationList.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}



