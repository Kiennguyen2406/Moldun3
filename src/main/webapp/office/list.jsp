<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Office List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Office List</h2>
    <a href="offices?action=create" class="btn btn-primary">Add New Office</a>
    <table class="table table-striped mt-3">
        <thead>
        <tr>

            <th>Office Code</th>
            <th>Area</th>
            <th>Status</th>
            <th>Floor</th>
            <th>Office Type</th>
            <th>Rental Price</th>
            <th>Start Date</th>
            <th>End Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="office" items="${officeList}">
            <tr>

                <td>${office.maMB}</td>
                <td>${office.dienTich}</td>
                <td>${office.trangThai}</td>
                <td>${office.tang}</td>
                <td>${office.loaiVanPhong}</td>
                <td>${office.giaChoThue}</td>
                <td>${office.ngayBatDau}</td>
                <td>${office.ngayKetThuc}</td>
                <td>
                    <a href="offices?action=delete&maMB=${office.maMB}" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
