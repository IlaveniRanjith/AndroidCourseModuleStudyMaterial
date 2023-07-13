package com.example.mywidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String email = getIntent().getStringExtra("email");
        String pass = getIntent().getStringExtra("pass");

        TextView tv = findViewById(R.id.tv_home_result);
        tv.setText( "Email: " + email + "\nPassword: " + pass);

    }

    public void logOut(View view) {
        SharedPreferences mSharedPref = getSharedPreferences(MainActivity.SHARED_PREF_FILE_NAME, 0);
        SharedPreferences.Editor mEditor = mSharedPref.edit();

        mEditor.putBoolean(MainActivity.KEY_IS_USER_LOGGED_IN, false);
        mEditor.commit();

        startActivity(new Intent(HomeActivity.this, MainActivity.class));
        finish();


    }
}