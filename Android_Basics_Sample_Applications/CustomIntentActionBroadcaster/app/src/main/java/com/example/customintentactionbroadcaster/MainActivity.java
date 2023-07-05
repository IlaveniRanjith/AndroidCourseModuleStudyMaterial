package com.example.customintentactionbroadcaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendCustomIntent(View view) {
        Intent myIntent = new Intent();
        myIntent.setAction("mera_download_complete_ho_gya");
        //myIntent.setAction("com.example.customintentactionbroadcaster.DOWNLOAD_COMPLETED"); //standard way of writing intent ACTION
        myIntent.putExtra("data", "Avatar pirated movie downloaded.");
        //startActivity(myIntent);  //it's wrong, will lead to an application crash
        //downloading related statements
        sendBroadcast(myIntent);

    }
}