package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class LocationItemDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_item_detail);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putInt(LocationItemDetailFragment.ARG_ITEM_ID,
                    getIntent().getIntExtra(LocationItemDetailFragment.ARG_ITEM_ID, 1000));
            LocationItemDetailFragment fragment = new LocationItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.locationitem_detail_container, fragment)
                    .commit();
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



