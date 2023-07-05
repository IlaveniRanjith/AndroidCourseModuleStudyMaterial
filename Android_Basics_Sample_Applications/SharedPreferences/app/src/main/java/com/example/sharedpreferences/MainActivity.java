package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView myTextView;
    private CheckBox myCheckbox;
    private EditText myEditText;

    private static final String MY_PREF_NAME = "my_preferences";
    private static final String TV_KEY = "textViewContent";
    private static final String ET_KEY = "editTextContent";
    private static final String CB_KEY = "checkBoxState";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
        readTheSavedValuesFromSharedPreferences();




    }

    private void readTheSavedValuesFromSharedPreferences() {

        SharedPreferences mySharedPrefes = getSharedPreferences(MY_PREF_NAME, MODE_PRIVATE);
        String savedTextViewValue = mySharedPrefes.getString(TV_KEY, "");
        String savedEditText = mySharedPrefes.getString(ET_KEY, "");
        boolean savedCheckBoxState = mySharedPrefes.getBoolean(CB_KEY, false);


        myTextView.setText(savedTextViewValue);
        myEditText.setText(savedEditText);
        myCheckbox.setChecked(savedCheckBoxState);






    }

    private void initViews() {
        myTextView = findViewById(R.id.text_view);
        myEditText = findViewById(R.id.edit_text);
        myCheckbox = findViewById(R.id.checkbox);


        myTextView.setText("This is a text view");
    }

    public void saveValuesInPreferences(View view) {

        CharSequence tvText = myTextView.getText();
        String actualString = tvText.toString();

        String etText = myEditText.getText().toString();
        boolean cbState = myCheckbox.isChecked();

        SharedPreferences mySharedPrefs = getSharedPreferences(MY_PREF_NAME, MODE_PRIVATE);

        SharedPreferences.Editor myEditor = mySharedPrefs.edit();

        myEditor.putString(TV_KEY, actualString); // for textView
        myEditor.putString(ET_KEY, etText); // for edit text
        myEditor.putBoolean(CB_KEY, cbState);

        myEditor.commit();










    }
}

/*
* All of the shared preferences of an application will be
* stored in the following directory:
*   /data/data/<package-name>/shared_prefs/
* eg: /data/data/com.example.sharedpreferences/shared_prefs/my_preferences/
*
*
*
* */