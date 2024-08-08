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

public class OfficeDAO implements IOfficeDAO {

    @Override
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

    @Override
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

    @Override
    public Office FindByMaMb(String maMB) {


        Office office = null;
        String sql = "SELECT * FROM Offices WHERE MaMB = ?";
        try (Connection connection = DatabaseConnect.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, maMB);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                office = new Office(
                        resultSet.getString("MaMB"),
                        resultSet.getInt("DienTich"),
                        resultSet.getString("TrangThai"),
                        resultSet.getInt("Tang"),
                        resultSet.getString("LoaiVanPhong"),
                        resultSet.getDouble("GiaChoThue"),
                        resultSet.getDate("NgayBatDau"),
                        resultSet.getDate("NgayKetThuc")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return office;
    }

    @Override
    public void deleteOffice(String maMB) throws SQLException {
        String sql = "DELETE FROM Offices WHERE MaMB = ?";
        try (Connection connection = DatabaseConnect.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, maMB);
            preparedStatement.executeUpdate();
        }

    }
}
