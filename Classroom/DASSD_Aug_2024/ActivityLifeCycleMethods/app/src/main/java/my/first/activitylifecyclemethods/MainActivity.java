package my.first.activitylifecyclemethods;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ACTIVITY_LIFE_CYCLE", "onCreate() method called.....");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ACTIVITY_LIFE_CYCLE", "onStart() method called.....");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ACTIVITY_LIFE_CYCLE", "onResume() method called.....");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ACTIVITY_LIFE_CYCLE", "onPause() method called.....");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ACTIVITY_LIFE_CYCLE", "onRestart() method called.....");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ACTIVITY_LIFE_CYCLE", "onDestroy() method called.....");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ACTIVITY_LIFE_CYCLE", "onStop() method called.....");

    }

    public void openSecondActivity(View view) {
        Intent openSecondActivity = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(openSecondActivity);
    }
}