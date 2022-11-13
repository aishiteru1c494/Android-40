package com.triplek.QuanLyPhongNet.Food.model;

public class Food {
    String TenMon,Gia,ImageUrl;

    public Food() {
    }

    public Food(String tenMon, String gia, String imageUrl) {
        TenMon = tenMon;
        Gia = gia;
        ImageUrl = imageUrl;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String tenMon) {
        TenMon = tenMon;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }
}
