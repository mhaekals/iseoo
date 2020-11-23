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

import com.example.lenovog480.iseooalpha.DetailPerkapActivity;
import com.example.lenovog480.iseooalpha.R;
import com.example.lenovog480.iseooalpha.model.JasaModel;

import java.util.List;

/**
 * Created by Lenovo G480 on 11/6/2017.
 */

public class PerlengkapanAdapter extends RecyclerView.Adapter<PerlengkapanAdapter.MyViewHolder> {

    private Context mContext;
    private List<JasaModel> perkapList;

    public PerlengkapanAdapter(Context mContext, List<JasaModel> perkapList) {
            this.mContext = mContext;
            this.perkapList = perkapList;
            }

    @Override
    public PerlengkapanAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.card_perlengkapan, viewGroup, false);

            return new PerlengkapanAdapter.MyViewHolder(itemView);
            }

    @Override
    public void onBindViewHolder(final PerlengkapanAdapter.MyViewHolder viewHolder, int i) {
        viewHolder.namaPerkap.setText(perkapList.get(i).getNama_jasa());
        viewHolder.hargaPerkap.setText(perkapList.get(i).getHarga_jasa());
        viewHolder.kontakPerkap.setText(perkapList.get(i).getKontak());
        // viewHolder.deskSponsor.setText(sponsorList.get(i).getDesk_sponsor());
        viewHolder.jenisEvent.setText(perkapList.get(i).getJenis_event());
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
        return perkapList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView namaPerkap, hargaPerkap, kontakPerkap, deskSponsor, jenisEvent, pemilik;
        public ImageView overflow;

        public MyViewHolder(View view) {
            super(view);
            namaPerkap = (TextView) view.findViewById(R.id.namaPerkap);
            hargaPerkap = (TextView) view.findViewById(R.id.hargaPerkap);
            kontakPerkap = (TextView) view.findViewById(R.id.kontakPerkap);
            //deskSponsor = (TextView) view.findViewById(R.id.deskSponsor);
            jenisEvent = (TextView) view.findViewById(R.id.jenisPerkap);
            //thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            // overflow = (ImageView) view.findViewById(R.id.overflow);

            //item click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        JasaModel clickedDataItem = perkapList.get(pos);
                        Intent intent = new Intent(mContext, DetailPerkapActivity.class);
                        intent.putExtra("id_jasa", perkapList.get(pos).getId_jasa());
                        intent.putExtra("namaJasa", perkapList.get(pos).getNama_jasa());
                        intent.putExtra("hargaJasa", perkapList.get(pos).getHarga_jasa());
                        intent.putExtra("kontakJasa", perkapList.get(pos).getKontak());
                        intent.putExtra("deskripsiJasa", perkapList.get(pos).getDeskripsi_jasa());
                        intent.putExtra("jenisEvent", perkapList.get(pos).getJenis_event());
                        intent.putExtra("pemilikJasa", perkapList.get(pos).getPemilik_jasa());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                        Toast.makeText(view.getContext(), "you clicked" + clickedDataItem.getNama_jasa(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

}
