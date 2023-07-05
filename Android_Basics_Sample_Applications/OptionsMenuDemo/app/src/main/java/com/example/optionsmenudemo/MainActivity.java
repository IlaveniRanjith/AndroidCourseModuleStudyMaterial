package com.example.optionsmenudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.my_options_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){

                case R.id.menu_item_1:{
                    Toast.makeText(this, "MenuItem1 clicked", Toast.LENGTH_SHORT).show();
                    return true;
                }

                case R.id.menu_item_2:{
                    Toast.makeText(this, "MenuItem2 clicked", Toast.LENGTH_SHORT).show();

                    return true;
                }

                case R.id.menu_item_3:{
                    Toast.makeText(this, "MenuItem3  clicked", Toast.LENGTH_SHORT).show();

                    return true;
                }
                default: {
                    return super.onOptionsItemSelected(item);
                }


            }

    }
}