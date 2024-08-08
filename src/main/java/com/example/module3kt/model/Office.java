package com.example.module3kt.model;

import java.util.Date;

public class Office {
    private String maMB;
    private int dienTich;
    private String trangThai;
    private int tang;
    private String loaiVanPhong;
    private double giaChoThue;
    private Date ngayBatDau;
    private Date ngayKetThuc;


    public Office(String maMB, int dienTich, String trangThai, int tang, String loaiVanPhong, double giaChoThue, Date ngayBatDau, Date ngayKetThuc) {
        this.maMB = maMB;
        this.dienTich = dienTich;
        this.trangThai = trangThai;
        this.tang = tang;
        this.loaiVanPhong = loaiVanPhong;
        this.giaChoThue = giaChoThue;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    // Getters and Setters
    public String getMaMB() {
        return maMB;
    }

    public void setMaMB(String maMB) {
        this.maMB = maMB;
    }

    public int getDienTich() {
        return dienTich;
    }

    public void setDienTich(int dienTich) {
        this.dienTich = dienTich;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public String getLoaiVanPhong() {
        return loaiVanPhong;
    }

    public void setLoaiVanPhong(String loaiVanPhong) {
        this.loaiVanPhong = loaiVanPhong;
    }

    public double getGiaChoThue() {
        return giaChoThue;
    }

    public void setGiaChoThue(double giaChoThue) {
        this.giaChoThue = giaChoThue;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @Override
    public String toString() {
        return "Office{" +
                "maMB='" + maMB + '\'' +
                ", dienTich=" + dienTich +
                ", trangThai='" + trangThai + '\'' +
                ", tang=" + tang +
                ", loaiVanPhong='" + loaiVanPhong + '\'' +
                ", giaChoThue=" + giaChoThue +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                '}';
    }
}