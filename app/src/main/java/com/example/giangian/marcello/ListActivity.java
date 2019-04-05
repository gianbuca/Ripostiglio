package com.example.giangian.marcello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public List<String> mlist;

    public void add(android.view.View b){
        EditText input= (EditText) findViewById(R.id.textInput);
        String tmp=input.getText().toString();

        ListView list=(ListView) findViewById(R.id.myList);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>
                (ListActivity.this, android.R.layout.simple_list_item_1, mlist);

        mlist.add(tmp);
        list.setAdapter(adapter);

        mlist.add(input.getText().toString());

        adapter.notifyDataSetChanged();

    }


}
