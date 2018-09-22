package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

}