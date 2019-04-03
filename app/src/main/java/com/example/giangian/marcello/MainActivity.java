package com.example.giangian.marcello;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;


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
        startActivity(i);
    }

    public void changeActivity(android.view.View a){
        startActivity(new Intent(MainActivity.this,SecondActivity.class));
    }

    public void PushNotification(Image a, String b){
        NotificationManager NM;
        NM=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

    }
}
