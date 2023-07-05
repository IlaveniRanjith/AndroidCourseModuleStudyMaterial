package com.example.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
//1. create a broadcast receiver class and extend it by BroadcastReceiver
//2. Check it's declaration in the AndroidManifest.xml file
public class MyAirplaneModeReceiver extends BroadcastReceiver {

    //3. Override the onReceive () method and put any code that needs to be executed upon
    //receiving the broadcast message
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "hi from my broadcast receiver.", Toast.LENGTH_SHORT).show();
    }
}