package com.example.thandroid_milkteabooking.model;

public class order {
    private int hinhanh;
    private String ten,mota,soluong;

    public order(int image3, String trà_sửa_phùng_gia, String s) {
    }

    public order() {
    }

    public order(int hinhanh, String ten, String mota, String soluong) {
        this.hinhanh = hinhanh;
        this.ten = ten;
        this.mota = mota;
        this.soluong = soluong;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }
}
