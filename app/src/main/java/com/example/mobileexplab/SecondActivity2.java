package com.example.mobileexplab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity2 extends AppCompatActivity {
    Button back3;
    TextView r1,r2,r3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        back3 = findViewById(R.id.back3);
        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        r1 = findViewById(R.id.text1);
        r2 = findViewById(R.id.text2);
        r3 = findViewById(R.id.text3);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        String str1 = intent.getStringExtra("message_key1");
        String str2 = intent.getStringExtra("message_key2");
        r1.setText(str);
        r2.setText(str1);
        r3.setText(str2);
    }

}
