package com.example.flickrapp;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

public class GetImageOnClickListener implements View.OnClickListener {
    public GetImageOnClickListener(ImageView image) {
        onClick(image);
    }
    @Override
    public void onClick(View v){
        String url = "https://www.flickr.com/services/feeds/photos_public.gne?tags=trees&format=json&nojsoncallback=?";
        new AsyncFlickrJSONData().execute(url);
    }
}
