package com.example.PASFootball;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ControlClass extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        if (sharedPreferences.getString("user", "").isEmpty() ||
        sharedPreferences.getString("user", "").equalsIgnoreCase("")){
            //login dulu
            startActivity(new Intent(getApplicationContext(),Login.class));
            finish();
        }else{
            startActivity(new Intent(getApplicationContext(), MainMenu.class));
            finish();
        }
    }
}