package com.miles.sunshine;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.miles.sunshine.adapters.CustomAdapter;
import com.miles.sunshine.models.MovieModel;
import com.miles.sunshine.network.NetworkHandler;
import com.miles.sunshine.services.GDGService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<MovieModel> movies;
    private ProgressDialog dialog;
    CustomAdapter adapter;
    private String url="http://api.androidhive.info/json/movies.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        movies=new ArrayList<>();
        movies.add(getMovie());
        listView=(ListView) findViewById(R.id.movies);
        adapter=new CustomAdapter(movies,this);
        listView.setAdapter(adapter);
        dialog=new ProgressDialog(this);
        dialog.setMessage("Fetching movies...");
        dialog.setIndeterminate(true);
        new GetMovies().execute(url);

        Intent intent=new Intent(getApplicationContext(), GDGService.class);
        startService(intent);

    }
    private class GetMovies extends AsyncTask<String,Void,String>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            String result=new NetworkHandler().get(params[0]);
            return result;
        }
        @Override
        protected void onPostExecute(String s){
            dialog.dismiss();
            //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            if ((s != null) && (!s.isEmpty())){
                Object object=null;
                try{
                    object=new JSONTokener(s).nextValue();
                    if (object instanceof JSONArray){
                        JSONArray array=new JSONArray(s);
                        for (int i=0;i<array.length();i++){
                            MovieModel movieModel=new MovieModel();
                            JSONObject jsonObject=array.getJSONObject(i);
                            movieModel.setName(jsonObject.getString("title"));
                            movieModel.setRating(jsonObject.getString("rating"));
                            movieModel.setImage(jsonObject.getString("image"));
                            movieModel.setReleaseDate(jsonObject.getString("releaseYear"));
                            movies.add(movieModel);
                        }
                        adapter.notifyDataSetChanged();

                    }else {
                        //
                    }

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }

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