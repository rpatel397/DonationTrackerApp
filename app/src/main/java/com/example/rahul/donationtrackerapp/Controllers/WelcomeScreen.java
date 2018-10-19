package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import Model.SimpleModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class WelcomeScreen extends AppCompatActivity {
    public static String TAG = "Donation_Tracker";
    public static boolean startUp = true;

    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(startUp){
            readSDFile();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        sharedPreferences = getSharedPreferences("myprefs", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_1", "pass");
        editor.commit();
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

    private void readSDFile() {
        SimpleModel model =  SimpleModel.INSTANCE;

        try {
            InputStream is = getResources().openRawResource(R.raw.locationdata);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");

                int key = Integer.parseInt(tokens[0]);
                double latitude = Double.parseDouble(tokens[2]);
                double longitude = Double.parseDouble(tokens[3]);
                int zip = Integer.parseInt(tokens[7]);

                model.addItem(new Location(key,       tokens[1], latitude, longitude,
                                               tokens[4], tokens[5], tokens[6],  zip,
                                               tokens[8], tokens[9], tokens[10]));
                }
            br.close();
            startUp = false;

        } catch (IOException e) {
            Log.e(WelcomeScreen.TAG, "error reading assets", e);
        }
    }
}