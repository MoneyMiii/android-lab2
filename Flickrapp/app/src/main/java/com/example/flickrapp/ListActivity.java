package com.example.flickrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        // Get ListView component by its id
        ListView lv = findViewById(R.id.list);

        // Create a adapter
        MyAdapter adapter = new MyAdapter();

        // Link the adapter to the ListView
        lv.setAdapter(adapter);
    }
}
