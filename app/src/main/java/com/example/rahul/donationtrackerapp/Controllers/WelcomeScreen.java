package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
//import android.widget.Button;

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
 * Class that controls the welcome screen
 */
public class WelcomeScreen extends AppCompatActivity {
    private static final String TAG = "Donation_Tracker";
    private boolean startUp = true;
    private final DatabaseReference locationDatabase = FirebaseDatabase.getInstance().getReference
            ("locations");

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
     * implements login button
     */
    public void loginOnPressed(View view) {
        Intent intent = new Intent(this, Login.class);

        startActivity(intent);
    }

    /**
     * @param view
     * implements the register button
     */
    public void registerOnPressed(View view) {
        Intent intent = new Intent(this, Register.class);

        startActivity(intent);
    }

    private void updateLocationDatabase() {
        try {
            Resources res = getResources();
            InputStream is = res.openRawResource(R.raw.locationdata);

            BufferedReader br = new BufferedReader
                    (new InputStreamReader(is, StandardCharsets.UTF_8));

            String line;
            br.readLine();
            while ((line  = br.readLine()) != null) {

                final String[] tokens = line.split(",");

                int key = Integer.parseInt(tokens[0]);
                DatabaseReference userIdReference = locationDatabase.child(String.valueOf(key));
                userIdReference.addListenerForSingleValueEvent
                        (new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (!snapshot.exists()) {

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

    private void addNewLocation(String[] tokens){
        int key = Integer.parseInt(tokens[0]);
        double latitude = Double.parseDouble(tokens[2]);
        double longitude = Double.parseDouble(tokens[3]);
        int zip = Integer.parseInt(tokens[7]);
        String str = tokens[0].replaceAll("\\s+","");
        String str2 = str.toUpperCase();
        locationType type = locationType.valueOf(str2);

        Location location  = new Location(key,       tokens[1], latitude, longitude,
                                          tokens[4], tokens[5], tokens[6],  zip,
                                          type     , tokens[9], tokens[10]);
        DatabaseReference userIdReference = locationDatabase.child(String.valueOf(key));
        userIdReference.setValue(location);

    }
}