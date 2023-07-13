package com.example.batterymonitorapp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnToggleService;
    private boolean isServiceRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToggleService = findViewById(R.id.btn_toggle_service);
        btnToggleService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleBatteryService();
            }
        });

        if (isBatteryServiceRunning()){
            btnToggleService.setText("Stop Service");
            isServiceRunning = true;
        }
    }

    private void toggleBatteryService() {
        if (isServiceRunning) {
            stopService(new Intent(this, BatteryService.class));
            btnToggleService.setText("Start Service");
            isServiceRunning = false;
        } else {
            startService(new Intent(this, BatteryService.class));
            btnToggleService.setText("Stop Service");
            isServiceRunning = true;
        }
    }
    private boolean isBatteryServiceRunning() {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (BatteryService.class.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
