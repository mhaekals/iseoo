package com.example.lenovog480.iseooalpha.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovog480.iseooalpha.DetailRequestActivity;
import com.example.lenovog480.iseooalpha.R;
import com.example.lenovog480.iseooalpha.model.RequestModel;

import java.util.List;

/**
 * Created by Lenovo G480 on 12/18/2017.
 */

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.MyViewHolder>{
    private Context mContext;
    private List<RequestModel> orderList;

    public RequestAdapter(Context mContext, List<RequestModel> orderList) {
        this.mContext = mContext;
        this.orderList = orderList;
    }

    @Override
    public RequestAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_request, parent, false);
        RequestAdapter.MyViewHolder holder = new RequestAdapter.MyViewHolder(v);

        return holder;
    }


    @Override
    public void onBindViewHolder(final RequestAdapter.MyViewHolder viewHolder, int i) {
        viewHolder.namaSpons.setText(orderList.get(i).getNama_sponsor());
        //viewHolder.namaPemilik.setText(orderList.get(i).getPemilik());
    }


    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView namaSpons, namaPemilik;

        public MyViewHolder(View view) {
            super(view);
            namaSpons = (TextView)view.findViewById(R.id.txt_namaSpons);
            //namaPemilik = (TextView)view.findViewById(R.id.txt_namaPemilik);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        RequestModel clickedDataItem = orderList.get(pos);
                        Intent intent = new Intent(mContext, DetailRequestActivity.class);
                        intent.putExtra("id_request", orderList.get(pos).getId_request());
                        intent.putExtra("nama_event", orderList.get(pos).getNama_event());
                        intent.putExtra("jenis_event", orderList.get(pos).getJenis_event());
                        intent.putExtra("creator", orderList.get(pos).getCreator());
                        intent.putExtra("nama_spons", orderList.get(pos).getNama_sponsor());
                        intent.putExtra("lama_event", orderList.get(pos).getLama_event());
                        intent.putExtra("tanggal_mulai", orderList.get(pos).getTanggal_mulai());
                        intent.putExtra("tanggal_order", orderList.get(pos).getTanggal_request());
                        intent.putExtra("status", orderList.get(pos).getStatus());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                        Toast.makeText(view.getContext(), "you clicked" + clickedDataItem.getNama_sponsor(), Toast.LENGTH_LONG).show();

                    }
                }
            });

        }
    }}
