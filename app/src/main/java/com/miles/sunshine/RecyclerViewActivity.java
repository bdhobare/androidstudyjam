package com.miles.sunshine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.miles.sunshine.models.MovieModel;
import com.miles.sunshine.recyclerview.DividerItemDecoration;
import com.miles.sunshine.recyclerview.MoviesAdapter;
import com.miles.sunshine.recyclerview.RecyclerTouchListener;

import java.util.ArrayList;


public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    ArrayList<MovieModel> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        movies=new ArrayList<>();
        movies.add(getMovie());
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mAdapter = new MoviesAdapter(movies);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                MovieModel movie = movies.get(position);
                Toast.makeText(getApplicationContext(), movie.getName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


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
