package com.example.widgetsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etPassword, etEmail;
    private Button btnLogin, btnNewAccount;

    private RadioButton rbMale, rbFemale, rbOthers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initSpinner();






        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = etPassword.getText().toString().trim();
                String email  = etEmail.getText().toString().trim();


                if(email.length() == 0){
                    etEmail.setError("Email is required");
                    return;
                }

                if(password.length() == 0){
                    etPassword.setError("Password is required");
                    return;
                }




                Toast.makeText(MainActivity.this, email, Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, password, Toast.LENGTH_LONG).show();

                //Logging statements

            }
        });















    }

    private void initSpinner() {
        Spinner spinner = findViewById(R.id.spinner_color);

        String [] colors = new String[]{"Violet","Indigo", "Blue"};

        ArrayList<String> myCourses = new ArrayList<>();
        myCourses.add("Java");
        myCourses.add("Android");
        myCourses.add("ML");

        ArrayAdapter mySpinnerAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                myCourses);

        spinner.setAdapter(mySpinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, myCourses.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }


    public void createNewAccount(View view) {

        if(rbMale.isChecked()){
            Toast.makeText(this, "You are Male", Toast.LENGTH_SHORT).show();
        }

        else if(rbFemale.isChecked()){
            Toast.makeText(this, "You are Female", Toast.LENGTH_SHORT).show();
        }

        else if(rbOthers.isChecked()){
            Toast.makeText(this, "You are Others", Toast.LENGTH_SHORT).show();
        }

    }

    private void initViews(){

        etPassword = findViewById(R.id.et_password);
        etEmail = findViewById(R.id.et_email);

        btnLogin = findViewById(R.id.btn_login);
        btnNewAccount = findViewById(R.id.btn_new_account);

        rbMale = findViewById(R.id.rb_male);
        rbFemale = findViewById(R.id.rb_female);
        rbOthers = findViewById(R.id.rb_others);



    }
}