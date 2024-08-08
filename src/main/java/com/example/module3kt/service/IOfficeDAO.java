package com.example.module3kt.service;

import com.example.module3kt.model.Office;

import java.sql.SQLException;
import java.util.List;

public interface IOfficeService {

    void addOffice(Office office) throws SQLException;
    List<Office> getAllOffices();
}
