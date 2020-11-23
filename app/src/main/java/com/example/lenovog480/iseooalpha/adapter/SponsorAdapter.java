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

import com.example.lenovog480.iseooalpha.DetailSponsorActivity;
import com.example.lenovog480.iseooalpha.R;
import com.example.lenovog480.iseooalpha.model.SponsorModel;

import java.util.List;

/**
 * Created by Lenovo G480 on 11/1/2017.
 */

public class SponsorAdapter extends RecyclerView.Adapter<SponsorAdapter.MyViewHolder> {
    private Context mContext;
    private List<SponsorModel> sponsorList;

    public SponsorAdapter(Context mContext, List<SponsorModel> sponsorList) {
        this.mContext = mContext;
        this.sponsorList = sponsorList;
    }

    @Override
    public SponsorAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_sponsor, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SponsorAdapter.MyViewHolder viewHolder, int i) {
        viewHolder.namaSponsor.setText(sponsorList.get(i).getNama_sponsor());
        viewHolder.kontakSponsor.setText(sponsorList.get(i).getKontak_sponsor());
        viewHolder.jenisSponsor.setText(sponsorList.get(i).getJenis_sponsor());
       // viewHolder.deskSponsor.setText(sponsorList.get(i).getDesk_sponsor());
        viewHolder.jenisEvent.setText(sponsorList.get(i).getJenis_event());
        //viewHolder.pemilik.setText(sponsorList.get(i).getPemilik());

       // Picasso.with(mContext).placeholder(R.drawable.threedots).into(viewHolder.thumbnail);

       // viewHolder.overflow.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View view) {
             //   showPopupMenu(viewHolder.overflow);
            //}
        //});
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    /*private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    /*class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }*/

    @Override
    public int getItemCount() {
        return sponsorList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView namaSponsor, kontakSponsor, jenisSponsor, deskSponsor, jenisEvent, pemilik;
        public ImageView overflow;

        public MyViewHolder(View view) {
            super(view);
            namaSponsor = (TextView) view.findViewById(R.id.namaSponsor);
            kontakSponsor = (TextView) view.findViewById(R.id.kontakSponsor);
            jenisSponsor = (TextView) view.findViewById(R.id.jenisSponsor);
            //deskSponsor = (TextView) view.findViewById(R.id.deskSponsor);
            jenisEvent = (TextView) view.findViewById(R.id.deskSponsor);
            //thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
           // overflow = (ImageView) view.findViewById(R.id.overflow);

            //item click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        SponsorModel clickedDataItem = sponsorList.get(pos);
                        Intent intent = new Intent(mContext, DetailSponsorActivity.class);
                        intent.putExtra("idSponsor", sponsorList.get(pos).getId_sponsor());
                        intent.putExtra("namaSponsor", sponsorList.get(pos).getNama_sponsor());
                        intent.putExtra("kontakSponsor", sponsorList.get(pos).getKontak_sponsor());
                        intent.putExtra("jenisSponsor", sponsorList.get(pos).getJenis_sponsor());
                        intent.putExtra("deskSponsor", sponsorList.get(pos).getDesk_sponsor());
                        intent.putExtra("jenisEvent", sponsorList.get(pos).getJenis_event());
                        intent.putExtra("pemilikSponsor", sponsorList.get(pos).getPemilik());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                        Toast.makeText(view.getContext(), "you clicked" + clickedDataItem.getNama_sponsor(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}
