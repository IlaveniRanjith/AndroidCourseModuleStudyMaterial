package com.example.implicitintentsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callPhoneNumber(View view){
        //Implicit Intent
        Intent callPhoneIntent = new Intent(Intent.ACTION_DIAL);
        callPhoneIntent.setData(Uri.parse("tel:12345"));
        startActivity(callPhoneIntent);
    }

    public void sendSMS(View view) {
        Intent sendSMS = new Intent(Intent.ACTION_SENDTO);
        sendSMS.setData(Uri.parse("smsto:789456"));
        sendSMS.putExtra("sms_body", "You are not available on whatsapp");
        startActivity(sendSMS);

    }

    public void shareWebLink(View view) {
        String webURL = "https://www.cdac.in";
        Intent shareLinkIntent = new Intent(Intent.ACTION_SEND);
        shareLinkIntent.setType("text/plain"); //important statement specifying the MIME type
        shareLinkIntent.putExtra(Intent.EXTRA_TEXT,webURL);
        startActivity(Intent.createChooser(shareLinkIntent, "Share the link"));

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(webURL));
        startActivity(intent);




    }
}