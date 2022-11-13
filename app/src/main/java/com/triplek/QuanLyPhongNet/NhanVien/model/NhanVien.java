package com.triplek.QuanLyPhongNet.NhanVien.model;

import com.triplek.QuanLyPhongNet.NhanVien.adapter.NhanVienApdater;

public class NhanVien {
    String Ho,Ten,Tuoi,MaNV;

    public NhanVien() {
    }

    public NhanVien(String ho, String ten, String tuoi,String maNV) {
        Ho = ho;
        Ten = ten;
        Tuoi = tuoi;
        MaNV=maNV;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String ho) {
        Ho = ho;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getTuoi() {
        return Tuoi;
    }

    public void setTuoi(String tuoi) {
        Tuoi = tuoi;
    }
}
