package com.example.lenovog480.iseooalpha.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lenovo G480 on 12/18/2017.
 */

public class OrderModel {
    @SerializedName("id_order")String id_order;
    @SerializedName("id_event")String id_event;
    @SerializedName("id_jasa")String id_jasa;
    @SerializedName("tanggal_order")String tanggal_order;
    @SerializedName("lama_event")String lama_event;
    @SerializedName("tanggal_mulai")String tanggal_mulai;
    @SerializedName("harga")String harga;
    @SerializedName("pemilik")String pemilik;
    @SerializedName("nama_jasa")String nama_jasa;
    @SerializedName("creator")String creator;
    @SerializedName("nama_event")String nama_event;
    @SerializedName("status")String status;
    List<OrderModel> result;
    //String value;
   // public String getValue(){return value;}
    //String status;
    //public String getStat(){return status;}



    public String getId_order() {
        return id_order;
    }

    public void setId_order(String id_order) {
        this.id_order = id_order;
    }

    public String getId_event() {
        return id_event;
    }

    public void setId_event(String id_event) {
        this.id_event = id_event;
    }

    public String getId_jasa() {
        return id_jasa;
    }

    public void setId_jasa(String id_jasa) {
        this.id_jasa = id_jasa;
    }

    public String getTanggal_order() {
        return tanggal_order;
    }

    public void setTanggal_order(String tanggal_order) {
        this.tanggal_order = tanggal_order;
    }

    public String getLama_event() {
        return lama_event;
    }

    public void setLama_event(String lama_event) {
        this.lama_event = lama_event;
    }

    public String getTanggal_mulai() {
        return tanggal_mulai;
    }

    public void setTanggal_mulai(String tanggal_mulai) {
        this.tanggal_mulai = tanggal_mulai;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getPemilik() {
        return pemilik;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }

    public String getNama_jasa() {
        return nama_jasa;
    }

    public void setNama_jasa(String nama_jasa) {
        this.nama_jasa = nama_jasa;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getNama_event() {
        return nama_event;
    }

    public void setNama_event(String nama_event) {
        this.nama_event = nama_event;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderModel> getResult() {
        return result;
    }

    public void setResult(List<OrderModel> result) {
        this.result = result;
    }
}
