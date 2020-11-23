package com.example.lenovog480.iseooalpha.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lenovo G480 on 10/31/2017.
 */

public class SponsorModel {

    @SerializedName("id_sponsor")String id_sponsor;

    public String getId_sponsor() {
        return id_sponsor;
    }

    @SerializedName("nama_sponsor")String nama_sponsor;
    @SerializedName("kontak")String kontak_sponsor;
    @SerializedName("jenis_sponsor")String jenis_sponsor;
    @SerializedName("deskipsi")String desk_sponsor;
    @SerializedName("untuk_event")String untuk_event;
    @SerializedName("pemilik")String pemilik;
    @SerializedName("status")String status;
    @SerializedName("jenis_event")String jenis_event;

    List<SponsorModel> result;

    public List<SponsorModel> getResult() {
        return result;
    }

    public String getNama_sponsor() {
        return nama_sponsor;
    }

    public void setNama_sponsor(String nama_sponsor) {
        this.nama_sponsor = nama_sponsor;
    }

    public String getKontak_sponsor() {
        return kontak_sponsor;
    }

    public void setKontak_sponsor(String kontak_sponsor) {
        this.kontak_sponsor = kontak_sponsor;
    }

    public String getJenis_sponsor() {
        return jenis_sponsor;
    }

    public void setJenis_sponsor(String jenis_sponsor) {
        this.jenis_sponsor = jenis_sponsor;
    }

    public String getDesk_sponsor() {
        return desk_sponsor;
    }

    public void setDesk_sponsor(String desk_sponsor) {
        this.desk_sponsor = desk_sponsor;
    }

    public String getUntuk_event() {
        return untuk_event;
    }

    public void setUntuk_event(String untuk_event) {
        this.untuk_event = untuk_event;
    }

    public String getPemilik() {
        return pemilik;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJenis_event() {
        return jenis_event;
    }

    public void setJenis_event(String jenis_event) {
        this.pemilik = jenis_event;
    }
}
