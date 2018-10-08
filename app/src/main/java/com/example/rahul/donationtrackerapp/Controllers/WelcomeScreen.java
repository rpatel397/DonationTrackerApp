package com.example.rahul.donationtrackerapp.Controllers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class WelcomeScreen extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        sharedPreferences = getSharedPreferences("myprefs", Context.MODE_PRIVATE);
        readSDFile();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_1", "pass");
        editor.commit();
    }

    public void loginOnPressed(View view) {
        Intent intent = new Intent(this, Login.class);
        Button loginButton = (Button) findViewById(R.id.loginbutton);
        startActivity(intent);
    }

    public void registerOnPressed(View view) {
        Intent intent = new Intent(this, Register.class);
        Button registerButton = (Button) findViewById(R.id.registerbutton);
        startActivity(intent);
    }

    private void readSDFile() {
        SimpleModel model = SimpleModel.INSTANCE;

        try {
            //Open a stream on the raw file
            InputStream is = getResources().openRawResource(R.raw.locationdata);
            //From here we probably should call a model method and pass the InputStream
            //Wrap it in a BufferedReader so that we get the readLine() method
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            String line;
            br.readLine(); //get rid of header line
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");

                int key = Integer.parseInt(tokens[0]);
                double latitutude = Double.parseDouble(tokens[2]);
                double longitude = Double.parseDouble(tokens[3]);
                int zip = Integer.parseInt(tokens[7]);

                model.addItem(new LocationItem(key,       tokens[1], latitutude, longitude,
                                               tokens[4], tokens[5], tokens[6],  zip,
                                               tokens[8], tokens[9], tokens[10]));
            }
            br.close();
        } catch (IOException e) {

        }

    }

}