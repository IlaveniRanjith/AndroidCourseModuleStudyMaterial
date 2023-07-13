package com.example.quoteoftheday;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;
    private Button generateButton;

    private String[] quotes = {
            "Be the change that you wish to see in the world. - Mahatma Gandhi",
            "The best way to find yourself is to lose yourself in the service of others. - Mahatma Gandhi",
            "In a gentle way, you can shake the world. - Mahatma Gandhi",
            "A nation's culture resides in the hearts and in the soul of its people. - Mahatma Gandhi",
            "Our greatest glory is not in never falling, but in rising every time we fall. - Swami Vivekananda",
            "Arise, awake, and stop not until the goal is achieved. - Swami Vivekananda",
            "The power of youth is the common wealth for the entire world. The faces of young people are the faces of our past, our present, and our future. - Dr. A.P.J. Abdul Kalam",
            "Dream, dream, dream. Dreams transform into thoughts and thoughts result in action. - Dr. A.P.J. Abdul Kalam",
            "You have to dream before your dreams can come true. - Dr. A.P.J. Abdul Kalam",
            "Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful. - Dr. A.P.J. Abdul Kalam"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quote_text_view);
        generateButton = findViewById(R.id.generate_button);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomQuote();
            }
        });

        generateRandomQuote();
    }

    private void generateRandomQuote() {
        Random random = new Random();
        int randomIndex = random.nextInt(quotes.length);
        String randomQuote = quotes[randomIndex];
        quoteTextView.setText(randomQuote);
    }
}
