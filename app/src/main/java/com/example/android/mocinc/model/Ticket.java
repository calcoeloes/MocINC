package com.example.android.mocinc.model;

/**
 * Created by Khalil Qibran on 5/4/2017.
 */

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    @SerializedName("id") private String id ;
    @SerializedName("nama") private String nama ;
    @SerializedName("waktu") private String waktu ;
    @SerializedName("lokasi") private String lokasi ;
    @SerializedName("lat") private String lat ;
    @SerializedName("lang") private String lang ;
    @SerializedName("harga") private String harga ;
    public Ticket(String id,String nama,String waktu,String lokasi,String lat,String lang,String harga){
        this.id = id;
        this.nama = nama;
        this.waktu = waktu;
        this.lokasi = lokasi;
        this.lat = lat;
        this.lang = lang;
        this.harga = harga;    }
    public void setId() { this.id = id; }
    public void setNama() { this.nama = nama; }
    public void setWaktu() { this.waktu = waktu; }
    public void setLokasi() { this.lokasi = lokasi; }
    public void setLat() { this.lat = lat; }
    public void setLang() { this.lang = lang; }
    public void setHarga() { this.harga = harga; }
    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getWaktu() { return waktu; }
    public String getLokasi() { return lokasi; }
    public String getLat() { return lat; }
    public String getLang() { return lang; }
    public String getHarga() { return harga; }
}

