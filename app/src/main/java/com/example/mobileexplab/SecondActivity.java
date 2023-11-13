package com.example.mobileexplab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    Button back2,button2;
    EditText e1,e2,e3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        back2 = findViewById(R.id.back2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        button2 = findViewById(R.id.button2);
        e1=findViewById(R.id.editTextTextPersonName);
        e2=findViewById(R.id.editTextTextPersonName2);
        e3=findViewById(R.id.editTextTextPersonName3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = e1.getText().toString();
                String str1 = e2.getText().toString();
                String str2 = e3.getText().toString();
                Intent intent = new Intent(SecondActivity.this, SecondActivity2.class);
                intent.putExtra("message_key", str);
                intent.putExtra("message_key1", str1);
                intent.putExtra("message_key2", str2);
                startActivity(intent);
            }
        });

    }
}
