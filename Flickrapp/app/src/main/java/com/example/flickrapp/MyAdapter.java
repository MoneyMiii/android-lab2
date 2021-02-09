package com.example.flickrapp;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.Vector;

public class MyAdapter extends BaseAdapter {
    private Vector<String> vector = new Vector<String>();

    @Override
    public int getCount() {
        return vector.size();
    }

    @Override
    public Object getItem(int position) {
        return vector.get(position);
    }

    @Override
    public long getItemId(int position) {
        return vector.indexOf(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("JFL", "TODO");
        return null;
    }

    public void dd(String url) {
        // Add url to the vector
        vector.add(url);
    }
}
