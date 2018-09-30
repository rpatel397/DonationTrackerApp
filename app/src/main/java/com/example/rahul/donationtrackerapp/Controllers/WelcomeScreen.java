package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class WelcomeScreen extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        sharedPreferences = getSharedPreferences("myprefs", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_0", "pass");
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

}