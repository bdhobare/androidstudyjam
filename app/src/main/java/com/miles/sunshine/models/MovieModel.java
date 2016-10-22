package com.miles.sunshine.models;

/**
 * Created by miles on 10/15/16.
 */

public class MovieModel {
    String name;
    String image;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    String rating;
    String releaseDate;
    public String getName(){
        return  name;
    }
    public void setName(String name){
        this.name=name;
    }
}
