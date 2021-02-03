package com.example.flickrapp;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

public class GetImageOnClickListener implements View.OnClickListener {
    private ImageView iv;
    public GetImageOnClickListener(ImageView image) {
        this.iv = image;
    }
    @Override
    public void onClick(View v){
        String url = "https://www.flickr.com/services/feeds/photos_public.gne?tags=trees&format=json&nojsoncallback=?";
        new AsyncFlickrJSONData(new AsyncBitmapDownloader(iv)).execute(url);
    }
}
