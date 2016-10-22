package com.miles.sunshine;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.miles.sunshine.adapters.CustomAdapter;
import com.miles.sunshine.models.MovieModel;
import com.miles.sunshine.network.NetworkHandler;

import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<MovieModel> movies;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        movies=new ArrayList<>();
        movies.add(getMovie());
        dialog=new ProgressDialog(this);
        dialog.setMessage("Fetching images");
        dialog.setIndeterminate(true);
        listView=(ListView) findViewById(R.id.movies);
        CustomAdapter adapter=new CustomAdapter(movies,this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        new GetImages().execute("http://api.androidhive.info/json/movies.json");

    }
    private class GetImages extends AsyncTask<String,Void,String>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            return new NetworkHandler().get(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            dialog.dismiss();
            Log.d(MovieActivity.class.getName(),s);
        }
    }
    /*
    * Create a sample movie
    * */
    public  MovieModel getMovie(){
        MovieModel model=new MovieModel();
        model.setName("SUICIDE SQUAD");
        model.setRating("9.8");
        model.setReleaseDate("2016");
        model.setImage("http://i.imgur.com/DvpvklR.png");
        return  model;
    }
}
