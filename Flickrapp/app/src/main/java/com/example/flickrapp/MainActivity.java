package com.example.flickrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get button components by their id
        Button btnGetImg = findViewById(R.id.btnGetImg);
        Button btnGoListActivity = findViewById(R.id.btnGoListActivity);

        // Retrieve the image container
        ImageView image = findViewById(R.id.image);

        // Set up the button
        btnGetImg.setOnClickListener(new GetImageOnClickListener(image));

        // Set up the button to go the the List Activity
        btnGoListActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
            }
        });
    }
}
