package com.example.mobileexplab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class FourthActivity extends AppCompatActivity {
    Button back;
    RecyclerView recycleview;
    ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        back = findViewById(R.id.back5);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        recycleview= findViewById(R.id.recycleViewId);
        contactAdapter = new ContactAdapter(
                this,
                Arrays.asList("David","Chetan","Akumlong"),
                Arrays.asList("1234567891","4561234567","7891234567"),
                new int[]{R.drawable.p1,R.drawable.p2,R.drawable.p3}
        );
        recycleview.setAdapter(contactAdapter);
        recycleview.setLayoutManager(new LinearLayoutManager(this));
    }
}
