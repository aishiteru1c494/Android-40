package com.triplek.QuanLyPhongNet.PC.model;

import java.io.Serializable;

public class MayTinh implements Serializable {
    private String _maPC;
    private int _LinkAnh;

    public MayTinh() {
    }

    public MayTinh(String _maPC, int _LinkAnh) {
        this._maPC = _maPC;
        this._LinkAnh = _LinkAnh;
    }

    public String get_maPC() {
        return _maPC;
    }

    public void set_maPC(String _maPC) {
        this._maPC = _maPC;
    }

    public int get_LinkAnh() {
        return _LinkAnh;
    }

    public void set_LinkAnh(int _LinkAnh) {
        this._LinkAnh = _LinkAnh;
    }
}
