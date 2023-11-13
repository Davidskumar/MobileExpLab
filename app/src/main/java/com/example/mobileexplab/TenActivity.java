package com.example.mobileexplab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class TenActivity extends AppCompatActivity implements LocationListener {

    Button btnShowLocation,back;
    LocationManager locationManager;
    private double latitude;
    private double longitude;
    TextView edit_Country,edit_State,edit_City,edit_Pincode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten);

        back = findViewById(R.id.back10);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        edit_Country=findViewById(R.id.editCountry);
        edit_State=findViewById(R.id.editState);
        edit_City=findViewById(R.id.editCity);
        edit_Pincode=findViewById(R.id.editPincode);
        btnShowLocation=findViewById(R.id.btnShowLocation);

        btnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(TenActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(TenActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
                }else{
                    detectCurrentLocation();
                }
            }
        });
    }
    private void detectCurrentLocation(){
        Toast.makeText(this,"Getting your current location",Toast.LENGTH_SHORT).show();
        locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if ((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);
    }
    @Override
    public void onLocationChanged(Location location) {
        latitude=location.getLatitude();
        longitude=location.getLongitude();
        findAddress();
    }
    private void findAddress(){
        Geocoder geocoder;
        List<Address> addresses;
        geocoder=new Geocoder(this, Locale.getDefault());
        try{
            addresses=geocoder.getFromLocation(latitude,longitude,1);
            String country=addresses.get(0).getCountryName();
            String state=addresses.get(0).getAdminArea();
            String city=addresses.get(0).getLocality();
            String Pincode=addresses.get(0).getPostalCode();

            edit_Country.setText(country);
            edit_State.setText(state);
            edit_City.setText(city);
            edit_Pincode.setText(Pincode);
            Log.d("City",city);
            Log.d("State",state);
            Log.d("Country",country);
            Log.d("Pincode",String.valueOf(Pincode));
        }catch (Exception e){
            Toast.makeText(this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onStatusChanged(String provider,int status,Bundle extras){

    }
    @Override
    public void onProviderEnabled(String provider){

    }
    public void onProviderDisabled(String provider){
        Toast.makeText(this,"Please turn on Location",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,@NonNull String[] permissions,@NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);

        if(requestCode==1){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                detectCurrentLocation();
            }else{
                Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }
}