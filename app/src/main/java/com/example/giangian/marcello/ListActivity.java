package com.example.giangian.marcello;

import android.content.Intent;
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
    public String [] tempArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        tempArray=i.getStringArrayExtra("StringArray");
        myList=(ListView)findViewById(R.id.myListView);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, R.layout.row_input_for_list, R.id.textViewList, tempArray);
        myList.setAdapter(adapter);
    }

    public void add(android.view.View b){

        myInput=(EditText)findViewById(R.id.myEditText);
        for(int i=0; i<tempArray.length; i++){
            if(tempArray[i]==""){
                tempArray[i]= myInput.getText().toString();
            }
        }
        Intent currentIntent=new Intent(this,ListActivity.class);
        currentIntent.putExtra("StringArray",tempArray);
        finish();
        startActivity(currentIntent);
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
