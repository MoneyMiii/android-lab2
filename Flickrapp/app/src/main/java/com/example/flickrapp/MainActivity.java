package com.example.flickrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get button component to get image
        Button btnGetImg = findViewById(R.id.btnGetImg);

        // Retrieve the image container
        ImageView image = findViewById(R.id.image);

        // Set up the button
        btnGetImg.setOnClickListener(new GetImageOnClickListener(image));
    }
}
