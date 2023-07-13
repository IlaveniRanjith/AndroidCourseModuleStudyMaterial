package com.example.batterymonitorapp;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class BatteryReceiver extends BroadcastReceiver {

    private static final int NOTIFICATION_ID_LOW_BATTERY = 1002;
    private static final int NOTIFICATION_ID_CHARGER_CONNECTED = 1003;
    private static final String CHANNEL_ID = "MyBatteryChannel";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            int batteryPercentage = (int) ((level / (float) scale) * 100);

            if (batteryPercentage < 15) {
                showLowBatteryNotification(context, batteryPercentage);
            }

            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            if (status == BatteryManager.BATTERY_STATUS_CHARGING) {
                showChargerConnectedNotification(context);
            }
        }
    }

    private void showLowBatteryNotification(Context context, int batteryPercentage) {
        // Create a PendingIntent for the notification's action
        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle("Battery Monitor")
                .setContentText("Battery is below 50%. Current level: " + batteryPercentage + "%")
                .setSmallIcon(R.drawable.ic_battery_low)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(NOTIFICATION_ID_LOW_BATTERY, builder.build());
    }

    private void showChargerConnectedNotification(Context context) {
        // Create a PendingIntent for the notification's action
        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle("Battery Monitor")
                .setContentText("Charger connected")
                .setSmallIcon(R.drawable.ic_battery_charging)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(NOTIFICATION_ID_CHARGER_CONNECTED, builder.build());
    }
}
