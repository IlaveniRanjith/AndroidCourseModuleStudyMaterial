package apps.cdac.workshop.case_study_secure_coding_practices;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.util.Base64;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SharedPreferences sharedPrefs;
    public static final int MinPassLen = 6;
    public static final String SHARED_PREF_NAME = "mySharedPrefs";
    public static final String DEVICE_ID = "lastDevice";
    public static String androidID = "";
    public static String spAndroidID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPrefs = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        spAndroidID = sharedPrefs.getString(DEVICE_ID, "");

        androidID = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        Log.d(TAG, "Device ID Fetched: " + androidID);




        if (!spAndroidID.isEmpty()) {

            // Decode the androidID
            String decodedValue = new String(Base64.decode(spAndroidID.getBytes(), Base64.DEFAULT));
            Log.d(TAG, "Decoded Device ID: " + decodedValue);

            // Compare the values
            if (decodedValue.equals(androidID)) {
                Log.d(TAG, "Login Success");
                startActivity(new Intent(this, HomeActivity.class));
                finish();
            }
            else {
                Toast.makeText(this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                finish();
            }
        }

    }

    private boolean areFieldsEmpty(EditText... fields) {
        for(int i = 0; i < fields.length; i++) {
            if(fields[i].getText().toString().matches("")) {
                //Empty Field
                fields[i].setError("Empty Field");
                return true;
            }
        }
        return false;
    }

    private boolean invalidEmail(EditText email) {
        Log.d(TAG, "Email Fetched: " + email.getText().toString());

        Pattern pattern;
        Matcher matcher;
        String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\. [A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email.getText().toString());
        if(matcher.matches()){
            //Valid Email
            return false;
        }
        //Invalid Email
        email.setError("Invalid Email");
        return true;
    }

    private boolean shortPassword(EditText passwordField) {
        Log.d(TAG, "Password Fetched: " + passwordField.getText().toString());

        if(passwordField.getText().toString().length() > (MinPassLen-1)){
            //Valid Password
            return false;
        }
        //Invalid Password
        passwordField.setError("Invalid Password");
        return true;
    }

    private void getDeviceID() {

        if(spAndroidID.isEmpty()) { // Phone has not been used before

            // Encoding the androidID value
            String encodedValue = new String(Base64.encode(androidID.getBytes(), Base64.DEFAULT));
            Log.d(TAG, "Encoded Device ID: " + encodedValue);

            // Saving the encoded AndroidID to Shared Preferences
            SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.putString(DEVICE_ID, encodedValue);
            editor.commit();

            //Launch the Home Activity
            startActivity(new Intent(this, HomeActivity.class));
            Log.d(TAG, "Login Successful");
            finish();

        } else { // Phone already has a saved deviceID

            // Decode the androidID
            String decodedValue = new String(Base64.decode(spAndroidID.getBytes(), Base64.DEFAULT));
            Log.d(TAG, "Decoded Device ID: " + decodedValue);
            Toast.makeText(this, decodedValue, Toast.LENGTH_SHORT).show();

            // Compare the values
            if (decodedValue.equals(androidID)) {
                Log.d(TAG, "Login Success");
                startActivity(new Intent(this, HomeActivity.class));
                finish();
            }

        }
    }

    public void LoginUser(View view) {
        EditText usernameField = (EditText) findViewById(R.id.username_field);
        EditText passwordField = (EditText) findViewById(R.id.password_field);
        EditText emailField = (EditText) findViewById(R.id.email_field);

        if(areFieldsEmpty(usernameField, passwordField, emailField)) {
            return;
        }
        if(invalidEmail(emailField)) {
            return;
        }
        if(shortPassword(passwordField)) {
            return;
        }
        getDeviceID();
    }

}