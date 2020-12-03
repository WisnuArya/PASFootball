package com.example.PASFootball;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class Login extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    EditText txtuser;
    EditText txtpass;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pref = getSharedPreferences("login", MODE_PRIVATE);
        txtuser = (EditText)findViewById(R.id.txtuser);
        txtpass = (EditText)findViewById(R.id.txtpass);
        btnlogin = (Button)findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtuser.getText().toString().equalsIgnoreCase("Admin")
                        && txtpass.getText().toString().equalsIgnoreCase("Admin")){
                    //saving to sp
                    editor = pref.edit();
                    editor.putString("user", txtuser.getText().toString());
                    editor.putString("status", "login");
                    editor.apply();
                    //to main menu
                    startActivity(new Intent(getApplicationContext(), com.example.PASFootball.MainMenu.class));
                    finish();
                }

            }

        });
    }

}
