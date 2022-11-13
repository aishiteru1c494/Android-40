package com.triplek.QuanLyPhongNet.Game.model;

public class Game {
    String TenGame,TheLoai,ImageUrl;

    public Game() {
    }

    public Game(String tenGame, String theLoai, String imageUrl) {
        TenGame = tenGame;
        TheLoai = theLoai;
        ImageUrl = imageUrl;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getTenGame() {
        return TenGame;
    }

    public void setTenGame(String tenGame) {
        TenGame = tenGame;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String theLoai) {
        TheLoai = theLoai;
    }
}
