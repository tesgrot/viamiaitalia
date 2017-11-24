package eu.amdevelop.viamiaitalia.viamiaitalia.Services;

import android.os.AsyncTask;

import java.io.IOException;
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
            URL myUrl = new URL("http://clients3.google.com/generate_204");
            HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();

            connection.setRequestMethod(REQUEST_METHOD);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);

            int statuscode = connection.getResponseCode();
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