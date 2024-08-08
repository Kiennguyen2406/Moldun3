package com.example.module3kt.service;

import com.example.module3kt.dbConnect.DatabaseConnect;
import com.example.module3kt.model.Office;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfficeService {


    public void addOffice(Office office) throws SQLException {
        String sql = "INSERT INTO Offices (MaMB, DienTich, TrangThai, Tang, LoaiVanPhong, GiaChoThue, NgayBatDau, NgayKetThuc) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnect.getCon();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, office.getMaMB());
            pstmt.setInt(2, office.getDienTich());
            pstmt.setString(3, office.getTrangThai());
            pstmt.setInt(4, office.getTang());
            pstmt.setString(5, office.getLoaiVanPhong());
            pstmt.setDouble(6, office.getGiaChoThue());
            pstmt.setDate(7, new java.sql.Date(office.getNgayBatDau().getTime()));
            pstmt.setDate(8, new java.sql.Date(office.getNgayKetThuc().getTime()));

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Office> getAllOffices() {
        List<Office> offices = new ArrayList<>();
        String sql = "SELECT * FROM Offices";

        try (Connection conn = DatabaseConnect.getCon();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String maMB = rs.getString("MaMB");
                int dienTich = rs.getInt("DienTich");
                String trangThai = rs.getString("TrangThai");
                int tang = rs.getInt("Tang");
                String loaiVanPhong = rs.getString("LoaiVanPhong");
                double giaChoThue = rs.getDouble("GiaChoThue");
                Date ngayBatDau = rs.getDate("NgayBatDau");
                Date ngayKetThuc = rs.getDate("NgayKetThuc");

                Office office = new Office(maMB, dienTich, trangThai, tang, loaiVanPhong, giaChoThue, ngayBatDau, ngayKetThuc);
                offices.add(office);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return offices;
    }
}
