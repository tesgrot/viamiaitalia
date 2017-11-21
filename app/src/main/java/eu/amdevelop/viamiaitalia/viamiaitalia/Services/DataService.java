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
 * Created by terezamadova on 10/11/2017.
 */

public class DataService extends AsyncTask<String, Void, JSONArray> {

    public static final String REQUEST_METHOD = "GET";
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;

    @Override
    protected JSONArray doInBackground(String... strings) {
        String stringUrl = strings[0];
        String result;
        String inputLine;

        try {
            //Create a URL object holding our url
            URL myUrl = new URL(stringUrl);
            //Create a connection
            HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();

            //Set methods and timeouts
            connection.setRequestMethod(REQUEST_METHOD);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);

            Log.d("!!!!!!!!", " PRED CONNECTION CONNECT");

//            connection.setRequestProperty("Authorization", "a5dbf60f");

            //Connect to our url
            connection.connect();
            Log.d("Connection: ", connection.toString());

            Log.d("!!!!!!!!", " PO CONNECTION CONNECT");

            //Create a new InputStreamReader
            InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
            Log.d("!!!!!!!!", " InputStreamReader");
            //Create a new buffered reader and String Builder
            BufferedReader reader = new BufferedReader(streamReader);
            Log.d("!!!!!!!!", " BufferedReader");
            StringBuilder stringBuilder = new StringBuilder();
            Log.d("!!!!!!!!", " StringBuilder");
            //Check if the line we are reading is not null
            while ((inputLine = reader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
            //Close our InputStream and Buffered reader
            reader.close();
            streamReader.close();
            //Set our result equal to our stringBuilder
            result = stringBuilder.toString();

            Log.d("JSON: ", result);

            JSONArray jsonPosts = new JSONArray(result);
            Log.d("JSON: ", jsonPosts.toString());
            return jsonPosts;

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

}
