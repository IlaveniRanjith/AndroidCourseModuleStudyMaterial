package my.first.myloginpageexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    // 1. declare the object
    private TextView tvSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. init it using findViewById

        tvSignUp = findViewById(R.id.tv_sign_up);

        /*tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Signup pressed...", Toast.LENGTH_SHORT).show();
            }
        });*/



    }

    public void onSignUpClicked(View view) {
        //Toast.makeText(this, "hello from signup method", Toast.LENGTH_SHORT).show();

        Intent openSignUpActivity = new Intent(LoginActivity.this, SignupActivity.class);

        openSignUpActivity.putExtra("name", "abhishek");
        openSignUpActivity.putExtra("roll", "001");
        openSignUpActivity.putExtra("isStudent", false);


        startActivity(openSignUpActivity);

        finish();


    }


    public void onLoginButtonPressed(View view) {
        Toast.makeText(this, "Login button pressed...", Toast.LENGTH_SHORT).show();
    }
}