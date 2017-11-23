package eu.amdevelop.viamiaitalia.viamiaitalia;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Service;
import eu.amdevelop.viamiaitalia.viamiaitalia.Model.ServiceElement;

/**
 * Created by terezamadova on 21/11/2017.
 */

public class LVAdapter extends ArrayAdapter<ServiceElement> {

    private Service service;

    public LVAdapter(Context context, ArrayList<ServiceElement> elements, Service service) {
        super(context, 0, elements);
        this.service = service;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.service_element, parent, false);
        }
        if (position == 0) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.service_header, parent, false);
            TextView serviceName = (TextView) listItemView.findViewById(R.id.ServiceNameTV);
            TextView servicePrice = (TextView) listItemView.findViewById(R.id.ServicePriceTV);

            Log.d("Service price: ", service.getMinPirce() + "");

            serviceName.setText(service.getName());
            servicePrice.setText(service.getMinPirce() + " EUR");

            // tuto treba pouzit service
        } else {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.service_element, parent, false);

            ServiceElement current = getItem(position);

            TextView descLong = (TextView) listItemView.findViewById(R.id.servItemlongTV);
            ImageView img = (ImageView) listItemView.findViewById(R.id.servItemIV);
            TextView price = (TextView) listItemView.findViewById(R.id.servItemPrice);
            TextView duration = (TextView) listItemView.findViewById(R.id.servItemDur);

            descLong.setText(current.getDescriptionLong());
            price.setText(current.getPricePerson() + " EUR");
            duration.setText(current.getDuration() + " " + current.getDurationUnit());

        }

        return listItemView;
    }

}
