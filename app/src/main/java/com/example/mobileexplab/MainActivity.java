package com.example.mobileexplab;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button back1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        back1 = findViewById(R.id.back1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Button b;
        RadioButton r1,r2,r3,r4,r5;
        final EditText e;
        final TextView t;

        b= (Button) findViewById(R.id.button);
        e=(EditText) findViewById(R.id.editText);
        t=(TextView) findViewById(R.id.textView);
        r1=(RadioButton) findViewById(R.id.radioButton);
        r2=(RadioButton) findViewById(R.id.radioButton1);
        r3=(RadioButton) findViewById(R.id.radioButton2);
        r4=(RadioButton) findViewById(R.id.radioButton3);
        r5=(RadioButton) findViewById(R.id.radioButton4);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double d= Double.parseDouble(e.getText().toString());
                if(r1.isChecked()){
                    t.setText(String.format("%.2f",((d-32)*5/9))+"C");
                }
                else if(r2.isChecked()){
                    t.setText(String.valueOf(d*100)+" ml");
                }
                else if(r3.isChecked()){
                    t.setText(String.valueOf(d*12)+"in");
                }
                else if(r4.isChecked()){
                    t.setText(String.valueOf(d*1000)+"m");
                }
                else if(r5.isChecked()){
                    t.setText(String.valueOf(d*2.54)+"cm");
                }
                else{
                    t.setText(String.valueOf("Invalid Input"));
                }
            }
        });
    }
}