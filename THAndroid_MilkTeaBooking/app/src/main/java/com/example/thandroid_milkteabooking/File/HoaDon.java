package com.example.thandroid_milkteabooking.File;

public class HoaDon {

    public HoaDon(int SDT, String ngay, int tongTien) {
        this.SDT = SDT;
        Ngay = ngay;
        TongTien = tongTien;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String ngay) {
        Ngay = ngay;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int tongTien) {
        TongTien = tongTien;
    }

    int SDT;
            String Ngay;
            int TongTien;

}
