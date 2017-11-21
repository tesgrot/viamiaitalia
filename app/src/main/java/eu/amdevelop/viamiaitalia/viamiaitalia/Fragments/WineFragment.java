package eu.amdevelop.viamiaitalia.viamiaitalia.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import eu.amdevelop.viamiaitalia.viamiaitalia.LVAdapter;
import eu.amdevelop.viamiaitalia.viamiaitalia.Model.ServiceElement;
import eu.amdevelop.viamiaitalia.viamiaitalia.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class WineFragment extends Fragment {

    ListView elementsLV;
    TextView serviceNameTV;
    TextView servicePriceTV;

    public WineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wine, container, false);

        serviceNameTV = (TextView) view.findViewById(R.id.ServiceNameTV);
        servicePriceTV = (TextView) view.findViewById(R.id.ServicePriceTV);

        elementsLV = (ListView) view.findViewById(R.id.elementsLV);

        /*elementsLV.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });*/

//        elementsLV.setScrollContainer(false);

//        getTotalHeightofListView(elementsLV);

//        View sHeader = inflater.inflate(R.layout.service_header, container, false);
//        elementsLV.addHeaderView(sHeader);
//        setListViewHeightBasedOnChildren(elementsLV);

        ArrayList<ServiceElement> elements = new ArrayList<>();
        elements.add(new ServiceElement(150, 15, 1, "hours", "wine tours"));
        elements.add(new ServiceElement(200, 20, 2, "hours", "mc donald tasting"));
        elements.add(new ServiceElement(240, 17, 3, "minutes", "river splashing"));
        elements.add(0, null); //***toto sa pridava aby bol prvy element header

//        ServiceElement el1 = new ServiceElement(150,15,1,"hours","wine tours");
//        ServiceElement el2 = new ServiceElement(200,20,2,"hours","mc donald tasting");
//        ServiceElement el3 = new ServiceElement(240,17,3,"minutes","river splashing");
//        ServiceElement el4 = new ServiceElement(222,600,4,"minutes","shark fishing");
//        ServiceElement el5 = new ServiceElement(31,750,5,"years","hunting kalkun");

        LVAdapter adapter = new LVAdapter(this.getContext(), elements);
        elementsLV.setAdapter(adapter);

        return view;
    }

    /*public static int getTotalHeightofListView(ListView listView) {
        LVAdapter mAdapter = (LVAdapter) listView.getAdapter();
        int totalHeight = 0;
        for (int i = 0; i < mAdapter.getCount(); i++) {
            View mView = mAdapter.getView(i, null, listView);
            mView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            totalHeight += mView.getMeasuredHeight();
            Log.w("HEIGHT" + i, String.valueOf(totalHeight));
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (mAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
        return totalHeight;
    }*/

    /*public static void setListViewHeightBasedOnChildren(ListView listView)
    {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight=0;
        View view = null;

        for (int i = 0; i < listAdapter.getCount(); i++)
        {
            view = listAdapter.getView(i, view, listView);

            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth,
                        ViewGroup.LayoutParams.MATCH_PARENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();

        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + ((listView.getDividerHeight()) * (listAdapter.getCount()));

        listView.setLayoutParams(params);
        listView.requestLayout();

    }*/

}
