package com.example.lenovog480.iseooalpha.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lenovo G480 on 12/18/2017.
 */

public class RequestModel {
    @SerializedName("id_request")String id_request;
    @SerializedName("id_sponsor")String id_sponsor;
    @SerializedName("id_event")String id_event;
    @SerializedName("tanggal_request")String tanggal_request;
    @SerializedName("lama_event")String lama_event;
    @SerializedName("tanggal_mulai")String tanggal_mulai;
    @SerializedName("status")String status;
    @SerializedName("nama_event")String nama_event;
    @SerializedName("jenis_event")String jenis_event;
    @SerializedName("creator")String creator;
    @SerializedName("nama_sponsor")String nama_sponsor;
    @SerializedName("jenis_sponsor")String jenis_sponsor;
    @SerializedName("kontak")String kontak;

    List<RequestModel> result;

    public String getId_request() {
        return id_request;
    }

    public void setId_request(String id_request) {
        this.id_request = id_request;
    }

    public String getId_sponsor() {
        return id_sponsor;
    }

    public void setId_sponsor(String id_sponsor) {
        this.id_sponsor = id_sponsor;
    }

    public String getId_event() {
        return id_event;
    }

    public void setId_event(String id_event) {
        this.id_event = id_event;
    }

    public String getTanggal_request() {
        return tanggal_request;
    }

    public void setTanggal_request(String tanggal_request) {
        this.tanggal_request = tanggal_request;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNama_event() {
        return nama_event;
    }

    public void setNama_event(String nama_event) {
        this.nama_event = nama_event;
    }

    public String getJenis_event() {
        return jenis_event;
    }

    public void setJenis_event(String jenis_event) {
        this.jenis_event = jenis_event;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getNama_sponsor() {
        return nama_sponsor;
    }

    public void setNama_sponsor(String nama_sponsor) {
        this.nama_sponsor = nama_sponsor;
    }

    public String getJenis_sponsor() {
        return jenis_sponsor;
    }

    public void setJenis_sponsor(String jenis_sponsor) {
        this.jenis_sponsor = jenis_sponsor;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public List<RequestModel> getResult() {
        return result;
    }

    public void setResult(List<RequestModel> result) {
        this.result = result;
    }
}
