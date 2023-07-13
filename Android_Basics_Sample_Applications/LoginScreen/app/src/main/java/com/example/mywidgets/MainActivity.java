package com.example.mywidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1. declare the objects with respect to each widget
    private EditText etInputEmail;
    private EditText etInputPassword;
    private Button btnSignIn;

    public static final String SHARED_PREF_FILE_NAME = "com.example.mywidgets";
    public static final String KEY_IS_USER_LOGGED_IN = "is_user_logged_in";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences mSharedPref = getSharedPreferences(SHARED_PREF_FILE_NAME, 0);
        Boolean isUserLoggedIn = mSharedPref.getBoolean(KEY_IS_USER_LOGGED_IN, false);

        if(isUserLoggedIn){
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            finish();
        }




        //2. link up the widgets declared in the layout file with the objects declared in java file
        etInputEmail = findViewById(R.id.et_input_email);
        etInputPassword = findViewById(R.id.et_input_password);
        btnSignIn = findViewById(R.id.btn_login);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //System.out.println("Sign in button tapped!!");
                //Log.d("MyWidgets", "Sign in button tapped");

                String inputEmail = etInputEmail.getText().toString().trim();
                String inputPassword = etInputPassword.getText().toString().trim();


                if (inputEmail.length() == 0){
                    //Toast.makeText(MainActivity.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                    etInputEmail.setError("Please enter a valid email address.");
                    return;
                }

                if (inputPassword.length() == 0){
                    //Toast.makeText(MainActivity.this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
                    etInputPassword.setError("Please enter a valid password.");
                    return;
                }

                Toast.makeText(MainActivity.this, "Signed In Successfully !!!", Toast.LENGTH_SHORT).show();

                //Intent is an inter-app-component communication mechanism or message passing mechanism
                //Two types of intents are there
                //1. implicit: destination path/component need not to be specified
                //2. explicit: destination path/component has to be specified

                //Explicit Intent
                Intent launchHomeActivity = new Intent(MainActivity.this,
                        HomeActivity.class);

                launchHomeActivity.putExtra("email",inputEmail);
                launchHomeActivity.putExtra("pass",inputPassword);

                startActivity(launchHomeActivity);
                finish();


                saveUserLoginState();


            }
        });


    }

    private void saveUserLoginState() {
        SharedPreferences mSharedPref = getSharedPreferences(SHARED_PREF_FILE_NAME, 0);
        SharedPreferences.Editor mEditor = mSharedPref.edit();

        mEditor.putBoolean(KEY_IS_USER_LOGGED_IN, true);
        mEditor.commit();


    }
}