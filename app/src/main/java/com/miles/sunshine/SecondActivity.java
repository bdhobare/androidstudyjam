package com.miles.sunshine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button=(Button)findViewById(R.id.button2);
        TextView username=(TextView)findViewById(R.id.username);
        if (getIntent() !=null){
            Intent intent=getIntent();
            Bundle bundle=intent.getExtras();
            String name=bundle.getString("name");
            username.setText(name);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}
