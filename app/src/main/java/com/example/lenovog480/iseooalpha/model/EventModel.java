package com.example.lenovog480.iseooalpha.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo G480 on 10/24/2017.
 */

public class EventModel {

     @SerializedName("nama_event") String nama_event;
     @SerializedName("jenis_event") String jenis_event;
     @SerializedName("creator") String creator;
     @SerializedName("deskripsi_event") String deskripsi_event;
     @SerializedName("tanggal") String tanggal;
     @SerializedName("status") String status;
     @SerializedName("id_event") String id_event;

    public String getId_event() {
        return id_event;
    }

    public String getNama_event() {
        return nama_event;
    }

    public String getJenis_event() {
        return jenis_event;
    }

    public String getCreator() {
        return creator;
    }

    public String getDesk_event() {
        return deskripsi_event;
    }

    public String getTanggal_event() {
        return tanggal;
    }

    public String getStatus() {
        return status;
    }
}
