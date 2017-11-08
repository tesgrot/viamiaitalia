package eu.amdevelop.viamiaitalia.viamiaitalia;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Contact;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView address;
    TextView state;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

//        textView = (TextView) findViewById(R.id.textView);
        address = (TextView) findViewById(R.id.address);
        state = (TextView) findViewById(R.id.state);
//        listView = (ListView) findViewById(R.id.listView);

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://pokeapi.co/api/v2/pokemon/1/")
//                .build();
//        Log.d("Retrofit: ", retrofit.toString());
//        Gson gson = new Gson(retrofit.);
//        Gson gsonPokemon = retrofit.create(Gson.class);
//
//        Log.d("GSON POKEMON: ", gsonPokemon.toJson(gsonPokemon));

//
        AsyncTask background = new BackgroundTasks();
        //background.execute("https://jsonplaceholder.typicode.com/users");
        background.execute("http://10.0.2.2:8000/api/contact");
        //Log.d("",);
//        Object nieco = background
//

        StringBuilder builder = new StringBuilder();
        builder.append("world");
        builder.deleteCharAt(3);
        builder.append(" builder").append(".");
        String built = builder.toString();

    }

    public void render(Object json) {

        JSONObject root;
        Contact contact;
        try {
            root = new JSONObject(json.toString());
            contact = new Contact(root);
            Log.d("Address", contact.getAddress());
            Log.d("JSON Object", root.toString());
            address.setText(contact.getAddress());
            state.setText(contact.getState());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private class BackgroundTasks extends AsyncTask {

        private URL createURL(String url) {
            URL finalURL = null;
            try {
                finalURL = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return finalURL;
        }

        private String makeHttpRequest(URL url) throws IOException {
            String jsonResponse = "";
            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setReadTimeout(10000);
                urlConnection.setConnectTimeout(15000);
                urlConnection.setRequestProperty("Authorization", "Bearer token"); //tokes = access code

                int statusCode = urlConnection.getResponseCode();
                if (statusCode == 200) {
                    urlConnection.connect();
                    inputStream = urlConnection.getInputStream();
                    jsonResponse = readFromStream(inputStream);
                } else {
                    //textView.setText("nieco nefunguje");
                    Log.d("!!! Request", statusCode + "");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            return jsonResponse;
        }

        private String readFromStream(InputStream inputStream) throws IOException {
            StringBuilder output = new StringBuilder();
            if (inputStream != null) {
                InputStreamReader inputStreamReader =
                        new InputStreamReader(inputStream, Charset.forName("UTF-8"));
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line != null) {
                    output.append(line);
                    line = reader.readLine();
                }
            }
            return output.toString();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            URL url = createURL((String) objects[0]);
            String request = null;
            try {
                request = makeHttpRequest(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return request;
        }

        @Override
        protected void onPostExecute(Object o) {
            Log.d("hjf", (String) o);
            render(o);
            super.onPostExecute(o);
        }
    }

}
