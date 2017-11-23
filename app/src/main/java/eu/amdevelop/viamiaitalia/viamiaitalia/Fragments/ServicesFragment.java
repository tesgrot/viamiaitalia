package eu.amdevelop.viamiaitalia.viamiaitalia.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Service;
import eu.amdevelop.viamiaitalia.viamiaitalia.R;
import eu.amdevelop.viamiaitalia.viamiaitalia.RVAdapter;
import eu.amdevelop.viamiaitalia.viamiaitalia.Services.DataManager;


/**
 * A simple {@link Fragment} subclass.
 */
public class ServicesFragment extends Fragment {

    RecyclerView rv;

    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_services, container, false);

        getActivity().setTitle("Services");
        rv = (RecyclerView) view.findViewById(R.id.services_rv);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);
        adapter = new RVAdapter(getDataSet());
        rv.setAdapter(adapter);

        ArrayList<Service> services = getDataSet();
        Log.d("Services: (onCreate) ", services.toString());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((RVAdapter) adapter).setOnItemClickListener(new RVAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i("Services Fragment: ", " Clicked on Item " + position);

                WineFragment wineFragment = new WineFragment();

                Bundle bdl = new Bundle(1);
                bdl.putInt("POSITION", position);
                wineFragment.setArguments(bdl);

//                wineFragment.setPosition(position);

                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, wineFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private ArrayList<Service> getDataSet() {
        ArrayList<Service> results = DataManager.getInstance().getServices();
        Log.d("Services: getDataSet() ", results.toString());
        return results;
    }

}