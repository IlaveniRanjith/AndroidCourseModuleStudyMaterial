package com.example.broadcastreceiverdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //Step 4. declare object of the custom broadcast receiver class
    MyAirplaneModeReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //5. initialize it
        myReceiver = new MyAirplaneModeReceiver();

        //6. Register it
        registerReceiver(myReceiver, new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)); //takes two things, 1. the receiver object, 2. the intent-filter

    }

    //7. override the onDestroy()
    @Override
    protected void onDestroy() {
        //8. unregister the broadcast object/receiver
        unregisterReceiver(myReceiver);
        super.onDestroy();
    }
}