package com.example.moneymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loggedin extends AppCompatActivity {
   public void forward(View view) {
     Intent intent = new Intent(getApplicationContext(),registeration.class);
     startActivity(intent);
    }
    EditText username;
    EditText p1;
    Button login;
    databasehelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggedin);
        db = new databasehelper(this);
        username = findViewById(R.id.username);
        p1 = findViewById(R.id.password);
        login = (Button) findViewById(R.id.login2);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String email = username.getText().toString();
                String password = p1.getText().toString();
                Boolean chkemailpass = db.emailpassword(email,password);
                if (username.getText().toString().equals("") || p1.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),"A username and password are required",Toast.LENGTH_SHORT).show();
                }else if(chkemailpass){
                    Toast.makeText(getApplicationContext(),"successful",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),newpage.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"wrong email or password",Toast.LENGTH_SHORT).show();
                }
            }
         });
    }
}