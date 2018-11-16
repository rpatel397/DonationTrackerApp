package com.example.rahul.donationtrackerapp.Controllers;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.rahul.donationtrackerapp.Model.Item;
import com.example.rahul.donationtrackerapp.Model.Location;
import com.example.rahul.donationtrackerapp.Model.Model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Pulls data from fire base and adds it to our model. Items include a list of locations
 * and a list of donated items.
 */
public class PullFromDatabase {

    private static final DatabaseReference locationDatabase =
            FirebaseDatabase.getInstance().getReference("locations");
    private static final DatabaseReference itemDatabase =
            FirebaseDatabase.getInstance().getReference("items");

    /**
     * Deletes current list of locations stored in model and adds locations from database to
     * model. Functions as an crude update for stored locations.
     */
    public static void updateLocations(){
        //Query locationQuery = locationDatabase;
        locationDatabase.addValueEventListener(new ValueEventListener() {
            final Model model = Model.INSTANCE;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                model.clearLocations();
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    Location location = snapshot.getValue(Location.class);
                    model.add(location);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError){
                Log.e("onCancelled",
                        "Error while reading from database", databaseError.toException());
            }
        });
    }


    /**
     * Deletes current list of donations stored in model and adds donations from database to
     * model. Functions as an crude update for stored donations.
     */
    public static void updateDonations(){
        itemDatabase.addValueEventListener(new ValueEventListener() {
            final Model model = Model.INSTANCE;

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                model.clearDonations();
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    Item item = snapshot.getValue(Item.class);
                    model.add(item);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError){
                Log.e("onCancelled",
                        "Error while reading from database", databaseError.toException());
            }
        });
    }
}
