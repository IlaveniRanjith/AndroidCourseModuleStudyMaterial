package my.first.myloginpageexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignupActivity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("name");
        String roll = bundle.getString("roll");
        boolean isStudent = bundle.getBoolean("isStudent");

        Toast.makeText(this, "is Student " + isStudent, Toast.LENGTH_SHORT).show();


        tvResult = findViewById(R.id.tv_result);

        tvResult.setText(name + ", " + roll);



    }

    public void goBack(View view) {
        Intent goBackToLoginActivity = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(goBackToLoginActivity);
    }
}