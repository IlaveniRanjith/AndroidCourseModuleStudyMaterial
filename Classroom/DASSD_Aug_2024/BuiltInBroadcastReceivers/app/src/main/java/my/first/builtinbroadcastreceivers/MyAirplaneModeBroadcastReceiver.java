package my.first.builtinbroadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyAirplaneModeBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean airplaneModeState = intent.getBooleanExtra("state", false);
        Toast.makeText(context,
                "Airplane mode broadcast triggered | STATE: " + airplaneModeState,
                Toast.LENGTH_LONG).show();
    }
}