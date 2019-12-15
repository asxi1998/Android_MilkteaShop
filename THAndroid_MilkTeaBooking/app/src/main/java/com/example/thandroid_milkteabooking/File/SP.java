package com.example.thandroid_milkteabooking.File;

public class SP {
    String Name;
    byte[] anh;
    int gia;

    public SP(String name, byte[] anh, int gia) {
        Name = name;
        this.anh = anh;
        this.gia = gia;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public byte[] getAnh() {
        return anh;
    }

    public void setAnh(byte[] anh) {
        this.anh = anh;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
