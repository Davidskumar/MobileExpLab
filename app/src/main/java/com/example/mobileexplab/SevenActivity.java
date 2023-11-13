package com.example.mobileexplab;
import  androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SevenActivity extends AppCompatActivity {
    URL ImageUrl =null;
    InputStream is = null;
    Bitmap bmImg=null;
    ImageView image;
    ProgressDialog p;
    Button download;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven);

        download = findViewById(R.id.button2);
        image=findViewById(R.id.imageView);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncTaskExample asyncTask=new AsyncTaskExample();
                asyncTask.execute("https://karunya.edu/sites/default/files/img/images/37,P20Years,P20KITS,P203.jpg.pagespeed.ce.CT73xojF3W.jpg");
            }
        });
    }
    private class AsyncTaskExample extends AsyncTask<String,String,Bitmap>{
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            p=new ProgressDialog(SevenActivity.this);
            p.setMessage("Please wait.... It is downloading");
            p.setIndeterminate(false);
            p.setCancelable(false);
            p.show();
        }
        @Override
        protected Bitmap doInBackground(String... strings){
            try{
                ImageUrl = new URL(strings[0]);
                HttpURLConnection conn =(HttpURLConnection) ImageUrl.openConnection();
                conn.setDoInput(true);
                conn.connect();
                is=conn.getInputStream();
                BitmapFactory.Options options=new BitmapFactory.Options();
                options.inPreferredConfig=Bitmap.Config.RGB_565;
                bmImg=BitmapFactory.decodeStream(is,null,options);
            }
            catch (IOException e){
                e.printStackTrace();
            }
            return bmImg;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap){
            super.onPostExecute(bitmap);
            if(image!=null){
                p.hide();
                image.setImageBitmap(bitmap);
            }else {
                p.show();
            }
        }
    }
}