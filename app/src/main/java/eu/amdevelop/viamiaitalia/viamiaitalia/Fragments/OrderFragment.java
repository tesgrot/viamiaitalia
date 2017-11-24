package eu.amdevelop.viamiaitalia.viamiaitalia.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Order;
import eu.amdevelop.viamiaitalia.viamiaitalia.R;
import eu.amdevelop.viamiaitalia.viamiaitalia.Services.DataManager;

public class OrderFragment extends Fragment {

    TextView name, mail, phone, noOfPpl, noOfChildren, checkInTime, checkInDate, checkOutTime, checkOutDate, accommName, accommApart;
    Button accommBtn;

    public OrderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order, container, false);

        getActivity().setTitle("Your Order");

        name = (TextView) view.findViewById(R.id.order_info_nameTV);
        mail = (TextView) view.findViewById(R.id.order_info_mailTV);
        phone = (TextView) view.findViewById(R.id.order_info_phoneTV);
        noOfPpl = (TextView) view.findViewById(R.id.order_info_nopplTV);
        noOfChildren = (TextView) view.findViewById(R.id.order_info_nochTV);
        checkInDate = (TextView) view.findViewById(R.id.order_chin_dateTV);
        checkInTime = (TextView) view.findViewById(R.id.order_chin_timeTV);
        checkOutDate = (TextView) view.findViewById(R.id.order_chout_dateTV);
        checkOutTime = (TextView) view.findViewById(R.id.order_chout_timeTV);
        accommName = (TextView) view.findViewById(R.id.order_ainfo_accommTV);
        accommApart = (TextView) view.findViewById(R.id.order_ainfo_apartTV);
        accommBtn = (Button) view.findViewById(R.id.order_accommBtn);

        accommBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                AccommodationFragment accommodationFragment = new AccommodationFragment();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, accommodationFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        try {
            Order order = getDataSet();

//            name.setText();

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return view;
    }

    private Order getDataSet() {
        Order results = DataManager.getInstance().getOrder();
        return results;
    }

}
