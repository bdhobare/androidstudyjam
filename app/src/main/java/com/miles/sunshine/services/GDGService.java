package com.miles.sunshine.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class GDGService extends Service {
    public GDGService() {
    }
    @Override
    public int onStartCommand(Intent intent,int flag,int flag0){
        Toast.makeText(getApplicationContext(),"Service started",Toast.LENGTH_LONG).show();
        return START_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) {
        return  null;
    }
    @Override
    public void onDestroy(){
    }
}
