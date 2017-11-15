package eu.amdevelop.viamiaitalia.viamiaitalia.Fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Contact;
import eu.amdevelop.viamiaitalia.viamiaitalia.R;
import eu.amdevelop.viamiaitalia.viamiaitalia.Services.DataService;
//import eu.amdevelop.viamiaitalia.viamiaitalia.Services.DataService;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {

    public Contact contact;
    public DataService dataService;


    TextView texticek;
    public OrderFragment() {
        dataService = new DataService();
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order, container, false);
        HTTPRequest request = new HTTPRequest();
        texticek = view.findViewById(R.id.textView2);
        request.execute("http:fjweoj");
        // Inflate the layout for this fragment
        return view;
    }


    class HTTPRequest extends AsyncTask<String, Void, Object> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            texticek.setText("Ahoj adamko ja som tu");
        }


        @Override
        protected Object doInBackground(String... strings) {
            texticek.setText("Ahojkajte");
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }
    }





}
