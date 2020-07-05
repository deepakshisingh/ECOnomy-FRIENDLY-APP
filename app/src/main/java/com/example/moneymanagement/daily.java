package com.example.moneymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class daily extends AppCompatActivity {
    datahelper db;
    EditText sno;
    EditText item;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
        Intent intent = getIntent();
        String name= intent.getStringExtra("name");
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
        db = new datahelper(this);
        sno = findViewById(R.id.sno);
        item = findViewById(R.id.item);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = sno.getText().toString();
                String s2 = item.getText().toString();
                boolean insert = db.insertinfo(s1,s2);
                if (insert)
                    Toast.makeText(getApplicationContext(), "ENTERED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                else
                        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();

                }
        });




    }
}