package com.example.lenovog480.iseooalpha.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovog480.iseooalpha.DetailTempatActivity;
import com.example.lenovog480.iseooalpha.R;
import com.example.lenovog480.iseooalpha.model.JasaModel;

import java.util.List;

/**
 * Created by Lenovo G480 on 11/5/2017.
 */

public class TempatAdapter extends RecyclerView.Adapter<TempatAdapter.MyViewHolder> {

    private Context mContext;
    private List<JasaModel> tempatList;

    public TempatAdapter(Context mContext, List<JasaModel> tempatList) {
        this.mContext = mContext;
        this.tempatList = tempatList;
    }

    @Override
    public TempatAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_tempat, viewGroup, false);

        return new TempatAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final TempatAdapter.MyViewHolder viewHolder, int i) {
        viewHolder.namaTempat.setText(tempatList.get(i).getNama_jasa());
        viewHolder.hargaTempat.setText(tempatList.get(i).getHarga_jasa());
        viewHolder.kontakTempat.setText(tempatList.get(i).getKontak());
        // viewHolder.deskSponsor.setText(sponsorList.get(i).getDesk_sponsor());
        viewHolder.jenisEvent.setText(tempatList.get(i).getJenis_event());
        //viewHolder.pemilik.setText(sponsorList.get(i).getPemilik());

        // Picasso.with(mContext).placeholder(R.drawable.threedots).into(viewHolder.thumbnail);

        // viewHolder.overflow.setOnClickListener(new View.OnClickListener() {
        //   @Override
        // public void onClick(View view) {
        //   showPopupMenu(viewHolder.overflow);
        //}
        //});
    }

    @Override
    public int getItemCount() {
        return tempatList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView namaTempat, hargaTempat, kontakTempat, deskSponsor, jenisEvent, pemilik;
        public ImageView overflow;

        public MyViewHolder(View view) {
            super(view);
            namaTempat = (TextView) view.findViewById(R.id.namaTempat);
            hargaTempat = (TextView) view.findViewById(R.id.hargaTempat);
            kontakTempat = (TextView) view.findViewById(R.id.kontakTempat);
            //deskSponsor = (TextView) view.findViewById(R.id.deskSponsor);
            jenisEvent = (TextView) view.findViewById(R.id.jenisTempat);
            //thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            // overflow = (ImageView) view.findViewById(R.id.overflow);

            //item click
            itemView.setOnClickListener(new View.OnClickListener() {
             @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        JasaModel clickedDataItem = tempatList.get(pos);
                        Intent intent = new Intent(mContext, DetailTempatActivity.class);
                        intent.putExtra("id_jasa", tempatList.get(pos).getId_jasa());
                        intent.putExtra("namaTempat", tempatList.get(pos).getNama_jasa());
                        intent.putExtra("hargaTempat", tempatList.get(pos).getHarga_jasa());
                        intent.putExtra("kontakTempat", tempatList.get(pos).getKontak());
                        intent.putExtra("deskripsiTempat", tempatList.get(pos).getDeskripsi_jasa());
                        intent.putExtra("jenisEvent", tempatList.get(pos).getJenis_event());
                        intent.putExtra("pemilikTempat", tempatList.get(pos).getPemilik_jasa());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                        Toast.makeText(view.getContext(), "you clicked" + clickedDataItem.getNama_jasa(), Toast.LENGTH_LONG).show();
                    }
                }
             });
        }
    }
}
