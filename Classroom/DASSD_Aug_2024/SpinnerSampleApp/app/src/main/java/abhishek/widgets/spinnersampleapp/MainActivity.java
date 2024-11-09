package abhishek.widgets.spinnersampleapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 1. Declare an object of spinner class
    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. Link the widget defined in the xml with the object declared in java
        mySpinner = findViewById(R.id.activity_main_spinner);

        //3. Create a list of items to display in the spinnner
        ArrayList<String> subjects = new ArrayList<String>();
        subjects.add("Android");
        subjects.add("OS");
        subjects.add("C++");

        //4. create an adapter object
        ArrayAdapter myAdapter = new ArrayAdapter(
                MainActivity.this,  //context
                android.R.layout.simple_spinner_dropdown_item,  // the layout to inflate for each of the item
                subjects    // the actual data to be displayed in the spinner
        );

        //5. pass the adapter to the spinner object
        mySpinner.setAdapter(myAdapter);
        
        //6. adding click listener to the spinner object
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = subjects.get(i);
                Toast.makeText(MainActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





    }
}