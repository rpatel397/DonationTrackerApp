package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.rahul.donationtrackerapp.Model.Location;
import com.example.rahul.donationtrackerapp.Model.locationType;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * class that operates welcome screen
 */
public class WelcomeScreen extends AppCompatActivity {
    private static final String TAG = "Donation_Tracker";
    private static boolean startUp = true;
    private DatabaseReference locationDatabase = FirebaseDatabase.getInstance()
            .getReference("locations");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(startUp){
            updateLocationDatabase();
            PullFromDatabase.updateLocations();
            PullFromDatabase.updateDonations();
        }
        setContentView(R.layout.activity_welcome_screen);
    }

    /**
     * @param view
     * on click logs the user in
     */
    public void loginOnPressed(View view) {
        Intent intent = new Intent(this, Login.class);
        Button loginButton = findViewById(R.id.loginbutton);
        startActivity(intent);
    }

    /**
     * @param view
     * on click registers the user
     */
    public void registerOnPressed(View view) {
        Intent intent = new Intent(this, Register.class);
        Button registerButton = findViewById(R.id.registerbutton);
        startActivity(intent);
    }

    /**
     * method that updates the location in the database
     */
    private void updateLocationDatabase() {
        try {
            InputStream is = getResources().openRawResource(R.raw.locationdata);
            BufferedReader br = new BufferedReader(new InputStreamReader
                    (is, StandardCharsets.UTF_8));

            String line = br.readLine();
            br.readLine();
            while ((line) != null) {
                final String[] tokens = line.split(",");

                int key = Integer.parseInt(tokens[0]);
                locationDatabase.child(String.valueOf(key)).addListenerForSingleValueEvent
                        (new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            //location already exists we do nothing.
                            //could change this to update the information
                        } else {
                            addNewLocation(tokens);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError test){
                    }
                });
            }
            br.close();
            startUp = false;

        } catch (IOException e) {
            Log.e(WelcomeScreen.TAG, "error reading assets", e);
        }
    }

    /**
     * @param tokens
     * adds new location
     */
    private void addNewLocation(String[] tokens){
        int key = Integer.parseInt(tokens[0]);
        double latitude = Double.parseDouble(tokens[2]);
        double longitude = Double.parseDouble(tokens[3]);
        int zip = Integer.parseInt(tokens[7]);
        locationType type = locationType.valueOf(tokens[8].replaceAll("\\s+","").toUpperCase());

        Location location  = new Location(key,       tokens[1], latitude, longitude,
                                          tokens[4], tokens[5], tokens[6],  zip,
                                          type     , tokens[9], tokens[10]);
        locationDatabase.child(String.valueOf(key)).setValue(location);
    }
}