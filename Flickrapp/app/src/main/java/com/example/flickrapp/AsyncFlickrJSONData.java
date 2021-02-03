package com.example.flickrapp;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class AsyncFlickrJSONData extends AsyncTask<String, Void, JSONObject> {
    @Override
    protected JSONObject doInBackground(String... params) {
        JSONObject result = null;

        try {
            // Get the url
            URL url = new URL(params[0]);
            // Connect to the url
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                // Get data
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                String s = readStream(in);
                // Convert to jsonobject
                result = new JSONObject(s);
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    protected void onPostExecute(JSONObject result) {
        try {
            String imageUrl = result.getJSONArray("items").getJSONObject(0).getJSONObject("media").getString("m");
            Log.i("JFL", imageUrl);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read stream then return a string object of the stream
     * @param is InputStream
     * @return String
     */
    private String readStream(InputStream is) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int i = is.read();
            while(i != -1) {
                bo.write(i);
                i = is.read();
            }
            return bo.toString();
        } catch (IOException e) {
            return "";
        }
    }
}
