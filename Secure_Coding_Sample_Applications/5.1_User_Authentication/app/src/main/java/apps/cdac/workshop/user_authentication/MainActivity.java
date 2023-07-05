package apps.cdac.workshop.user_authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPrefs;
    public static final String APP_TAG = "apps.cdac.workshop.user_authentication";
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


        if (!spAndroidID.isEmpty()) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
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
        if(passwordField.getText().toString().length() > (MinPassLen-1)){
            //Valid Password
            return false;
        }
        //Invalid Password
        passwordField.setError("Invalid Password");
        return true;
    }

    private void getDeviceID() {

        if(spAndroidID.isEmpty()) {
            // Phone has not been used before
            androidID = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
            // Save AndroidID to Shared Preferences
            SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.putString(DEVICE_ID, androidID);
            editor.commit();

            //Launch the Home Activity
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        } else {
            // Phone already has a saved deviceID
            if (spAndroidID.equals(androidID)) {
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