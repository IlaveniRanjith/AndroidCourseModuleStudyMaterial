package my.first.builtinbroadcastreceivers;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyAirplaneModeBroadcastReceiver myAirplaneModeBroadcastReceiver = new MyAirplaneModeBroadcastReceiver();
        registerReceiver(myAirplaneModeBroadcastReceiver, new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));


        myBatteryPercentageReciver batteryPercentageReciver = new myBatteryPercentageReciver();
        registerReceiver(batteryPercentageReciver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));


        CustomBroadcastReceiver downloadReciver = new CustomBroadcastReceiver();
        registerReceiver(downloadReciver, new IntentFilter("download_complete_ho_gya"));


    }

    public void sendDownloadCompleteBroadcast(View view) {
        //Intent downloadCompleteIntent = new Intent(MainActivity.this, CustomBroadcastReceiver.class);
        Intent downloadCompleteIntent = new Intent();
        downloadCompleteIntent.setAction("download_complete_ho_gya");
        downloadCompleteIntent.putExtra("file", "Devara pirated movie has been downloaded....");
        sendBroadcast(downloadCompleteIntent);


    }
}