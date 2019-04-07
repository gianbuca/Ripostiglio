package com.example.giangian.marcello;

import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.content.Intent;
import android.app.NotificationManager;
import android.content.Context;
import android.app.PendingIntent;
import android.widget.Toast;

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
        Toast.makeText(getApplicationContext(), "Messaggio inviato", Toast.LENGTH_LONG).show();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        switch(id)
        {
            case R.id.MENU_1:
                String [] array={""};
                Intent newIntent=new Intent(MainActivity.this, ListActivity.class);
                newIntent.putExtra("StringArray",array);
                startActivity(newIntent);
                break;
            //case R.id.MENU_2:
			/*
			 	Codice di gestione della voce MENU_2
			 */
        }
        return false;
    }
}
