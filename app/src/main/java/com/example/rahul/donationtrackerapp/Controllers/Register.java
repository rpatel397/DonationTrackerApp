package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rahul.donationtrackerapp.Model.User;
import com.example.rahul.donationtrackerapp.Model.*;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity  {

    private EditText nameField, idField, passwordField;
    private Button register_button;
    private Spinner accountTypeSpinner;
    private DatabaseReference userDatabase = FirebaseDatabase.getInstance().getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameField = findViewById(R.id.editText_Name);
        passwordField = findViewById(R.id.editText_Password);
        idField =  findViewById(R.id.editText_ID);
        register_button = findViewById(R.id.button_registrationLogin);
        accountTypeSpinner = findViewById(R.id.spinner_AccountType);

        ArrayAdapter<accountType> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, accountType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountTypeSpinner.setAdapter(adapter);
    }


    public void registerOnPressed(View view){
        String name = nameField.getText().toString();
        String password = passwordField.getText().toString();
        String userID = idField.getText().toString();
        accountType type = (accountType) accountTypeSpinner.getSelectedItem();

        if (name.equals("") || password.equals("") || userID.equals("")) {
            Toast.makeText(Register.this, "Complete all fields", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Register.this, Register.class));
        }else {
            if (userDatabase.child(userID) != null){
                Toast.makeText(Register.this, "User already registered", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(Register.this, Register.class));
            }
            User user = new User(name, userID, password, true, type);
            userDatabase.child(userID).setValue(user);
        }
    }

    public void onCancelPressed(View view) {
        Intent intent = new Intent(Register.this, WelcomeScreen.class);
        setContentView(R.layout.activity_welcome_screen);
        startActivity(intent);
    }
}
