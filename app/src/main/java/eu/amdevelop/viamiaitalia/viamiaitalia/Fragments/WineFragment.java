package eu.amdevelop.viamiaitalia.viamiaitalia.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wine, container, false);

        position = getArguments().getInt("POSITION");


        service = DataManager.getInstance().getServices().get(position);


            getActivity().setTitle(service.getName());

            elements = DataManager.getInstance().getServiceElements(service.getId());
            if (elements != null) {
                elements.add(0, elements.get(0));

                serviceNameTV = (TextView) view.findViewById(R.id.ServiceNameTV);
                servicePriceTV = (TextView) view.findViewById(R.id.ServicePriceTV);
                elementsLV = (ListView) view.findViewById(R.id.elementsLV);

                LVAdapter adapter = new LVAdapter(this.getContext(), elements, service);
                elementsLV.setAdapter(adapter);
            }
//            else {
//                ServicesFragment servicesFragment = new ServicesFragment();
//                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
//                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fragment_container, servicesFragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//
//                Toast.makeText(container.getContext(), "no no no", Toast.LENGTH_LONG).show();
//            }





        return view;
    }

}
