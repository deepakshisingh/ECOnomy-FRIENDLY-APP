package com.example.moneymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registeration extends AppCompatActivity {
    databasehelper db;
    EditText name;
    EditText email;
    EditText mobilenumber;
    EditText password;
    EditText cpassword;
    Button next;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        db = new databasehelper(this);
        name = findViewById(R.id.firstname);
        email = findViewById(R.id.email);
        mobilenumber = findViewById(R.id.mobilenumber);
        password = findViewById(R.id.password);
        cpassword = findViewById(R.id.cpassword);
        next = (Button) findViewById(R.id.next);
        login = (Button) findViewById(R.id.login2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(registeration.this, loggedin.class);
                startActivity(i);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = name.getText().toString();
                String s2 = email.getText().toString();
                String s3 = mobilenumber.getText().toString();
                String s4 = password.getText().toString();
                String s5 = cpassword.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("")) {
                        Toast.makeText(getApplicationContext(), "fields are empty", Toast.LENGTH_SHORT).show();
                    } else if (s4.equals(s5)) {
                        Boolean chkemail = db.chkemail(s2);
                        if (chkemail) {
                            Boolean insert = db.imsert(s2, s4);
                            if (insert) {
                                Toast.makeText(getApplicationContext(), "registered successfully", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "email already exists", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Confirm password correctly", Toast.LENGTH_SHORT).show();
                    }
                }
        });

    }

}