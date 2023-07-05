package com.example.broadcastreceiverbatterychange;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

public class BatteryChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent != null){
            Toast.makeText(context, "Battery Level changed: " + intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0), Toast.LENGTH_SHORT).show();
        }
    }
}