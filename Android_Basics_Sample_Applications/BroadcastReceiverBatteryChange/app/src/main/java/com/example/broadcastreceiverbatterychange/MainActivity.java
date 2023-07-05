package com.example.broadcastreceiverbatterychange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    BatteryChangeReceiver myBatteryChangeR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myBatteryChangeR = new BatteryChangeReceiver();

        registerReceiver(myBatteryChangeR, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));


    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(myBatteryChangeR);
        super.onDestroy();
    }
}