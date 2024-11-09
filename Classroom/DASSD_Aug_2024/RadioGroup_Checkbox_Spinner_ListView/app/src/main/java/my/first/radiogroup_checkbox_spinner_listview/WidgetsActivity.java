package my.first.radiogroup_checkbox_spinner_listview;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class WidgetsActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton rbC, rbDS, rbJava, rbAndroid;

    Button btnShowSubjects;

    Spinner spStates;

    ListView lvStates;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);

        initWidgets();
        initSpinner();
        initListView();

        btnShowSubjects.setOnClickListener(this);


        //set the DS as default
        rbDS.setChecked(true);


    }

    private void initListView() {
        lvStates = findViewById(R.id.lv_states);


        ArrayList<String> states = new ArrayList<>();
        states.add("Himachal");
        states.add("Telangana");
        states.add("Tamil Nadu");
        states.add("Chattisgarh");
        states.add("Uttar Pradesh");
        states.add("Bihar");
        states.add("Himachal");
        states.add("Telangana");
        states.add("Tamil Nadu");
        states.add("Chattisgarh");
        states.add("Uttar Pradesh");
        states.add("Bihar");
        states.add("Himachal");
        states.add("Telangana");
        states.add("Tamil Nadu");
        states.add("Chattisgarh");
        states.add("Uttar Pradesh");
        states.add("Bihar");
        states.add("Himachal");
        states.add("Telangana");
        states.add("Tamil Nadu");
        states.add("Chattisgarh");
        states.add("Uttar Pradesh");
        states.add("Bihar");
        states.add("Himachal");
        states.add("Telangana");
        states.add("Tamil Nadu");
        states.add("Chattisgarh");
        states.add("Uttar Pradesh");
        states.add("Bihar");
        states.add("Himachal");
        states.add("Telangana");
        states.add("Tamil Nadu");
        states.add("Chattisgarh");
        states.add("Uttar Pradesh");
        states.add("Bihar");
        states.add("Himachal");
        states.add("Telangana");
        states.add("Tamil Nadu");
        states.add("Chattisgarh");
        states.add("Uttar Pradesh");
        states.add("Bihar");

        ArrayAdapter<String> statesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                states
        );

        lvStates.setAdapter(statesAdapter);

        lvStates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(WidgetsActivity.this, "ListView ITEM: " + states.get(position), Toast.LENGTH_SHORT).show();
            }
        });








    }

    private void initSpinner() {
        spStates = findViewById(R.id.sp_states);


        ArrayList<String> states = new ArrayList<>();
        states.add("Himachal");
        states.add("Telangana");
        states.add("Tamil Nadu");
        states.add("Chattisgarh");
        states.add("Uttar Pradesh");
        states.add("Bihar");


        ArrayAdapter<String> statesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                states
        );

        spStates.setAdapter(statesAdapter);

        spStates.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedState = states.get(position);

                Toast.makeText(WidgetsActivity.this, selectedState, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                    // ignore this
            }
        });



    }

    private void initWidgets(){
        rbC = findViewById(R.id.rb_c);
        rbDS = findViewById(R.id.rb_ds);
        rbJava = findViewById(R.id.rb_java);
        rbAndroid = findViewById(R.id.rb_android);



        btnShowSubjects = findViewById(R.id.btn_show_subjects);
    }

    @Override
    public void onClick(View v) {
        
        if(v.getId() == R.id.btn_show_subjects){
           showSelectedSubject();
        }
        


    }

    private void showSelectedSubject() {
        if (rbJava.isChecked()){
            Toast.makeText(this, "You selected Java subject.", Toast.LENGTH_LONG).show();
        }


        if (rbAndroid.isChecked()){
            Toast.makeText(this, "You selected Android subject.", Toast.LENGTH_LONG).show();
        }


        if (rbC.isChecked()){
            Toast.makeText(this, "You selected C subject.", Toast.LENGTH_LONG).show();
        }



        if (rbDS.isChecked()){
            Toast.makeText(this, "You selected DS subject.", Toast.LENGTH_LONG).show();
        }





    }
}