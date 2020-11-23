package com.example.lenovog480.iseooalpha.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lenovo G480 on 11/5/2017.
 */

public class JasaModel {
    @SerializedName("id_jasa") String id_jasa;

    public String getId_jasa() {
        return id_jasa;
    }

    @SerializedName("nama_jasa") String nama_jasa;
    @SerializedName("harga") String harga_jasa;
    @SerializedName("kontak") String kontak;
    @SerializedName("jenis_jasa") String jenis_jasa;
    @SerializedName("deskripsi") String deskripsi_jasa;
    @SerializedName("jenis_event") String jenis_event;
    @SerializedName("pemilik") String pemilik_jasa;
    @SerializedName("status") String status;

    List<JasaModel> result;

    public List<JasaModel> getResult() {
        return result;
    }

    public void setResult(List<JasaModel> result) {
        this.result = result;
    }

    public String getNama_jasa() {
        return nama_jasa;
    }

    public void setNama_jasa(String nama_jasa) {
        this.nama_jasa = nama_jasa;
    }

    public String getHarga_jasa() {
        return harga_jasa;
    }

    public void setHarga_jasa(String harga_jasa) {
        this.harga_jasa = harga_jasa;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public String getJenis_jasa() {
        return jenis_jasa;
    }

    public void setJenis_jasa(String jenis_jasa) {
        this.jenis_jasa = jenis_jasa;
    }

    public String getDeskripsi_jasa() {
        return deskripsi_jasa;
    }

    public void setDeskripsi_jasa(String deskripsi_jasa) {
        this.deskripsi_jasa = deskripsi_jasa;
    }

    public String getJenis_event() {
        return jenis_event;
    }

    public void setJenis_event(String jenis_event) {
        this.jenis_event = jenis_event;
    }

    public String getPemilik_jasa() {
        return pemilik_jasa;
    }

    public void setPemilik_jasa(String pemilik_jasa) {
        this.pemilik_jasa = pemilik_jasa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
