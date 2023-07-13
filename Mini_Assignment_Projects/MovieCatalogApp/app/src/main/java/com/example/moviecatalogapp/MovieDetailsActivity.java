package com.example.moviecatalogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetailsActivity extends AppCompatActivity {

    private ImageView moviePoster;
    private TextView movieTitle, movieDuration, movieRating, movieReleaseYear, movieSynopsis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        Movie movie = getIntent().getParcelableExtra("movie");

        moviePoster = findViewById(R.id.details_iv_movie_poster);
        movieTitle = findViewById(R.id.details_tv_movie_title);
        movieDuration = findViewById(R.id.details_tv_movie_duration);
        movieRating = findViewById(R.id.details_tv_movie_rating);
        movieReleaseYear = findViewById(R.id.details_tv_movie_release_year);
        movieSynopsis = findViewById(R.id.details_tv_movie_synopsis);

        moviePoster.setImageResource(movie.getPhoto());
        movieTitle.setText(movie.getTitle());
        movieDuration.setText(movie.getLength());
        movieRating.setText(String.valueOf(movie.getRating()));
        movieSynopsis.setText(movie.getSynopsis());
        movieReleaseYear.setText(movie.getReleaseYear());





    }
}