package com.example.gridviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView myGridView;

    private boolean isGridEnabled = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MyImage> myImages = new ArrayList<>();
        myImages.add(new MyImage("ABC", R.drawable.img1));
        myImages.add(new MyImage("DEF", R.drawable.img2));
        myImages.add(new MyImage("GHI", R.drawable.img3));
        myImages.add(new MyImage("JKL", R.drawable.img4));
        myImages.add(new MyImage("MNO", R.drawable.img5));
        myImages.add(new MyImage("PQR", R.drawable.img6));
        myImages.add(new MyImage("STU", R.drawable.img7));
        myImages.add(new MyImage("VWX", R.drawable.img8));
        myImages.add(new MyImage("YZA", R.drawable.img9));
        myImages.add(new MyImage("BCD", R.drawable.img10));
        myImages.add(new MyImage("ABC", R.drawable.img1));
        myImages.add(new MyImage("DEF", R.drawable.img2));
        myImages.add(new MyImage("GHI", R.drawable.img3));
        myImages.add(new MyImage("JKL", R.drawable.img4));
        myImages.add(new MyImage("MNO", R.drawable.img5));
        myImages.add(new MyImage("PQR", R.drawable.img6));
        myImages.add(new MyImage("STU", R.drawable.img7));
        myImages.add(new MyImage("VWX", R.drawable.img8));
        myImages.add(new MyImage("YZA", R.drawable.img9));
        myImages.add(new MyImage("BCD", R.drawable.img10));



        myGridView = findViewById(R.id.grid_view_main);
        MyGridViewAdapter myAdapter = new MyGridViewAdapter(this, myImages);
        myGridView.setAdapter(myAdapter);

        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, myImages.get(i).getImageID(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.grid_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.options_menu_item1) {
            if(isGridEnabled){
                myGridView.setNumColumns(1);
                isGridEnabled = false;
            } else {
                myGridView.setNumColumns(3);
                isGridEnabled = true;
            }
        }
        
        
        
        
        
        return super.onOptionsItemSelected(item);
    }
}