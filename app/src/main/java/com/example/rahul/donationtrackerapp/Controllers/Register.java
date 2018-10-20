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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        String userID = idField.getText().toString();
        if (nameField.getText().toString().equals("") || passwordField.getText().toString().equals("") || idField.getText().toString().equals("")) {
            Toast.makeText(Register.this, "Complete all fields", Toast.LENGTH_SHORT).show();
            Intent restartRegister = new Intent(Register.this, Register.class);
            restartRegister.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            overridePendingTransition(0, 0);
            finish();
            startActivity(restartRegister);
            overridePendingTransition(0, 0);
        }else {
            userDatabase.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        Toast.makeText(Register.this, "User already registered", Toast.LENGTH_SHORT).show();
                        Intent restartRegister = new Intent(Register.this, Register.class);
                        restartRegister.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        overridePendingTransition(0, 0);
                        finish();
                        startActivity(restartRegister);
                        overridePendingTransition(0, 0);
                    } else {
                        createNewUser();
                        Toast.makeText(Register.this, "User registered, logging in...", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this, UserScreen.class));
                    }
                }
                @Override
                public void onCancelled(DatabaseError test){
                }
            });
        }
    }

    public void onCancelPressed(View view) {
        Intent intent = new Intent(Register.this, WelcomeScreen.class);
        finish();
        startActivity(intent);
    }

    public void createNewUser(){
        String name = nameField.getText().toString();
        String password = passwordField.getText().toString();
        String userID = idField.getText().toString();
        accountType type = (accountType) accountTypeSpinner.getSelectedItem();

        User user = new User(name, userID, password, true, type);
        userDatabase.child(userID).setValue(user);
    }
}
