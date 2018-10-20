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

import com.example.rahul.donationtrackerapp.Model.User;
import com.example.rahul.donationtrackerapp.Model.*;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Register extends AppCompatActivity  {

    public static List<String> legalAccounts = Arrays.asList("USER", "Location Employee", "Admin", "Manager");

    private EditText nameField, idField, passwordField;
    private Button register_button;
    private Spinner accountTypeSpinner;
    private String account;
    private SharedPreferences sharedPreferences;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameField = findViewById(R.id.editText_Name);
        passwordField = findViewById(R.id.editText_Password);
        idField =  findViewById(R.id.editText_ID);
        register_button = findViewById(R.id.button_registrationLogin);
        accountTypeSpinner = findViewById(R.id.spinner_AccountType);

        sharedPreferences = getSharedPreferences("myprefs", Context.MODE_PRIVATE);

        ArrayAdapter<accountType> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, accountType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountTypeSpinner.setAdapter(adapter);
    }


    public void registerOnPressed(View view){
        String name = nameField.getText().toString();
        String password = passwordField.getText().toString();
        String id = idField.getText().toString();
        accountType type = (accountType) accountTypeSpinner.getSelectedItem();

        if (name.equals("") || password.equals("") || id.equals("")) {
            Toast.makeText(Register.this, "Complete all fields", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Register.this, Register.class));
        }else {

            DatabaseReference usersRef = ref.child("users");
            Map<String, User> users = new HashMap<>();

            users.put(id.toString(), new User(name, id, password, true, type));


            /*
            if (sharedPreferences.contains(id.getText().toString() + "_0")) {
                Toast.makeText(Register.this, "User already registered", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Register.this, Register.class));
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(id.getText().toString() + "_0", name.getText().toString());
                editor.putString(id.getText().toString() + "_1", password.getText().toString());
                editor.putString(id.getText().toString() + "_2", accountType.getSelectedItem().toString());
                editor.commit();
                Toast.makeText(Register.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Register.this, UserScreen.class));
            }
            */
        }
    }

    public void onCancelPressed(View view) {
        Intent intent = new Intent(Register.this, WelcomeScreen.class);
        setContentView(R.layout.activity_welcome_screen);
        startActivity(intent);
    }
}
