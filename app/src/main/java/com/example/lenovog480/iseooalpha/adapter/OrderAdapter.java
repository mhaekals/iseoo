package com.example.lenovog480.iseooalpha.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovog480.iseooalpha.DetailOrderActivity;
import com.example.lenovog480.iseooalpha.R;
import com.example.lenovog480.iseooalpha.model.OrderModel;

import java.util.List;

/**
 * Created by Lenovo G480 on 12/18/2017.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder>{
    private Context mContext;
    private List<OrderModel> orderList;

    public OrderAdapter(Context mContext, List<OrderModel> orderList) {
        this.mContext = mContext;
        this.orderList = orderList;
    }

    @Override
    public OrderAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_order, parent, false);
        OrderAdapter.MyViewHolder holder = new OrderAdapter.MyViewHolder(v);

        return holder;
    }


    @Override
    public void onBindViewHolder(final OrderAdapter.MyViewHolder viewHolder, int i) {
        viewHolder.namaJasa.setText(orderList.get(i).getNama_jasa());
        viewHolder.namaPemilik.setText(orderList.get(i).getPemilik());
    }


    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView namaJasa, namaPemilik;

        public MyViewHolder(View view) {
            super(view);
            namaJasa = (TextView)view.findViewById(R.id.txt_namaJasa);
            namaPemilik = (TextView)view.findViewById(R.id.txt_namaPemilik);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        OrderModel clickedDataItem = orderList.get(pos);
                        Intent intent = new Intent(mContext, DetailOrderActivity.class);
                        intent.putExtra("id_order", orderList.get(pos).getId_order());
                        intent.putExtra("nama_event", orderList.get(pos).getNama_event());
                        intent.putExtra("creator", orderList.get(pos).getCreator());
                        intent.putExtra("nama_jasa", orderList.get(pos).getNama_jasa());
                        intent.putExtra("lama_event", orderList.get(pos).getLama_event());
                        intent.putExtra("tanggal_mulai", orderList.get(pos).getTanggal_mulai());
                        intent.putExtra("tanggal_order", orderList.get(pos).getTanggal_order());
                        intent.putExtra("status", orderList.get(pos).getStatus());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                        Toast.makeText(view.getContext(), "you clicked" + clickedDataItem.getNama_jasa(), Toast.LENGTH_LONG).show();

                    }
                }
            });

        }
    }}

