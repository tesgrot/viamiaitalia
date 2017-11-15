package eu.amdevelop.viamiaitalia.viamiaitalia;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import eu.amdevelop.viamiaitalia.viamiaitalia.Model.Service;

/**
 * Created by terezamadova on 11/11/2017.
 */

public class RVAdapter extends RecyclerView
        .Adapter<RVAdapter
        .DataObjectHolder> {
    private static MyClickListener myClickListener;
    private ArrayList<Service> mDataset;

    public RVAdapter(ArrayList<Service> myDataset) {
        mDataset = myDataset;
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.service_card, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.service_name.setText(mDataset.get(position).getName());
        holder.service_description.setText(mDataset.get(position).getDescription());
    }

    public void addItem(Service service, int index) {
        mDataset.add(index, service);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView service_name;
        TextView service_description;

        public DataObjectHolder(View itemView) {
            super(itemView);
            service_name = (TextView) itemView.findViewById(R.id.service_name);
            service_description = (TextView) itemView.findViewById(R.id.service_description);
            Log.i("RVAdapter", "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }
}