package com.example.rahul.donationtrackerapp.Controllers;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login_button;
    private Button canel_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();



    }


    public void LoginButton() {
        username = findViewById(R.id.editText_username);
        password = findViewById(R.id.editText_password);
        login_button = findViewById(R.id.button_login);


    }

    public void loginOnPressed(View view) {
        Intent intent = new Intent(Login.this, WelcomeScreen.class);
        if (username.getText().toString().equals("user") && password.getText().toString().equals("pass")) {
            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
            startActivity(intent);
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




