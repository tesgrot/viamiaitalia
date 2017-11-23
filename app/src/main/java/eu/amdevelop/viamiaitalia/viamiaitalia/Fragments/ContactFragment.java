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

    TextView name;
    TextView phone;
    TextView mail;
    TextView address;

    public ContactFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        getActivity().setTitle("Contact");

        name = (TextView) view.findViewById(R.id.contact_name);
        phone = (TextView) view.findViewById(R.id.contact_phone);
        mail = (TextView) view.findViewById(R.id.contact_mail);
        address = (TextView) view.findViewById(R.id.contact_address);
        try {
            Contact contact = getDataSet();
            Log.d("onCreat from getDataSet", contact.toString());

            name.setText(contact.getContactPerson());
            phone.setText(contact.getPhone());
            mail.setText(contact.getEmail());
            address.setText(contact.getAddress()); //TODO treba adresu poskladat z street+no+city
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


        return view;
    }

    private Contact getDataSet() {
        Contact results = DataManager.getInstance().getContact();
        Log.d("Contact (getDataSet): ", results.toString());
        return results;
    }

}
