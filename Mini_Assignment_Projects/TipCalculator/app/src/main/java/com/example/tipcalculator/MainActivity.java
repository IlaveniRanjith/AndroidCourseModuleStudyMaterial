package com.example.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText billEditText;
    private EditText tipPercentageEditText;
    private Button calculateButton;
    private TextView tipAmountTextView;
    private TextView totalAmountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billEditText = findViewById(R.id.bill_edit_text);
        tipPercentageEditText = findViewById(R.id.tip_percentage_edit_text);
        calculateButton = findViewById(R.id.calculate_button);
        tipAmountTextView = findViewById(R.id.tip_amount_text_view);
        totalAmountTextView = findViewById(R.id.total_amount_text_view);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip();
            }
        });
    }

    private void calculateTip() {
        String billString = billEditText.getText().toString();
        String tipPercentageString = tipPercentageEditText.getText().toString();

        if (!billString.isEmpty() && !tipPercentageString.isEmpty()) {
            double billAmount = Double.parseDouble(billString);
            double tipPercentage = Double.parseDouble(tipPercentageString);

            double tipAmount = billAmount * (tipPercentage / 100);
            double totalAmount = billAmount + tipAmount;

            tipAmountTextView.setText("₹" + tipAmount);
            totalAmountTextView.setText("₹" + totalAmount);
        } else{
            Toast.makeText(this, "Please provide input !!", Toast.LENGTH_SHORT).show();
        }
    }
}
