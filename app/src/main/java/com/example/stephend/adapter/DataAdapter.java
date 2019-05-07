package com.example.stephend.adapter;

/**
 * Created by stephend on 5/7/19.
 */

import com.example.stephend.model.Contact;
import com.example.stephend.testing.R;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<Contact> contact;


    public DataAdapter(ArrayList<Contact> contact) {
        this.contact = contact;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        holder.tv_name.setText(contact.get(position).getName());
        holder.tv_version.setText(contact.get(position).getAddress());
        holder.tv_api_level.setText(contact.get(position).getPhone().getMobile());
    }

    @Override
    public int getItemCount() {
        return contact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_version;
        private TextView tv_api_level;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_name = (TextView)itemView.findViewById(R.id.tv_name);
            tv_version = (TextView)itemView.findViewById(R.id.tv_address);
            tv_api_level = (TextView)itemView.findViewById(R.id.tv_mobile);

        }
    }
}