package my.first.sharedpreferencesexample;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CheckBox chkRememberMe;
    private EditText etName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        chkRememberMe = findViewById(R.id.chk_remember_me);

        SharedPreferences myDetails = getSharedPreferences("myDetails", 0);

        String lastSavedName = myDetails.getString("user_name", "");
        Boolean lastSavedRememberMEValue = myDetails.getBoolean("remember_me", true);


        etName.setText(lastSavedName);
        chkRememberMe.setChecked(lastSavedRememberMEValue);













    }

    public void saveDataIntoSharedPref(View view) {

        String name = etName.getText().toString().trim();

        boolean rememberMeValue = chkRememberMe.isChecked();

        Log.d("MYAPPLICATON", "value of Name: " + name);
        Log.d("MYAPPLICATON", "value of Remember ME: " + rememberMeValue);

        SharedPreferences mySharedPrefs = getSharedPreferences("myDetails", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySharedPrefs.edit();

        myEditor.putString("user_name",name);
        myEditor.putBoolean("remember_me", rememberMeValue);


        myEditor.commit();

        Toast.makeText(this, "Data saved....", Toast.LENGTH_SHORT).show();
















    }
}