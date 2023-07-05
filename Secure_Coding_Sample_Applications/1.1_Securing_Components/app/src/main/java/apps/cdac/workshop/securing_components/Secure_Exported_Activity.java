package apps.cdac.workshop.securing_components;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Secure_Exported_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secure_exported);
    }
}