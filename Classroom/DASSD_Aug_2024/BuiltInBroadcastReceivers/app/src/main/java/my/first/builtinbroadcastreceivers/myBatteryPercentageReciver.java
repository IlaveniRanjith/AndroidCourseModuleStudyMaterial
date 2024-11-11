package my.first.builtinbroadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class myBatteryPercentageReciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int batteryLevel = intent.getIntExtra("level", 0);
        Toast.makeText(context, "Battery Level: " + batteryLevel, Toast.LENGTH_SHORT).show();
    }
}