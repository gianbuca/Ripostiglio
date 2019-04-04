package com.example.giangian.marcello;

import android.media.Image;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.app.PendingIntent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void invia(android.view.View a){
        EditText input= (EditText) findViewById(R.id.textInput);
        String tmp=input.getText().toString();
        Intent i=new Intent(this,SecondActivity.class);
        i.putExtra("messaggio",tmp);

        int immagine=R.drawable.ic_child_friendly_black_24dp;
        String title="Alert, click me!";
        String context="Sto aprendo una nuova activity";

        Notification(immagine,title,context,i);
    }

    public void changeActivity(android.view.View a){
        startActivity(new Intent(MainActivity.this,SecondActivity.class));
    }

    public void Notification(int img, String title, String content, Intent i){
        PendingIntent pi=PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(this);
            mBuilder.setSmallIcon(img);
            mBuilder.setContentTitle(title);
            mBuilder.setContentText(content);
            mBuilder.setContentIntent(pi);
            mBuilder.setAutoCancel(true);
        NotificationManager mNotificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0000, mBuilder.build());
    }
}
