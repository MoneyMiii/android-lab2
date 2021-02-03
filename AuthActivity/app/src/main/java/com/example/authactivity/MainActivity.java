package com.example.authactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    boolean res = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get button component by it id
        Button btnAuth    = (Button)findViewById(R.id.btnAuth);

        btnAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get all EditText and TextView components by their ids
                final EditText txtLogin  = (EditText)findViewById(R.id.etLogin);
                final EditText txtPwd    = (EditText)findViewById(R.id.etPwd);
                final TextView txtResult = (TextView)findViewById(R.id.tvResult);
                new Thread () {
                    public void run() {
                        URL url;
                        try {
                            url = new URL("https://httpbin.org/basic-auth/bob/sympa");
                            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                            // Set auth information using user's input
                            String basicAuth = "Basic " + Base64.encodeToString((txtLogin.getText() + ":" + txtPwd.getText()).getBytes(), Base64.NO_WRAP);
                            urlConnection.setRequestProperty("Authorization", basicAuth);
                            try {
                                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                                final String s = readStream(in);
                                Log.i("JFL", s);
                                // Convert string s to JSON object
                                final JSONObject result = new JSONObject(s);
                                // Get authenticated value
                                res = result.getBoolean("authenticated");
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        txtResult.setText((MainActivity.this.res) ? "True" : "False");
                                    }
                                });
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } finally {
                                urlConnection.disconnect();
                            }
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
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
