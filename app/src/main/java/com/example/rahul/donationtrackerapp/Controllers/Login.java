package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.rahul.donationtrackerapp.Model.User;

/**
 *  Provides main login functionality for app.
 *  Authenticates users by checking if the user exists in the database
 *  and then validates the password. If the password is correct and the
 *  user is valid, the person is allowed access into the system.
 */
public class Login extends AppCompatActivity {

    private EditText usernameID;
    private EditText passwordField;
    private final DatabaseReference userDatabase =
            FirebaseDatabase.getInstance().getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameID = findViewById(R.id.editText_username);
        passwordField = findViewById(R.id.editText_password);
    }


    /**
     * Logs the user into app. If the account is locked the user is notified. An incorrect password
     * attempt increments the loginAttempts and potentially locks the account. Upon successful
     * login the user is granted access into the app.
     * @param view current app view
     */
    public void loginOnPressed(View view) {
        final Editable enteredUsername = usernameID.getText();
        final Editable enteredPassword = passwordField.getText();

        if ("".equals(enteredUsername.toString())
                || "".equals(enteredPassword.toString())) {
            Toast incompleteField = Toast.makeText(Login.this,
                    "Complete all fields", Toast.LENGTH_SHORT);
            incompleteField.show();
            usernameID.setText("");
            passwordField.setText("");
        }else {
            String userID = enteredUsername.toString();
            DatabaseReference userIDReference = userDatabase.child(userID);
            userIDReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        DataSnapshot passwordChild = snapshot.child("password");
                        String password = (String) passwordChild.getValue();
                        String hashPassword = User.passwordHash(enteredPassword.toString());
                        DataSnapshot accountStateChild = snapshot.child("accountState");
                        Boolean accountState = (Boolean) accountStateChild.getValue();
                        if ((accountState != null) && accountState.equals(false)){
                            Toast lockedAccount = Toast.makeText(Login.this,
                                    "Account is Locked. Contact Admin", Toast.LENGTH_SHORT);
                            lockedAccount.show();
                        }
                         else if ((password != null) && password.equals(hashPassword)){
                            Toast successfulLogin = Toast.makeText(Login.this,
                                    "Login Successful", Toast.LENGTH_SHORT);
                            successfulLogin.show();
                            startActivity(new Intent(Login.this, UserScreen.class));
                        } else {
                            Toast failedLogin = Toast.makeText(Login.this,
                                    "Login Failed", Toast.LENGTH_SHORT);
                            failedLogin.show();
                            usernameID.setText("");
                            passwordField.setText("");

                            /*
                            DataSnapshot loginAttemptsChild = snapshot.child("loginAttempts");
                            Integer attemptsRemaining =
                                    3 - Integer.valueOf((String) loginAttemptsChild.getValue());
                            if (attemptsRemaining < 1){
                                Toast loginFailedLocked = Toast.makeText(Login.this,
                                        "Login Attempt Failed. Account is now Locked",
                                        Toast.LENGTH_SHORT);
                                loginFailedLocked.show();

                                DatabaseReference usernameReference =
                                        userDatabase.child(enteredUsername.toString());
                                DatabaseReference accountStateReference =
                                        usernameReference.child("accountState");
                                accountStateReference.setValue(false);
                            }

                            System.out.println("LOGIN TESTING");
                            Toast loginFailed = Toast.makeText(Login.this,
                                    "Login Attempt Failed. " + attemptsRemaining +
                                            " tries remaining", Toast.LENGTH_SHORT);
                            loginFailed.show();

                            Integer newAttempts =
                                    Integer.valueOf((String) loginAttemptsChild.getValue() + 1);
                            DatabaseReference usernameReference =
                                    userDatabase.child(enteredUsername.toString());
                            DatabaseReference loginAttemptsReference =
                                    usernameReference.child("loginAttempts");
                            loginAttemptsReference.setValue(newAttempts);
                            */
                        }
                    } else {
                        Toast noUser = Toast.makeText(Login.this,
                                "User doesn't exist, try again", Toast.LENGTH_SHORT);
                        noUser.show();
                        usernameID.setText("");
                        passwordField.setText("");
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError test){
                    Log.e("DATABASE", test.toString());
                }
            });
        }
    }

    /**
     * Cancels login attempt. Takes user back to WelcomeScreen
     * @param view current app view
     */
    public void cancelOnPressed(View view) {
        Intent backToWelcome = new Intent(Login.this, WelcomeScreen.class);
        finish();
        startActivity(backToWelcome);
    }
}