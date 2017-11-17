package eu.amdevelop.viamiaitalia.viamiaitalia.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import eu.amdevelop.viamiaitalia.viamiaitalia.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccommodationFragment extends Fragment/* implements OnMapReadyCallback*/ {

//    MapView mapView;
//    GoogleMap googleMap;
//    private WebView contactWebView;


    private SupportMapFragment fragment;
    private GoogleMap map;
    public AccommodationFragment() {
        // Required empty public constructor
        // https://maps.googleapis.com/maps/api/js?key=AIzaSyAZw4pjBs_3Ofg-QBMKnmodZiYwwF4sadc&callback=initMap&libraries=places
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_accommodation, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentManager fm = getChildFragmentManager();
        fragment = (SupportMapFragment) fm.findFragmentById(R.id.map);
        if (fragment == null) {
            fragment = SupportMapFragment.newInstance();
            fm.beginTransaction().replace(R.id.map, fragment).commit();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (map == null) {
//            map = fragment.getMap(); TOTO TU ALE MA BYT, LEN TO NEFUNGUJE :(
            map.addMarker(new MarkerOptions().position(new LatLng(0, 0)));
        }
    }

    /*public static String StreamToString(InputStream in) throws IOException {
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
//        MapFragment mapFragment = getFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        goToLocation(40, 70);
    }

    private void goToLocation(double lat, double lng) {
        LatLng ll = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLng(ll);
        googleMap.moveCamera(update);

    }*/
}