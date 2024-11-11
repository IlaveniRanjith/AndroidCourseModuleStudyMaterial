package my.first.builtinbroadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String movieDetails = intent.getStringExtra("file");
        Toast.makeText(context, "[App1] | Movie Details: " + movieDetails, Toast.LENGTH_SHORT).show();
    }
}