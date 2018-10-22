package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

public class WelcomeScreen extends AppCompatActivity {
    public static String TAG = "Donation_Tracker";
    public static boolean startUp = true;
    private DatabaseReference locationDatabase = FirebaseDatabase.getInstance().getReference("locations");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(startUp){
            updateLocationDatabase();
        }
        setContentView(R.layout.activity_welcome_screen);
    }

    public void loginOnPressed(View view) {
        Intent intent = new Intent(this, Login.class);
        Button loginButton = (Button) findViewById(R.id.loginbutton);
        startActivity(intent);
    }

    public void registerOnPressed(View view) {
        Intent intent = new Intent(this, Register.class);
        Button registerButton = (Button) findViewById(R.id.registerbutton);
        startActivity(intent);
    }

    private void updateLocationDatabase() {
        try {
            InputStream is = getResources().openRawResource(R.raw.locationdata);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                final String[] tokens = line.split(",");

                int key = Integer.parseInt(tokens[0]);
                locationDatabase.child(String.valueOf(key)).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            //location already exists we do nothing.
                            //could change this to update the information
                        } else {
                            addNewLocation(tokens);
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError test){
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
        locationType type = locationType.valueOf(tokens[8].replaceAll("\\s+","").toUpperCase());

        Location location  = new Location(key,       tokens[1], latitude, longitude,
                                          tokens[4], tokens[5], tokens[6],  zip,
                                          type     , tokens[9], tokens[10]);
        locationDatabase.child(String.valueOf(key)).setValue(location);
    }
}