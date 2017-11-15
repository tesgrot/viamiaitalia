package eu.amdevelop.viamiaitalia.viamiaitalia.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Contact;
import eu.amdevelop.viamiaitalia.viamiaitalia.R;
import eu.amdevelop.viamiaitalia.viamiaitalia.Services.DataManager;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {

    TextView address;

    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        Contact contact = DataManager.getInstance().getContact();
        Log.d("", contact.toString());

        address = (TextView) view.findViewById(R.id.contact_address);
        address.setText(contact.getAddress());


        return view;
    }

}
