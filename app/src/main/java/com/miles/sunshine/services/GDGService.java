package com.miles.sunshine.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import com.miles.sunshine.R;

public class GDGService extends Service {
    public GDGService() {
    }
    @Override
    public int onStartCommand(Intent intent,int flag,int flag0){
        //Toast.makeText(getApplicationContext(),"Service started",Toast.LENGTH_LONG).show();
        Notification.Builder builder=
                new Notification.Builder(this)
                .setContentTitle("GDG Sessions")
                .setContentText("Hello world")
                .setSmallIcon(R.mipmap.ic_launcher);
        NotificationManager manager=
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(5,builder.build());
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
