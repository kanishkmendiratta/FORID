package com.example.pd;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BackgroudTask extends AsyncTask<String,Void,Void> {
    @Override
    protected Void doInBackground(String... params) {
        String msg=params[0];
        String msg_url="http://192.168.43.119:5000/start";

        try {

            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(msg_url).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
            JSONObject postJson = new JSONObject();
            postJson.put("msg", msg);
            wr.write(postJson.toString().getBytes());
            wr.flush();
            wr.close();

            InputStream in = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(in);

            int inputStreamData = inputStreamReader.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
