package com.miles.sunshine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button myButton;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton=(Button)findViewById(R.id.button);
        username=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=username.getText().toString();
                String pass=password.getText().toString();
                Bundle bundle=new Bundle();
                bundle.putString("name",name);
                bundle.putString("password",pass);
                //Toast.makeText(getApplicationContext(),"Miles Obare",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();

    }
    @Override
    protected void onResume(){
        super.onResume();

    }
}
