package com.example.lenovog480.iseooalpha.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovog480.iseooalpha.JasaActivity;
import com.example.lenovog480.iseooalpha.R;
import com.example.lenovog480.iseooalpha.SponsorActivity;
import com.example.lenovog480.iseooalpha.ViewOrderActivity;
import com.example.lenovog480.iseooalpha.ViewRequestActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LayanankuFragment extends Fragment {

    @OnClick(R.id.layananku_jasa) void PindahJasa(){
        Intent intent = new Intent(getActivity(), JasaActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.layananku_sponsor) void PindahSponsor(){
        Intent intent = new Intent(getActivity(), SponsorActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.order)void lihatorder(){
        Intent intent = new Intent(getActivity(), ViewOrderActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.request)void pindahrequest(){
        Intent intent = new Intent(getActivity(), ViewRequestActivity.class);
        startActivity(intent);
    }

    public LayanankuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layananku, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}