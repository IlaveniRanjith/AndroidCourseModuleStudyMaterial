package com.example.multipleactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //String myObtainedvalue = getIntent().getStringExtra("my_key");
        String myObtainedvalue = getIntent().getStringExtra(MainActivity.KEY1);
        String otherObtainedvalue = getIntent().getStringExtra("myOtherKey");

        TextView tv = findViewById(R.id.tv_second);
        tv.setText(myObtainedvalue);





    }
}