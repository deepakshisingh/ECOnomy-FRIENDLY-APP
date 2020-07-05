package com.example.moneymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//import com.example.moneymanagement.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    public void nextnow(View view) {
        Intent intent= new Intent(getApplicationContext(),registeration.class);
        startActivity(intent);
    }
    public void gotonext(View view) {
        Intent intent = new Intent(getApplicationContext(), loggedin.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}