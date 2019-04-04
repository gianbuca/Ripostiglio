package com.example.giangian.marcello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.content.Intent;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i = getIntent();
        TextView output=(TextView) findViewById(R.id.textOutput);
        output.setText(i.getStringExtra("messaggio"));
    }

    public void cancella(android.view.View b){
        TextView output= (TextView) findViewById(R.id.textOutput);
        output.setText("");
    }

    public void back(android.view.View c){
        startActivity(new Intent(SecondActivity.this,MainActivity.class));
    }
}
