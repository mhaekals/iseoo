package com.example.lenovog480.iseooalpha.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovog480.iseooalpha.CreateEventActivity;
import com.example.lenovog480.iseooalpha.R;
import com.example.lenovog480.iseooalpha.ViewEventActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {

    @OnClick(R.id.create_event) void createEvent(){
        Intent intent = new Intent(getActivity(), CreateEventActivity.class);
        startActivity(intent);
    }
    @OnClick (R.id.my_event) void viewEvent(){
        Intent intent = new Intent(getActivity(), ViewEventActivity.class);
        startActivity(intent);
    }
    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}
