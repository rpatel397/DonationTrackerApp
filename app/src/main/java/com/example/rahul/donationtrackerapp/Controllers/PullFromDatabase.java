package com.example.rahul.donationtrackerapp.Controllers;

import android.util.Log;

import com.example.rahul.donationtrackerapp.Model.Item;
import com.example.rahul.donationtrackerapp.Model.Location;
import com.example.rahul.donationtrackerapp.Model.Model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class PullFromDatabase {

    private static DatabaseReference locationDatabase = FirebaseDatabase.getInstance().getReference("locations");
    private static DatabaseReference itemDatabase = FirebaseDatabase.getInstance().getReference("items");

    public static void updateLocations(){
        Query locationQuery = locationDatabase;
        locationQuery.addValueEventListener(new ValueEventListener() {
            Model model = Model.INSTANCE;

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                model.clearLocations();
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    Location location = snapshot.getValue(Location.class);
                    model.add(location);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError){
                Log.e("onCancelled", "Error while reading from database", databaseError.toException());
            }
        });
    }

    public static void updateDonations(){
        Query donationQuery = itemDatabase;
        donationQuery.addValueEventListener(new ValueEventListener() {
            Model model = Model.INSTANCE;

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                model.clearDonations();
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    Item item = snapshot.getValue(Item.class);
                    model.add(item);
                    System.out.println("Adding testing" + item.getValue());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError){
                Log.e("onCancelled", "Error while reading from database", databaseError.toException());
            }
        });

        System.out.println("INVENTORY SIZE" +  Model.INSTANCE.getDonations().size());
    }
}
