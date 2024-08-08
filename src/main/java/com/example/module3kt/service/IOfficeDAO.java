package com.example.module3kt.service;

import com.example.module3kt.model.Office;

import java.sql.SQLException;
import java.util.List;

public interface IOfficeDAO {

    void addOffice(Office office) throws SQLException;
    List<Office> getAllOffices();
    Office FindByMaMb(String maMB);
    void deleteOffice(String maMB) throws SQLException;

}
