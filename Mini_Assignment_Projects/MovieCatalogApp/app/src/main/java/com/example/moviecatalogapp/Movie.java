package com.example.moviecatalogapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Movie implements Parcelable {
    String title;
    String releaseYear;
    String length;
    float rating;
    int photo;
    String synopsis;

    public Movie() {
    }

    public Movie(String title, String releaseYear, String length, float rating, int photo, String synopsis) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.length = length;
        this.rating = rating;
        this.photo = photo;
        this.synopsis = synopsis;
    }

    protected Movie(Parcel in) {
        title = in.readString();
        releaseYear = in.readString();
        length = in.readString();
        rating = in.readFloat();
        photo = in.readInt();
        synopsis = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(releaseYear);
        parcel.writeString(length);
        parcel.writeFloat(rating);
        parcel.writeInt(photo);
        parcel.writeString(synopsis);
    }
}
