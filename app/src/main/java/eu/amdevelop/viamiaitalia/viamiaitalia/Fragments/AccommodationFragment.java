package eu.amdevelop.viamiaitalia.viamiaitalia.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import eu.amdevelop.viamiaitalia.viamiaitalia.CustomMapView;
import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Accommodation;
import eu.amdevelop.viamiaitalia.viamiaitalia.R;
import eu.amdevelop.viamiaitalia.viamiaitalia.Services.DataManager;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccommodationFragment extends Fragment implements OnMapReadyCallback {

    static int position;
    TextView name, area, descLong, bathNo, bedNo, address, addressGPS;
    LatLng latLng;
    private GoogleMap mGoogleMap;
    private CustomMapView mMapView;
    private View view;
    private boolean mapsSupported = true;
    private Accommodation accommodation;
    private LinearLayout navigateContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_accommodation, container, false);

        position = getArguments().getInt("POSITION");

        accommodation = DataManager.getInstance().getAccommodation(position);

        latLng = new LatLng(accommodation.getLatitude(), accommodation.getLongitude());

        getActivity().setTitle("Accommodation");

        navigateContainer = view.findViewById(R.id.navigate_container);
        navigateContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("http://maps.google.com/maps?daddr=" + latLng.latitude + "," + latLng.longitude);

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        name = (TextView) view.findViewById(R.id.accommodation_name);
        area = (TextView) view.findViewById(R.id.accommodation_area);
        descLong = (TextView) view.findViewById(R.id.accommodation_desc_long);
        bathNo = (TextView) view.findViewById(R.id.accommodation_bathr_no);
        bedNo = (TextView) view.findViewById(R.id.accommodation_bedr_no);
        address = (TextView) view.findViewById(R.id.address);
        addressGPS = (TextView) view.findViewById(R.id.address_gps);

        name.setText(accommodation.getName());
        descLong.setText(accommodation.getDescriptionLong());
        bathNo.setText(accommodation.getNoBath() + "");
        bedNo.setText(accommodation.getNoBed() + "");
        address.setText(accommodation.getAddress());
        addressGPS.setText("GPS: " + accommodation.getLatitude() + ", " + accommodation.getLongitude());

//TODO add apartments
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMapView = (CustomMapView) this.view.findViewById(R.id.mapView);
        if (mMapView != null) {
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;

        googleMap.addMarker(new MarkerOptions().position(latLng).title("Your accommodation"));

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10.0f));
    }


}
