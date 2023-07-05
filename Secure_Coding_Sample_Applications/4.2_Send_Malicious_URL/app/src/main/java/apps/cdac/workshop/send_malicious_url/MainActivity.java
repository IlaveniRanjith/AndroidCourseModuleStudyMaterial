package apps.cdac.workshop.send_malicious_url;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SendMaliciousIntent(View view) {
        Intent launchIntent = getApplicationContext().getPackageManager().
                getLaunchIntentForPackage("apps.cdac.workshop.validate_user_input");

        if (launchIntent != null) {
            launchIntent.putExtra("WEBPAGE_URL", "file:/storage/emulated/0/Download/sample.txt");
            startActivity(launchIntent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), " launch Intent not available", Toast.LENGTH_SHORT).show();
        }
    }
}


