<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Office</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="mt-5">Delete Office</h1>
    <form action="" method="post" class="mt-4">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="maMB" value="${office.maMB}">

        <div class="form-group">
            <label for="maMB">Mã Văn Phòng</label>
            <input type="text" class="form-control" id="maMB" name="maMB" value="${office.maMB}" readonly>
        </div>
        <div class="form-group">
            <label for="dienTich">Diện Tích (m²)</label>
            <input type="number" class="form-control" id="dienTich" name="dienTich" value="${office.dienTich}" readonly>
        </div>
        <div class="form-group">
            <label for="trangThai">Tình Trạng</label>
            <input type="text" class="form-control" id="trangThai" name="trangThai" value="${office.trangThai}" readonly>
        </div>
        <div class="form-group">
            <label for="tang">Tầng</label>
            <input type="number" class="form-control" id="tang" name="tang" value="${office.tang}" readonly>
        </div>
        <div class="form-group">
            <label for="loaiVanPhong">Loại Văn Phòng</label>
            <input type="text" class="form-control" id="loaiVanPhong" name="loaiVanPhong" value="${office.loaiVanPhong}" readonly>
        </div>
        <div class="form-group">
            <label for="giaChoThue">Giá Cho Thuê (VNĐ)</label>
            <input type="number" class="form-control" id="giaChoThue" name="giaChoThue" value="${office.giaChoThue}" readonly>
        </div>
        <div class="form-group">
            <label for="ngayBatDau">Ngày Bắt Đầu</label>
            <input type="date" class="form-control" id="ngayBatDau" name="ngayBatDau" value="${office.ngayBatDau}" readonly>
        </div>
        <div class="form-group">
            <label for="ngayKetThuc">Ngày Kết Thúc</label>
            <input type="date" class="form-control" id="ngayKetThuc" name="ngayKetThuc" value="${office.ngayKetThuc}" readonly>
        </div>

        <button type="submit" class="btn btn-danger">Delete</button>
        <a href="offices" class="btn btn-secondary ml-2">Cancel</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
