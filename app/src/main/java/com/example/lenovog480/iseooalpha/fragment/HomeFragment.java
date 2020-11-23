package com.example.lenovog480.iseooalpha.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovog480.iseooalpha.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    @OnClick(R.id.sponsor_logo) void logoSponsor(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        EventFragment llf = new EventFragment();
        ft.replace(R.id.fragmentholder, llf);
        ft.commit();
    }
    @OnClick (R.id.jasa_logo) void logoJasa(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        EventFragment llf = new EventFragment();
        ft.replace(R.id.fragmentholder, llf);
        ft.commit();
    }


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}