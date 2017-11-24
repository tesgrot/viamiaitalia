package eu.amdevelop.viamiaitalia.viamiaitalia.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Service;
import eu.amdevelop.viamiaitalia.viamiaitalia.R;
import eu.amdevelop.viamiaitalia.viamiaitalia.RVAdapter;
import eu.amdevelop.viamiaitalia.viamiaitalia.Services.ConnectionCheck;
import eu.amdevelop.viamiaitalia.viamiaitalia.Services.DataManager;
import io.paperdb.Paper;


/**
 * A simple {@link Fragment} subclass.
 */
public class ServicesFragment extends Fragment {

    RecyclerView rv;
    ArrayList<Service> services;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ViewGroup container;
    private ConnectionCheck connectionCheck = new ConnectionCheck();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.container = container;
        View view = inflater.inflate(R.layout.fragment_services, container, false);

        getActivity().setTitle("Services");
        rv = (RecyclerView) view.findViewById(R.id.services_rv);
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);
        adapter = new RVAdapter(getDataSet());
        rv.setAdapter(adapter);

        services = getDataSet();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((RVAdapter) adapter).setOnItemClickListener(new RVAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                int serviceID = services.get(position).getId();

                try {
                    Boolean connectionIsOn = connectionCheck.execute().get();
                    if (connectionIsOn.booleanValue() || Paper.exist("ServiceElements_" + serviceID)) {
                        WineFragment wineFragment = new WineFragment();

                        Bundle bdl = new Bundle(1);
                        bdl.putInt("POSITION", position);
                        wineFragment.setArguments(bdl);

                        android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, wineFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    } else {
                        Toast.makeText(container.getContext(), "No connection", Toast.LENGTH_SHORT).show();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                connectionCheck = null;
                connectionCheck = new ConnectionCheck();
            }
        });
    }

    private ArrayList<Service> getDataSet() {
        ArrayList<Service> results = DataManager.getInstance().getServices();
        return results;
    }

}