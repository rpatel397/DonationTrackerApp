package com.example.rahul.donationtrackerapp.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Login extends AppCompatActivity {


    private EditText username;
    private EditText password;
    private Button login_button;


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

        login_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (username.getText().toString().equals("user") && password.getText().toString().equals("pass")) {
                            {
                                Toast.makeText(Login.this, "Username and password is correct",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Login.this, WelcomeScreen.class);
                                startActivity(intent);


                            }
                        } else if ((username.getText().toString().equals("user") || password.getText().toString().equals("pass"))) {
                            Toast.makeText(Login.this, "Username or password is NOT correct",
                                    Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(Login.this, WelcomeScreen.class);
                            startActivity(intent);

                        }
                    }
                }
        );
    }







}
