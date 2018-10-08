package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);
    }

    public void logoutOnPressed(View view) {
        Intent intent = new Intent(this, WelcomeScreen.class);
        Button loginButton = (Button) findViewById(R.id.logoutButton);
        startActivity(intent);
        finish();
    }

    public void locationListOnPressed(View view) {
        Intent intent = new Intent(this, LocationList.class);
        Button locationButton = (Button) findViewById(R.id.locationButton);
        startActivity(intent);
    }
}
