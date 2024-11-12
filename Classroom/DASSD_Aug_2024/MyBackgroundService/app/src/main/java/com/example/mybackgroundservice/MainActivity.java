package com.example.mybackgroundservice;

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
        Intent myService = new Intent(this, MyBackgroundService.class);
        startService(myService);
    }

    public void stopMyService(View view) {
        Intent myService = new Intent(this, MyBackgroundService.class);
        stopService(myService);
    }
}