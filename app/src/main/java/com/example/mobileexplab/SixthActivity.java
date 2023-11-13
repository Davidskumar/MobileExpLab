package com.example.mobileexplab;

import android.Manifest;
import android.app.Activity;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import  android.os.Bundle;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class SixthActivity extends AppCompatActivity {

    EditText mobileno,message;
    Button sendsms,open;
    private static final int CONTACT_PERMISSION_CODE=1;
    private static final int CONTACT_PICK_CODE=2;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        mobileno = (EditText) findViewById(R.id.sixText1);
        message = (EditText) findViewById(R.id.sixText2);
        sendsms = (Button) findViewById(R.id.sixbut1);
        open = (Button) findViewById(R.id.sixbut2);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkContactPermission()) {
                    pickContactIntent();
                } else {
                    requestContactPermission();
                }
            }
        });

        sendsms.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(SixthActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                    sendMessage();
                } else {
                    ActivityCompat.requestPermissions(SixthActivity.this, new String[]{Manifest.permission.SEND_SMS}, 100);
                }
            }
        });
    }
        private void sendMessage(){
            String phoneno= mobileno.getText().toString();
            String mess=message.getText().toString();
            if(!phoneno.equals("") && !message.equals("")){
                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(phoneno,null,mess,null,null);
                Toast.makeText(this,"Sms Send Successfully",Toast.LENGTH_LONG).show();

                }
            else{
                Toast.makeText(this,"Type some message",Toast.LENGTH_LONG).show();
            }
        }
    private boolean checkContactPermission(){
        boolean result=ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)==(PackageManager.PERMISSION_GRANTED);
        return result;
    }
    private void requestContactPermission(){
        String[] permi = {Manifest.permission.READ_CONTACTS};
        ActivityCompat.requestPermissions(this,permi,CONTACT_PERMISSION_CODE);
    }
    private void pickContactIntent(){
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
        startActivityForResult(intent,CONTACT_PICK_CODE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode , @NonNull String[] permissions,@NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        if(requestCode==CONTACT_PERMISSION_CODE){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                pickContactIntent();
            }
            else{
                Toast.makeText(this,"Permissions Denied",Toast.LENGTH_SHORT).show();
            }

        }
        if(requestCode == 100 && grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            sendMessage();
        }
        else{
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode ,int resultCode,@Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == RESULT_OK){
            switch(requestCode){
                case CONTACT_PICK_CODE:
                    contactPicked(data);
                    break;
            }
        }
    }
    private void contactPicked(Intent data){
        Cursor cursor = null;

        try{
            String phoneNo = null;
            Uri uri = data.getData();
            cursor = getContentResolver().query(uri,null,null,null,null);
            cursor.moveToFirst();
            int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            phoneNo = cursor.getString(phoneIndex);
            mobileno.setText(phoneNo);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}