package com.example.docbaocuoiki.fragment_profile;

public class TinOfflineModel {
     private  String tenTin;
     private String nguonTin;
     private int hinhAnh;
     private String hour;

    public TinOfflineModel() {
    }

    public TinOfflineModel(String tenTin, String nguonTin, int hinhAnh, String hour) {
        this.tenTin = tenTin;
        this.nguonTin = nguonTin;
        this.hinhAnh = hinhAnh;
        this.hour = hour;
    }

    public String getTenTin() {
        return tenTin;
    }

    public void setTenTin(String tenTin) {
        this.tenTin = tenTin;
    }

    public String getNguonTin() {
        return nguonTin;
    }

    public void setNguonTin(String nguonTin) {
        this.nguonTin = nguonTin;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
