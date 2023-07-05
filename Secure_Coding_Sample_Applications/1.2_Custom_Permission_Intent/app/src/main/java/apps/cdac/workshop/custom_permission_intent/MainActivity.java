package apps.cdac.workshop.custom_permission_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
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
    public void LaunchActivity (View view) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(
                "apps.cdac.workshop.securing_components",
                "apps.cdac.workshop.securing_components.Secure_Exported_Activity"));
        startActivity(intent);
    }
}


