package com.example.flickrapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class AsyncBitmapDownloader extends AsyncTask<String, Void, Bitmap> {
    private final WeakReference<ImageView> iv;

    public AsyncBitmapDownloader(ImageView iv) {
        this.iv = new WeakReference<>(iv);
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        // initialize the result
        Bitmap bmp = null;

        try {
            // Get the url
            URL url = new URL(params[0]);
            // Connect to the url
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                // Get data
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                // Create bmp object
                bmp = BitmapFactory.decodeStream(in);
            } finally {
                urlConnection.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bmp;
    }

    @Override
    protected void onPostExecute(Bitmap bmp) {
        // Setup image
        iv.get().setImageBitmap(bmp);
    }
}
