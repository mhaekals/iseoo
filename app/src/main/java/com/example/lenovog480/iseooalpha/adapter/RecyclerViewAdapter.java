package com.example.lenovog480.iseooalpha.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovog480.iseooalpha.DetailEventActivity;
import com.example.lenovog480.iseooalpha.R;
import com.example.lenovog480.iseooalpha.model.EventModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo G480 on 10/25/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<EventModel> acara;

    public RecyclerViewAdapter(Context context, List<EventModel> acara) {
        this.context = context;
        this.acara = acara;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_event, parent, false);
        ViewHolder holder = new ViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        EventModel event = acara.get(position);
        holder.textIdAcara.setText(event.getId_event());
        holder.textViewNamaAcara.setText(event.getNama_event());
        holder.textViewCreatorAcara.setText(event.getCreator());
        holder.textViewJenisAcara.setText(event.getJenis_event());
        holder.textViewDescAcara.setText(event.getDesk_event());
        holder.textViewTgglAcara.setText(event.getTanggal_event());
        holder.textViewStatus.setText(event.getStatus());

    }

    @Override
    public int getItemCount() {
        return acara.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.txt_idAcara)TextView textIdAcara;
        @BindView(R.id.txt_namaAcara)TextView textViewNamaAcara;
        @BindView(R.id.txt_jenisAcara)TextView textViewJenisAcara;
        @BindView(R.id.txt_creator)TextView textViewCreatorAcara;
        @BindView(R.id.txt_descAcara)TextView textViewDescAcara;
        @BindView(R.id.txt_tgglAcara)TextView textViewTgglAcara;
        @BindView(R.id.txt_status)TextView textViewStatus;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            String idEvent = textIdAcara.getText().toString();
            String namaEvent = textViewNamaAcara.getText().toString();
            String jenisEvent = textViewJenisAcara.getText().toString();
            String creator = textViewCreatorAcara.getText().toString();
            String deskripsi = textViewDescAcara.getText().toString();
            String tanggal = textViewTgglAcara.getText().toString();
            String status = textViewStatus.getText().toString();

            Intent i = new Intent(context, DetailEventActivity.class);
            i.putExtra("idEvent", idEvent);
            i.putExtra("namaEvent", namaEvent);
            i.putExtra("jenisEvent", jenisEvent);
            i.putExtra("creator", creator);
            i.putExtra("deskripsiEvent", deskripsi);
            i.putExtra("tanggalEvent", tanggal);
            i.putExtra("statusEvent", status);
            context.startActivity(i);

        }
    }
}
