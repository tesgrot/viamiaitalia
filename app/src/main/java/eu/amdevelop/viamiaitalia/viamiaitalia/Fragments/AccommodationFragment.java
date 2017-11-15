package eu.amdevelop.viamiaitalia.viamiaitalia.Fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import eu.amdevelop.viamiaitalia.viamiaitalia.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccommodationFragment extends Fragment implements OnMapReadyCallback {

    MapView mapView;
    GoogleMap googleMap;
//    private WebView contactWebView;


    public AccommodationFragment() {
        // Required empty public constructor
        // https://maps.googleapis.com/maps/api/js?key=AIzaSyAZw4pjBs_3Ofg-QBMKnmodZiYwwF4sadc&callback=initMap&libraries=places
    }

    public static String StreamToString(InputStream in) throws IOException {
        if (in == null) {
            return "";
        }
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
        }
        return writer.toString();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_accommodation, container, false);
        if (googleServicesAvailable()) {
            Toast.makeText(getActivity(), "All OK", Toast.LENGTH_SHORT).show();

        }

        return view;
    }

    public boolean googleServicesAvailable() {

        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(getContext());
        if (isAvailable == ConnectionResult.SUCCESS) {
            return true;
        } else if (api.isUserResolvableError(isAvailable)) {
            Dialog dialog = api.getErrorDialog(getActivity(), isAvailable, 0);
            dialog.show();
        } else {
            Toast.makeText(getActivity(), "Cannot connect to play services", Toast.LENGTH_LONG).show();
        }

        return false;
    }

    private void initMap() {
//        MapFragment mapFragment = getFragmentManager().findFragmentById(R.id.mapView);
//        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }
}