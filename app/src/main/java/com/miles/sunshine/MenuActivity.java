package com.miles.sunshine;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements AdapterView.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        TextView source=(TextView)findViewById(R.id.source);
        Button main=(Button)findViewById(R.id.mainactivity);
        Button movie=(Button)findViewById(R.id.movie);
        Button recycler=(Button)findViewById(R.id.recycler);
        Button news=(Button)findViewById(R.id.news);

        source.setOnClickListener(this);
        main.setOnClickListener(this);
        movie.setOnClickListener(this);
        recycler.setOnClickListener(this);
        news.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
            case R.id.source:
                 openWebPage("https://github.com/bdhobare/androidstudyjam");
                 break;
            case R.id.mainactivity:
                intent=new Intent(getApplicationContext(),MainActivity.class);
                break;
            case R.id.movie:
                intent=new Intent(getApplicationContext(),MovieActivity.class);
                break;
            case R.id.recycler:
                intent=new Intent(getApplicationContext(),RecyclerViewActivity.class);
                break;
            case R.id.news:
                intent=new Intent(getApplicationContext(),NewsActivity.class);
                break;
            default:
                intent=new Intent(getApplicationContext(),MovieActivity.class);

        }
        if (intent != null)
            startActivity(intent);
    }
    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }else {
            Toast.makeText(getApplicationContext(),"No browser installed",Toast.LENGTH_SHORT).show();
        }
    }
}
