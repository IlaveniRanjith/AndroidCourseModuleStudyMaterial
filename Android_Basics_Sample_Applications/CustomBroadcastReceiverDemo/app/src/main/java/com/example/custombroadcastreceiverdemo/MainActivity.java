package com.example.custombroadcastreceiverdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyCustomBroadcast myCustomBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCustomBroadcast = new MyCustomBroadcast();

        registerReceiver(myCustomBroadcast, new IntentFilter("mera_download_complete_ho_gya"));



    }

    public void sendCustomIntent(View view) {
/*        Intent myIntent = new Intent();
        myIntent.setAction("com.example.custombroadcastreceiverdemo.MY_CUSTOM_BROADCAST");
        myIntent.putExtra("data", "some looooooooooong value..");
        //startActivity(myIntent);  //it's wrong, will lead to an application crash
        sendBroadcast(myIntent);*/
    }
}