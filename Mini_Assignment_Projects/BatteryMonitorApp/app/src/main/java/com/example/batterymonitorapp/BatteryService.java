package com.example.batterymonitorapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class BatteryService extends Service {
    private BatteryReceiver batteryReceiver;

    public BatteryService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        batteryReceiver = new BatteryReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryReceiver, filter);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        NotificationChannel myChannel = new NotificationChannel(
                "MyBatteryChannel",
                "My Battery Notification Channel",
                NotificationManager.IMPORTANCE_HIGH);
        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(myChannel);


        Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE);

        Notification.Builder builder = new Notification.Builder(this, "MyBatteryChannel");
        builder.setSmallIcon(R.drawable.ic_battery);
        builder.setContentTitle("Battery Monitor");
        builder.setContentText("Monitoring battery level...");
        builder.setContentIntent(pendingIntent);

        Notification myNotify = builder.build();
        startForeground(1001, myNotify);

        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        unregisterReceiver(batteryReceiver);
    }
}