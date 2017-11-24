package eu.amdevelop.viamiaitalia.viamiaitalia.Services;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Marek on 24. 11. 2017.
 */

public class ConnectionCheck extends AsyncTask<String, Void, Boolean> {

    public static final String REQUEST_METHOD = "GET";
    public static final int READ_TIMEOUT = 1000;
    public static final int CONNECTION_TIMEOUT = 1000;

    @Override
    protected Boolean doInBackground(String... strings) {
        try {
            //Create a URL object holding our url
            URL myUrl = new URL("http://clients3.google.com/generate_204");
            //Create a connection
            HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();

            //Set methods and timeouts
            connection.setRequestMethod(REQUEST_METHOD);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);

            int statuscode = connection.getResponseCode();
            Log.d("XXX", "netIsAvailable: code: " + statuscode);
            if (statuscode == 204) {
                return true;
            }

            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


}