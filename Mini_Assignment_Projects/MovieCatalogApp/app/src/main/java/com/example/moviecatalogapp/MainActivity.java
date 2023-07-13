package com.example.moviecatalogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Movie> imdbTopMoviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateDummyMovieData();

        ListView movieListView = findViewById(R.id.movie_list_view);
        MyMovieAdapter myMovieAdapter = new MyMovieAdapter(MainActivity.this, imdbTopMoviesList);
        movieListView.setAdapter(myMovieAdapter);

        movieListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MovieDetailsActivity.class);
                intent.putExtra("movie", imdbTopMoviesList.get(i));
                startActivity(intent);
            }
        });
    }

    private void generateDummyMovieData() {
        imdbTopMoviesList = new ArrayList<Movie>();
        /*
        * Refer: https://www.imdb.com/chart/top/
        * Movie constructor:
        *
        * String title,
        * String releaseYear,
        * String length,
        * float rating,
        * int photo,
        * String synopsis
        * */

        imdbTopMoviesList.add(new Movie(
                "The Shawshank Redemption",
                "1994",
                "2h 22m",
                9.3f,
                R.drawable.img_movie_one,
                "Over the course of several years, two convicts form a friendship, seeking consolation and, eventually, redemption through basic compassion."));

        imdbTopMoviesList.add(new Movie(
                "The The Godfather",
                "1972",
                "2h 55m",
                9.2f,
                R.drawable.img_movie_two,
                "Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son Michael. However, his decision unintentionally puts the lives of his loved ones in grave danger."));

        imdbTopMoviesList.add(new Movie(
                "The Dark Knight",
                "2008",
                "2h 32m",
                9.0f,
                R.drawable.img_movie_three,
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice."));


        imdbTopMoviesList.add(new Movie(
                "The Shawshank Redemption",
                "1994",
                "2h 22m",
                9.3f,
                R.drawable.img_movie_one,
                "Over the course of several years, two convicts form a friendship, seeking consolation and, eventually, redemption through basic compassion."));

        imdbTopMoviesList.add(new Movie(
                "The The Godfather",
                "1972",
                "2h 55m",
                9.2f,
                R.drawable.img_movie_two,
                "Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son Michael. However, his decision unintentionally puts the lives of his loved ones in grave danger."));

        imdbTopMoviesList.add(new Movie(
                "The Dark Knight",
                "2008",
                "2h 32m",
                9.0f,
                R.drawable.img_movie_three,
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice."));


        imdbTopMoviesList.add(new Movie(
                "The Shawshank Redemption",
                "1994",
                "2h 22m",
                9.3f,
                R.drawable.img_movie_one,
                "Over the course of several years, two convicts form a friendship, seeking consolation and, eventually, redemption through basic compassion."));

        imdbTopMoviesList.add(new Movie(
                "The The Godfather",
                "1972",
                "2h 55m",
                9.2f,
                R.drawable.img_movie_two,
                "Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son Michael. However, his decision unintentionally puts the lives of his loved ones in grave danger."));

        imdbTopMoviesList.add(new Movie(
                "The Dark Knight",
                "2008",
                "2h 32m",
                9.0f,
                R.drawable.img_movie_three,
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice."));

        imdbTopMoviesList.add(new Movie(
                "The Shawshank Redemption",
                "1994",
                "2h 22m",
                9.3f,
                R.drawable.img_movie_one,
                "Over the course of several years, two convicts form a friendship, seeking consolation and, eventually, redemption through basic compassion."));

        imdbTopMoviesList.add(new Movie(
                "The The Godfather",
                "1972",
                "2h 55m",
                9.2f,
                R.drawable.img_movie_two,
                "Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son Michael. However, his decision unintentionally puts the lives of his loved ones in grave danger."));

        imdbTopMoviesList.add(new Movie(
                "The Dark Knight",
                "2008",
                "2h 32m",
                9.0f,
                R.drawable.img_movie_three,
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice."));

        imdbTopMoviesList.add(new Movie(
                "The Shawshank Redemption",
                "1994",
                "2h 22m",
                9.3f,
                R.drawable.img_movie_one,
                "Over the course of several years, two convicts form a friendship, seeking consolation and, eventually, redemption through basic compassion."));

        imdbTopMoviesList.add(new Movie(
                "The The Godfather",
                "1972",
                "2h 55m",
                9.2f,
                R.drawable.img_movie_two,
                "Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son Michael. However, his decision unintentionally puts the lives of his loved ones in grave danger."));

        imdbTopMoviesList.add(new Movie(
                "The Dark Knight",
                "2008",
                "2h 32m",
                9.0f,
                R.drawable.img_movie_three,
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice."));

        imdbTopMoviesList.add(new Movie(
                "The Shawshank Redemption",
                "1994",
                "2h 22m",
                9.3f,
                R.drawable.img_movie_one,
                "Over the course of several years, two convicts form a friendship, seeking consolation and, eventually, redemption through basic compassion."));

        imdbTopMoviesList.add(new Movie(
                "The The Godfather",
                "1972",
                "2h 55m",
                9.2f,
                R.drawable.img_movie_two,
                "Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son Michael. However, his decision unintentionally puts the lives of his loved ones in grave danger."));

        imdbTopMoviesList.add(new Movie(
                "The Dark Knight",
                "2008",
                "2h 32m",
                9.0f,
                R.drawable.img_movie_three,
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice."));



    }
}