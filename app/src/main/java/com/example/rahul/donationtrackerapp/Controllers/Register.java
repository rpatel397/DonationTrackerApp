package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class Register extends AppCompatActivity {
    public static List<String> legalAccounts = Arrays.asList("USER", "Location Employee", "Admin");

    private EditText name;
    private EditText id;
    private EditText password;
    private Button register_button;
    private Spinner accountType;
    private String account;


    public static int findPosition(String code) {
        int i = 0;
        while (i < legalAccounts.size()) {
            if (code.equals(legalAccounts.get(i))) return i;
            ++i;
        }
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        name = findViewById(R.id.editText_Name);
        password = findViewById(R.id.editText_Password);
        id =  findViewById(R.id.editText_ID);
        register_button = findViewById(R.id.button_registrationLogin);
        accountType = findViewById(R.id.spinner_AccountType);



        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, legalAccounts);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountType.setAdapter(adapter);
    }


    public void registerOnPressed(View view){
        if (name.getText().toString().equals("user") && password.getText().toString().equals("pass") && id.getText().toString().equals("FB54")){
            Toast.makeText(Register.this,"Registration Successful",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Register.this, UserScreen.class));
        }else if (name.getText().toString().equals("") || password.getText().toString().equals("") || id.getText().toString().equals("")) {
            Toast.makeText(Register.this, "Complete all fields", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Register.this, Register.class));
        }else {
            Toast.makeText(Register.this, "Registration Failed", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Register.this, Register.class));
            finish();
        }
    }

    public void cancelOnPressed(View view) {
        Intent intent = new Intent(Register.this, WelcomeScreen.class);
        setContentView(R.layout.activity_welcome_screen);
        startActivity(intent);

    }



}
