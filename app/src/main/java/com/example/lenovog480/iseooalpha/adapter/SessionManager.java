package com.example.lenovog480.iseooalpha.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.lenovog480.iseooalpha.LoginActivity;

import java.util.HashMap;

/**
 * Created by Lenovo G480 on 10/23/2017.
 */

public class SessionManager {
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    public final String KEY_USERNAME = "username";
    public static final String KEY_NAMA = "nama_lengkap";
    private static final String is_login = "status";
    private final String SHARE_NAME = "loginsession";
    private final int MODE_PRIVATE = 0;
    private Context contexts;

    public SessionManager (Context context){
        this.contexts = context;
        sp = contexts.getSharedPreferences(SHARE_NAME, MODE_PRIVATE);
        edit = sp.edit();
    }

    public void storeLogin(String username, String nama_lengkap){
        edit.putBoolean(is_login, true);
        edit.putString(KEY_USERNAME, username);
        edit.putString(KEY_NAMA, nama_lengkap);
        edit.commit();
    }
    public HashMap getDetailLogin(){
        HashMap<String, String>map = new HashMap<>();
        map.put(KEY_NAMA, sp.getString(KEY_NAMA, null));
        map.put(KEY_USERNAME, sp.getString(KEY_USERNAME, null));
        return map;
    }

    public void checkLogin(){
        if(!this.Login()){
            Intent login = new Intent(contexts, LoginActivity.class);
            login.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            contexts.startActivity(login);
        }
    }

    public void logout(){
        edit.clear();
        edit.commit();
    }

    public Boolean Login(){
        return sp.getBoolean(is_login, false);
    }
}
