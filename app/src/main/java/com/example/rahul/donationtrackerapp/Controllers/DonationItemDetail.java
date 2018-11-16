package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.util.DisplayMetrics;
//import android.util.Log;
//import android.view.Display;
import android.view.MenuItem;
//import android.widget.EditText;
//import android.widget.Spinner;

/**
 * Class that outlines the details of a given donation item on the screen.
 */
public class DonationItemDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_item_detail);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            Intent intent = getIntent();
            int getInt = intent.getIntExtra(DonationItemDetailFragment.ARG_ITEM_ID, 1000);
            arguments.putInt(DonationItemDetailFragment.ARG_ITEM_ID, getInt);
            DonationItemDetailFragment fragment = new DonationItemDetailFragment();
            fragment.setArguments(arguments);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.commit();
            FragmentTransaction fragmentTransaction2 = fragmentTransaction.add(R.id
                    .donationitem_detail_container, fragment);
            fragmentTransaction2.commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, DonationList.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
