package com.example.quizapp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioButton option1RadioButton;
    private RadioButton option2RadioButton;
    private RadioButton option3RadioButton;
    private Button submitButton;

    private String[] questions = {
            "Question 1: Android is -",
            "Question 2: Which of the following method is used to handle what happens after clicking a button?",
            "Question 3: Which of the following layout in android aligns all children either vertically or horizontally?"
    };

    private String[][] options = {
            {"an operating system", "a web browser", "a web server"},
            {"onClick", "onCreate", "onSelect"},
            {"LinearLayout", "RelativeLayout", "Scroll View"}
    };

    private int[] correctAnswers = {0, 0, 0};
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.question_text_view);
        option1RadioButton = findViewById(R.id.option1_radio_button);
        option2RadioButton = findViewById(R.id.option2_radio_button);
        option3RadioButton = findViewById(R.id.option3_radio_button);
        submitButton = findViewById(R.id.submit_button);

        updateQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void updateQuestion() {
        questionTextView.setText(questions[currentQuestionIndex]);
        option1RadioButton.setText(options[currentQuestionIndex][0]);
        option2RadioButton.setText(options[currentQuestionIndex][1]);
        option3RadioButton.setText(options[currentQuestionIndex][2]);
    }

    private void checkAnswer() {
        int selectedOption = -1;

        if (option1RadioButton.isChecked()) {
            selectedOption = 0;
        } else if (option2RadioButton.isChecked()) {
            selectedOption = 1;
        } else if (option3RadioButton.isChecked()) {
            selectedOption = 2;
        }

        if (selectedOption == correctAnswers[currentQuestionIndex]) {
            score++;
        }

        currentQuestionIndex++;

        if (currentQuestionIndex < questions.length) {
            updateQuestion();
            clearOptions();
        } else {
            showScore();
        }
    }

    private void clearOptions() {
        option1RadioButton.setChecked(false);
        option2RadioButton.setChecked(false);
        option3RadioButton.setChecked(false);
    }

    private void showScore() {
        Toast.makeText(MainActivity.this, "Your score: " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
        submitButton.setEnabled(false);
    }
}
