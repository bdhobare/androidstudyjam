package com.miles.sunshine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<MovieModel> movies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        movies=new ArrayList<>();
        movies.add(getMovie());
        listView=(ListView) findViewById(R.id.movies);
        CustomAdapter adapter=new CustomAdapter(movies,this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
    public  MovieModel getMovie(){
        MovieModel model=new MovieModel();
        model.setName("SUICIDE SQUAD");
        model.setRating("9.8");
        model.setReleaseDate("2016");
        model.setImage("http://i.imgur.com/DvpvklR.png");
        return  model;
    }
}
