package com.example.thandroid_milkteabooking.File;

public class ChiTietHoaDon {
    public ChiTietHoaDon(int maHoaDon, int SP, int SL, int thanhTien) {
        MaHoaDon = maHoaDon;
        this.SP = SP;
        this.SL = SL;
        ThanhTien = thanhTien;
    }

    int MaHoaDon,SP,SL,ThanhTien;

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        MaHoaDon = maHoaDon;
    }

    public int getSP() {
        return SP;
    }

    public void setSP(int SP) {
        this.SP = SP;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int thanhTien) {
        ThanhTien = thanhTien;
    }
}
