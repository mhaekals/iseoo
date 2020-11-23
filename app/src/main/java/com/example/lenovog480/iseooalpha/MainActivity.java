package com.example.lenovog480.iseooalpha;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.lenovog480.iseooalpha.adapter.OnMenuTabSelected;
import com.example.lenovog480.iseooalpha.adapter.SessionManager;
import com.example.lenovog480.iseooalpha.fragment.EventFragment;
import com.example.lenovog480.iseooalpha.fragment.HomeFragment;
import com.example.lenovog480.iseooalpha.fragment.LayanankuFragment;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView view;
    Toolbar toolbar;
    FragmentTransaction transaction;
    FragmentManager manager;
    SessionManager sm;
    HashMap<String,String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar_utama);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        view = (BottomNavigationView) findViewById(R.id.btm_nav);
        OnMenuTabSelected.disableShiftMode(view);



        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //sm = new SessionManager(MainActivity.this);
                //map = sm.getDetailLogin();
                //sm.checkLogin();

                switch (item.getItemId()){
                    case R.id.home_menu :
                        HomeFragment homefragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentholder, homefragment, homefragment.getClass().getSimpleName())
                                .addToBackStack(null)
                                .commit();
                        break;
                    case R.id.event_menu :
                        EventFragment eventfragment = new EventFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentholder, eventfragment, eventfragment.getClass().getSimpleName())
                                .addToBackStack(null)
                                .commit();
                        break;
                    case R.id.service_menu :
                        LayanankuFragment servicefragment = new LayanankuFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentholder, servicefragment, servicefragment.getClass().getSimpleName())
                                .addToBackStack(null)
                                .commit();
                        break;
                    case R.id.logout_menu :
                        Intent keluar = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(keluar);
                        finish();
                        break;
                }

                return true;
            }});



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }


}
