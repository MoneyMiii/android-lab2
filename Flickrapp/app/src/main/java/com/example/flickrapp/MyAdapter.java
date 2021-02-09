package com.example.flickrapp;

import android.content.Context;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;

import java.util.Vector;
import java.util.zip.Inflater;

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
        //Check if the convertview is null, if it is null it probably means that this is the first time the view has been displayed
        if( convertView == null ){
            convertView = View.inflate(parent.getContext(), R.layout.textviewlayout, null);
        } else {
            /*// Get textView then set text
            TextView tvTest = convertView.findViewById(R.id.tv_test);
            tvTest.setText(vector.get(position));*/

            // Get a RequestQueue
            RequestQueue queue = MySingleton.getInstance(parent.getContext()).getRequestQueue();
            // Get the component
            ImageView iv = convertView.findViewById(R.id.iv_list);
        }
        return convertView;
    }

    public void dd(String url) {
        // Add url to the vector
        vector.add(url);
    }
}
