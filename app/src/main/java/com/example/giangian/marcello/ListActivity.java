package com.example.giangian.marcello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    public EditText myInput;
    public ListView myList;
    public  List<String> temp_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    public void add(android.view.View b){
        myInput=(EditText)findViewById(R.id.myInput);
        temp_list.add(myInput.getText().toString());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_local, temp_list);
        myList=(ListView)findViewById(R.id.myList);
        myList.setAdapter(adapter);
        Toast.makeText(getApplicationContext(), "Aggiunto alla to do list", Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
