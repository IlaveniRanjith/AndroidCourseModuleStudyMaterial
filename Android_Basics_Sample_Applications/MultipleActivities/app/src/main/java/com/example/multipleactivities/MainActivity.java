package com.example.multipleactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String KEY1 = "my_key";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchSecondActivity(View view) {

        Intent launchSecondActivity = new Intent(MainActivity.this, SecondActivity.class); //source and destination
        launchSecondActivity.putExtra(KEY1, "my_secret_value");
        launchSecondActivity.putExtra("myOtherKey", "not so secret value");


        startActivity(launchSecondActivity);
        //finish();



    }
}