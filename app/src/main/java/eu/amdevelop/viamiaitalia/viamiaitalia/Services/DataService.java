package eu.amdevelop.viamiaitalia.viamiaitalia.Services;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by terezamadova on 10/11/2017.
 */

public class DataService extends AsyncTask<String, Void, JSONArray> {

    public static final String REQUEST_METHOD = "GET";
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;
    private static String code;

    @Override
    protected JSONArray doInBackground(String... strings) {
        String stringUrl = strings[0];
        String result;
        String inputLine;

        try {
            URL myUrl = new URL(stringUrl);
            HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();

            connection.setRequestMethod(REQUEST_METHOD);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);

            connection.setRequestProperty("Authorization", code);
            int statuscode = connection.getResponseCode();
            if (statuscode == 200) {

                connection.connect();
                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();
                while ((inputLine = reader.readLine()) != null) {
                    stringBuilder.append(inputLine);
                }
                reader.close();
                streamReader.close();
                result = stringBuilder.toString();

                if (result.charAt(0) != '[') {
                    result = '[' + result + ']';
                }
                JSONArray jsonPosts = new JSONArray(result);
                return jsonPosts;
            }
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(JSONArray posts) {
        super.onPostExecute(posts);
    }

    public void setCode(String code) {
        this.code = code;
    }

}
