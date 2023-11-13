package com.example.mobileexplab;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.nio.BufferUnderflowException;

public class MapActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmap);
        EditText editTextsour = findViewById(R.id.source);
        EditText editTextdest = findViewById(R.id.destination);
        Button button = findViewById(R.id.submitlocation);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source = editTextsour.getText().toString();
                String destination = editTextdest.getText().toString();
                if(source.equals("") && destination.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter both locations",Toast.LENGTH_SHORT).show();

                }
                else{
                    Uri uri = Uri.parse("https://www.google.com/maps/dir/"+source+"/"+destination);
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });

    }
}
