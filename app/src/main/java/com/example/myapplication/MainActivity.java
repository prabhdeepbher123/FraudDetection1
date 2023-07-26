package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private static final int  MY_PERMISSION_REQUEST_RECEIVE_SMS = 0;
    Button button;
    EditText phoneno;
    String tu;
    public static String fu;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent =new Intent(this,MyService.class);
        startForegroundService(intent);
        phoneno=(EditText) findViewById(R.id.phoneno);
        button=(Button)findViewById(R.id.button);
        sharedPreferences=getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tu = phoneno.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("phoneno",tu);
                editor.commit();
                SharedPreferences sharedPreferences =getApplicationContext().getSharedPreferences("MyUserPrefs",Context.MODE_PRIVATE);
                fu = sharedPreferences.getString("phoneno","");
                Toast.makeText(MainActivity.this, "Forwarding Activated", Toast.LENGTH_SHORT).show();
                phoneno.clearAnimation();

            }
        });


        if(ContextCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.SEND_SMS))
            {

            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},MY_PERMISSION_REQUEST_RECEIVE_SMS);
            }


        }





        if(ContextCompat.checkSelfPermission(this,Manifest.permission.RECEIVE_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.RECEIVE_SMS))
            {

            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS},MY_PERMISSION_REQUEST_RECEIVE_SMS);
            }


        }

    }
    @Override
    public void onRequestPermissionsResult (int requestCode,String permissions[],int[] grantResults)
    {
        switch(requestCode)
        {
            case MY_PERMISSION_REQUEST_RECEIVE_SMS:
            {
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this, "Permission Received", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }

            }
        }
    }

    public void gu(View view) {
        Intent intent=new Intent( this, MainActivity2.class);
        startActivity(intent);

    }
}