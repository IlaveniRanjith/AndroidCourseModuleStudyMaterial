package com.example.activitylifecycledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String MYTAG = "ACTIVITY_LIFECYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(MYTAG, "onCreate () called...");



    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MYTAG, "onStart () called...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(MYTAG, "onResume () called...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(MYTAG, "onPause () called...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MYTAG, "onStop () called...");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(MYTAG, "onRestart () called...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(MYTAG, "onDestroy () called...");
    }

    public void openSecondActivity(View view) {
        startActivity(new Intent(MainActivity.this, MainActivity2.class));
    }
}