package apps.cdac.workshop.secure_preferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;

import java.io.IOException;
import java.security.GeneralSecurityException;


public class MainActivity extends AppCompatActivity {

    MasterKey masterKey;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //Create or Fetch a Master Key from Android Keystore
            masterKey = new MasterKey.Builder(this, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
                    .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                    .build();

            //Create a SharedPreferences object and initialize it using SecurePreferences
            sharedPreferences = EncryptedSharedPreferences.create(
                    this,
                    "my_secure_preferences",
                    masterKey,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);

        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }

        //Create the Editor Object
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //Use the Editor object to put key-value pair into shared preference
        editor.putString("cdac", "abhishek bhardwaj");
        //Call the apply method to save the data
        editor.apply();

        TextView tvOutput = findViewById(R.id.output);
        tvOutput.setText(sharedPreferences.getString("cdac", "not available"));
    }
}
