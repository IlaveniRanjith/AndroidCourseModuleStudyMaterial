package my.first.addnumbers;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // 1. declare the objects
    EditText etFirstNumber;
    EditText etSecondNumber;

    Button btnAddNumbers;

    TextView tvResult;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "On Create method called...", Toast.LENGTH_SHORT).show();

        Toast.makeText(
                MainActivity.this,
                "Hello there,,,",
                Toast.LENGTH_LONG
        );

        //2. link the object with the widget
        etFirstNumber = findViewById(R.id.first_number);
        etSecondNumber = findViewById(R.id.second_number);

        btnAddNumbers = findViewById(R.id.add_button);

        tvResult = findViewById(R.id.result);

        
        
        btnAddNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addnumbers();
            }
        });






    }

    public void addnumbers()
    {
        //Toast.makeText(MainActivity.this, "button clicked...", Toast.LENGTH_SHORT).show();
        String firstNum = etFirstNumber.getText().toString();
        String secondNum = etSecondNumber.getText().toString();


        if (firstNum.isEmpty()){
            //Toast.makeText(MainActivity.this, "Please enter first number", Toast.LENGTH_SHORT).show();
            etFirstNumber.setError("Please enter first number.");

            return;
        }

        if (secondNum.isEmpty()){
            Toast.makeText(MainActivity.this, "Please enter second number", Toast.LENGTH_SHORT).show();
            return;
        }




        int sum = Integer.valueOf(firstNum) + Integer.valueOf(secondNum);

        tvResult.setText(String.valueOf(sum));




    }
}