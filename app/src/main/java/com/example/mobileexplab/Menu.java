package com.example.mobileexplab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.mobileexplab.databinding.ActivityMainBinding;


public class Menu extends AppCompatActivity {
    //ActivityMainBinding binding;
    GridView gd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.mainlayout);
        //animated background
        ConstraintLayout constraintLayout = findViewById(R.id.mainlayout);
        AnimationDrawable animationDrawable = (AnimationDrawable)constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();
        //animation
        gd=findViewById(R.id.gridView);

        String[] flowerName = {"Torch","Calculator","GMAP","Metric Conv.","Student Info.","Emp Manage",
                "Contact App","Music","Messenger","Downloader","Swiper","ImgText","GeoLock"};
        int[] flowerImages = {R.drawable.torchicon, R.drawable.calicon, R.drawable.gomap, R.drawable.metricconicon,R.drawable.stdicon,
                R.drawable.empicon,R.drawable.contacticon,
                R.drawable.music_icon,R.drawable.messengericon, R.drawable.downicon,
                R.drawable.swipericon,R.drawable.imgicon,R.drawable.geoicon};

        GridAdapter gridAdapter = new GridAdapter(Menu.this,flowerName,flowerImages);
        gd.setAdapter(gridAdapter);

        gd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(flowerName[position] =="Metric Conv."){
                    Intent intent =new Intent(Menu.this,MainActivity.class);
                    startActivity(intent);
                }
                else if(flowerName[position] =="Student Info."){
                    Intent intent =new Intent(Menu.this,SecondActivity.class);
                    startActivity(intent);
                }
                else if(flowerName[position] =="Emp Manage"){
                    Intent intent =new Intent(Menu.this,ThirdActivity.class);
                    startActivity(intent);
                }
                else if(flowerName[position] =="Contact App"){
                    Intent intent =new Intent(Menu.this,FourthActivity.class);
                    startActivity(intent);
                }
                else if(flowerName[position] =="Music"){
                    Intent intent =new Intent(Menu.this,FifthActivity.class);
                    startActivity(intent);
                }
                else if(flowerName[position] =="Messenger"){
                    Intent intent =new Intent(Menu.this,SixthActivity.class);
                    startActivity(intent);
                }
                else if(flowerName[position] =="Downloader"){
                    Intent intent =new Intent(Menu.this,SevenActivity.class);
                    startActivity(intent);
                }
                else if(flowerName[position] =="Swiper"){
                    Intent intent =new Intent(Menu.this,EightActivity.class);
                    startActivity(intent);
                }
                else if(flowerName[position] =="ImgText"){
                    Intent intent =new Intent(Menu.this,NineActivity.class);
                    startActivity(intent);
                }
                else if(flowerName[position] =="GeoLock"){
                    Intent intent =new Intent(Menu.this,TenActivity.class);
                    startActivity(intent);
                }
                else if(flowerName[position] =="Torch"){
                    Intent intent =new Intent(Menu.this,TorchActivity.class);
                    startActivity(intent);
                }
                else if(flowerName[position] =="Calculator"){
                    Intent intent =new Intent(Menu.this,Calculator.class);
                    startActivity(intent);
                }
                else if(flowerName[position] =="GMAP"){
                    Intent intent =new Intent(Menu.this,MapActivity.class);
                    startActivity(intent);
                }
                //Toast.makeText(MainActivity.this,"You Clicked on "+ flowerName[position],Toast.LENGTH_SHORT).show();

            }
        });

    }

//    Button expb1,expb2,expb3,expb4,expb5,expb6,expb7,expb8,expb9,expb10;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.mainlayout);
//        expb1 = findViewById(R.id.exp1);
//        expb1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(Menu.this,MainActivity.class);
//                startActivity(intent);
//            }
//        });
//        expb2 = findViewById(R.id.exp2);
//        expb2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(Menu.this,SecondActivity.class);
//                startActivity(intent);
//            }
//        });
//        expb3 = findViewById(R.id.exp3);
//        expb3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(Menu.this,ThirdActivity.class);
//                startActivity(intent);
//            }
//        });
//        expb4 = findViewById(R.id.exp4);
//        expb4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(Menu.this,FourthActivity.class);
//                startActivity(intent);
//            }
//        });
//        expb5 = findViewById(R.id.exp5);
//        expb5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(Menu.this,FifthActivity.class);
//                startActivity(intent);
//            }
//        });
//        expb6 = findViewById(R.id.exp6);
//        expb6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(Menu.this,SixthActivity.class);
//                startActivity(intent);
//            }
//        });
//        expb7 = findViewById(R.id.exp7);
//        expb7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(Menu.this,SevenActivity.class);
//                startActivity(intent);
//            }
//        });
//        expb8 = findViewById(R.id.exp8);
//        expb8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(Menu.this,EightActivity.class);
//                startActivity(intent);
//            }
//        });
//        expb9 = findViewById(R.id.exp9);
//        expb9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(Menu.this,NineActivity.class);
//                startActivity(intent);
//            }
//        });
//        expb10 = findViewById(R.id.exp10);
//        expb10.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(Menu.this,TenActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
}
