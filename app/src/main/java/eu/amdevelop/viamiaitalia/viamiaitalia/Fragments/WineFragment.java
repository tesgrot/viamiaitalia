package eu.amdevelop.viamiaitalia.viamiaitalia.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import eu.amdevelop.viamiaitalia.viamiaitalia.LVAdapter;
import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Service;
import eu.amdevelop.viamiaitalia.viamiaitalia.Model.ServiceElement;
import eu.amdevelop.viamiaitalia.viamiaitalia.R;
import eu.amdevelop.viamiaitalia.viamiaitalia.Services.DataManager;


/**
 * A simple {@link Fragment} subclass.
 */
public class WineFragment extends Fragment {

    static int position = 0;
    ListView elementsLV;
    TextView serviceNameTV;
    TextView servicePriceTV;
    private Service service;
    private ArrayList<ServiceElement> elements = new ArrayList<>();

    public WineFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wine, container, false);

        position = getArguments().getInt("POSITION");

        service = DataManager.getInstance().getServices().get(position);


        getActivity().setTitle(service.getName());

        elements = DataManager.getInstance().getServiceElements(service.getId());
        elements.add(0, elements.get(0));
        Log.d("Service: ", service.toString());

        serviceNameTV = (TextView) view.findViewById(R.id.ServiceNameTV);
        servicePriceTV = (TextView) view.findViewById(R.id.ServicePriceTV);

        elementsLV = (ListView) view.findViewById(R.id.elementsLV);

        LVAdapter adapter = new LVAdapter(this.getContext(), elements, service);
        elementsLV.setAdapter(adapter);

        return view;
    }

}
