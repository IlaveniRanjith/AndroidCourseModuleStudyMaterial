package com.example.moviecatalogapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyMovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movieList;
    public MyMovieAdapter(Context context, ArrayList<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.layout_movie_list_view_single_item, viewGroup, false);

        ImageView moviePhoto = view.findViewById(R.id.iv_movie_photo);
        TextView movieTitle = view.findViewById(R.id.tv_movie_title);
        TextView movieDate = view.findViewById(R.id.tv_movie_date);
        TextView movieDuration = view.findViewById(R.id.tv_movie_duration);
        TextView movieRating = view.findViewById(R.id.tv_movie_rating);
        ImageView infoImageButton = view.findViewById(R.id.iv_movie_info_button);  //can be used to open webpage for more info

        moviePhoto.setImageResource(movieList.get(i).getPhoto());
        movieTitle.setText(movieList.get(i).getTitle());
        movieDate.setText(movieList.get(i).getReleaseYear());
        movieDuration.setText(movieList.get(i).getLength());
        movieRating.setText(String.valueOf(movieList.get(i).getRating()));

        return view;
    }
}
