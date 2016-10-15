package com.miles.sunshine;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by miles on 10/15/16.
 */

public class CustomAdapter extends BaseAdapter {
    ArrayList<MovieModel> movies;
    Activity activity;
    public CustomAdapter(ArrayList<MovieModel> movies, Activity activity){
       this.movies=movies;
        this.activity=activity;
    }
    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=activity.getLayoutInflater().inflate(R.layout.movie,null,false);
        ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
        TextView name=(TextView)view.findViewById(R.id.name);
        TextView rating=(TextView)view.findViewById(R.id.rating);
        TextView releaseDate=(TextView)view.findViewById(R.id.releaseDate);

        name.setText(movies.get(position).getName());
        rating.setText(movies.get(position).getRating());
        releaseDate.setText(movies.get(position).getReleaseDate());
        Picasso.with(activity).load(movies.get(position).getImage()).into(imageView);
        return view;
    }
}
