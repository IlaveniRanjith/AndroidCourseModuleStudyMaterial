package com.example.foregroundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startMyService(View view) {
        Intent myService = new Intent(this, MyForegroundService.class);
        //startService(myService);
        startForegroundService(myService);
    }

    public void stopMyService(View view) {
        Intent myService = new Intent(this, MyForegroundService.class);
        stopService(myService);
    }
}