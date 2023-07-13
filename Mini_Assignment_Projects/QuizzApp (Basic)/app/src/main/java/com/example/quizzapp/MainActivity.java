package com.example.quizzapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkAnswers(View view) {
        int score = 0;

        RadioButton option1RadioButton = findViewById(R.id.option1_radio_button);
        RadioButton option2RadioButton = findViewById(R.id.option2_radio_button);
        RadioButton option3RadioButton = findViewById(R.id.option3_radio_button);

        if (option1RadioButton.isChecked()) {
            score++;
        }
        if (option2RadioButton.isChecked()) {
            score++;
        }
        if (option3RadioButton.isChecked()) {
            score++;
        }

        Toast.makeText(MainActivity.this, "Your score: " + score + "/3", Toast.LENGTH_SHORT).show();
    }
}
