package com.example.moneymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class newpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpage);
        ListView listview = findViewById(R.id.listview);
        String[] values = new String[] {
                "DAILY LOG","BUDGET","PREVIOUS EXPENSE OVERVIEW","MANAGE LIMITS AND NOTIFICATIONS","LOGOUT",
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1,values);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(view.getContext(), daily.class);
                    intent.putExtra("name","DAILY LOG");
                    startActivity(intent);
                }
                if (i==1) {
                    Intent intent = new Intent(view.getContext(),budget.class);
                    intent.putExtra("name","BUDGET");
                    startActivity(intent);
                }
                if (i==2) {
                    Intent intent = new Intent(view.getContext(),previous.class);
                    intent.putExtra("name","PREVIOUS EXPENSE OVERVIEW");
                    startActivity(intent);
                }
                if (i==3) {
                    Intent intent = new Intent(view.getContext(),manage.class);
                    intent.putExtra("name","MANAGE LIMITS AND NOTIFICATION");
                    startActivity(intent);
                }
                if (i==4) {
                    Intent intent = new Intent(view.getContext(),logout.class);
                    intent.putExtra("name","LOGOUT");
                    startActivity(intent);
                }

            }
        });
    }
}