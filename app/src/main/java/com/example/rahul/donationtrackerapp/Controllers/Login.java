package com.example.rahul.donationtrackerapp.Controllers;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login_button;
    private Button canel_button;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
        sharedPreferences = getSharedPreferences("myprefs", Context.MODE_PRIVATE);
    }


    public void LoginButton() {
        username = findViewById(R.id.editText_username);
        password = findViewById(R.id.editText_password);
        login_button = findViewById(R.id.button_login);
    }

    public void loginOnPressed(View view) {
        if (sharedPreferences.contains(username.getText().toString() + "_1")) {
            if (password.getText().toString().equals(sharedPreferences.getString(username.getText().toString() + "_1", null))) {
                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Login.this, UserScreen.class));
            } else {
                Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                password.setText("");
            }
        } else {
            Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
            password.setText("");
        }
    }

    public void cancelOnPressed(View view) {
        Intent intent = new Intent(Login.this, WelcomeScreen.class);
        setContentView(R.layout.activity_welcome_screen);
        startActivity(intent);
    }
}