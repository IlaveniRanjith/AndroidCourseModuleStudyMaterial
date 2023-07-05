package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String [] names = new String[]{
                "ABC", "DEF", "GHI", "JKL", "MNO", "ABC", "DEF", "GHI", "JKL", "MNO"
        };

        int [] images = new int[] {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5,
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5

        };

/*

        ArrayList<MyListItem> data = new ArrayList<>();
        data.add(new MyListItem("ABC", R.drawable.img10));
        data.add(new MyListItem("ABC", R.drawable.img10));
        data.add(new MyListItem("ABC", R.drawable.img10));
        data.add(new MyListItem("ABC", R.drawable.img10));

*/


        ListView myListView = findViewById(R.id.list_view);
        MyListViiewAdapter myListViiewAdapter = new MyListViiewAdapter(this, names, images);
        myListView.setAdapter(myListViiewAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, names[i], Toast.LENGTH_SHORT).show();
            }
        });













    }
}