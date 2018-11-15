package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.rahul.donationtrackerapp.Model.User;


public class Login extends AppCompatActivity {

    private EditText usernameID;
    private EditText passwordField;
    private Button login_button;
    private DatabaseReference userDatabase = FirebaseDatabase.getInstance().getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();

        /*
        //auto login for convenience
        usernameID.setText("Bailey");
        passwordField.setText("Bailey");
        */
    }

    public void LoginButton() {
        usernameID = findViewById(R.id.editText_username);
        passwordField = findViewById(R.id.editText_password);
        login_button = findViewById(R.id.button_login);
    }

    public void loginOnPressed(View view) {
        if (usernameID.getText().toString().equals("") || passwordField.getText().toString().equals("")) {
            Toast.makeText(Login.this, "Complete all fields", Toast.LENGTH_SHORT).show();
            usernameID.setText("");
            passwordField.setText("");
        }else {
            String userID = usernameID.getText().toString();
            userDatabase.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        String password = snapshot.child("password").getValue().toString();
                        String hashPassword = User.passwordHash(passwordField.getText().toString());
                        Toast.makeText(Login.this, password, Toast.LENGTH_SHORT).show();

                        if (snapshot.child("accountState").getValue().equals(false)){
                            Toast.makeText(Login.this, "Account is Locked. Contact Admin", Toast.LENGTH_SHORT).show();
                        }
                         else if (password.equals(hashPassword)){
                            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Login.this, UserScreen.class));
                        } else {
                            Integer attemptsRemaining = 3 - Integer.valueOf(snapshot.child("loginAttempts").getValue().toString());
                            if (attemptsRemaining < 1){
                                Toast.makeText(Login.this, "Login Attempt Failed. Account is now Locked", Toast.LENGTH_SHORT).show();
                                userDatabase.child(usernameID.getText().toString()).child("accountState").setValue(false);
                            }
                            Toast.makeText(Login.this, "Login Attempt Failed. " + attemptsRemaining + " tries remaining", Toast.LENGTH_SHORT).show();
                            Integer newAttempts = Integer.valueOf(snapshot.child("loginAttempts").getValue().toString()) + 1;
                            userDatabase.child(usernameID.getText().toString()).child("loginAttempts").setValue(newAttempts);
                        }
                    } else {
                        Toast.makeText(Login.this, "User doesn't exist, try again", Toast.LENGTH_SHORT).show();
                        usernameID.setText("");
                        passwordField.setText("");
                    }
                }
                @Override
                public void onCancelled(DatabaseError test){
                }
            });
        }
    }

    public void cancelOnPressed(View view) {
        Intent backToWelcome = new Intent(Login.this, WelcomeScreen.class);
        finish();
        startActivity(backToWelcome);
    }
}