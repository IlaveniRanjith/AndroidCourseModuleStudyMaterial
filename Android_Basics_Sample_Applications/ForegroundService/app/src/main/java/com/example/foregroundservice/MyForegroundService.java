package com.example.foregroundservice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyForegroundService extends Service {
    private String TAG = "Foreground_Service";

    public MyForegroundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: foreground service created...");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        /*Toast.makeText(this, "Hello from MyForeground Service...", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStartCommand: service is running" );*/

        NotificationChannel myChannel = new NotificationChannel(
                "MyChannel1",
                "My Foreground Notification Channel",
                NotificationManager.IMPORTANCE_LOW);
        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(myChannel);

        Notification.Builder builder = new Notification.Builder(this, "MyChannel1");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentTitle("My Foreground Notification");
        builder.setContentText("Downloading the file...");
        builder.setProgress(100, 0, false);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<=100; i+=5){
                    builder.setProgress(100, i, false);
                    manager.notify(1001, builder.build());

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                builder.setContentTitle("My Foreground notification");
                builder.setContentText("Download completed...");
                builder.setProgress(0, 0, false);
                manager.notify(1001, builder.build());
                stopSelf();
            }
        }).start();

        Notification myNotify = builder.build();

        startForeground(1001, myNotify);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: Foreground service destroyed" );
        super.onDestroy();
    }
}