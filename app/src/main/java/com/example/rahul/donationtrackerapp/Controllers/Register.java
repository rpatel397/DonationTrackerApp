package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.Context;

import java.util.Arrays;
import java.util.List;

public class Register extends AppCompatActivity  {

    public static List<String> legalAccounts = Arrays.asList("USER", "Location Employee", "Admin", "Manager");

    private EditText name;
    private EditText id;
    private EditText password;
    private Button register_button;
    private Spinner accountType;
    private String account;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.editText_Name);
        password = findViewById(R.id.editText_Password);
        id =  findViewById(R.id.editText_ID);
        register_button = findViewById(R.id.button_registrationLogin);
        accountType = findViewById(R.id.spinner_AccountType);
        sharedPreferences = getSharedPreferences("myprefs", Context.MODE_PRIVATE);

        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, legalAccounts);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountType.setAdapter(adapter);
    }


    public void registerOnPressed(View view){
        if (name.getText().toString().equals("") || password.getText().toString().equals("") || id.getText().toString().equals("")) {
            Toast.makeText(Register.this, "Complete all fields", Toast.LENGTH_SHORT).show();
        }else {
            if (sharedPreferences.contains(id.getText().toString() + "_0")) {
                Toast.makeText(Register.this, "User already registered", Toast.LENGTH_SHORT).show();
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(id.getText().toString() + "_0", name.getText().toString());
                editor.putString(id.getText().toString() + "_1", password.getText().toString());
                editor.putString(id.getText().toString() + "_2", accountType.getSelectedItem().toString());
                editor.commit();
                Toast.makeText(Register.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Register.this, UserScreen.class));
            }
        }
    }

    public void onCancelPressed(View view) {
        Intent intent = new Intent(Register.this, WelcomeScreen.class);
        setContentView(R.layout.activity_welcome_screen);
        startActivity(intent);
    }
}
