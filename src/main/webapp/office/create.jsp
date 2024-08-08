<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Office</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="mt-5">Create New Office</h1>
    <form method="post" class="mt-4" action="">
        <div class="form-group">
            <label for="maMB">Mã Văn Phòng</label>
            <input type="text" class="form-control" id="maMB" name="maMB" required>
        </div>
        <div class="form-group">
            <label for="dienTich">Diện Tích (m²)</label>
            <input type="number" class="form-control" id="dienTich" name="dienTich" min="1" required>
        </div>
        <div class="form-group">
            <label for="trangThai">Tình Trạng</label>
            <select class="form-control" id="trangThai" name="trangThai" required>
                <option value="Trống">Trống</option>
                <option value="Hạ tầng">Hạ tầng</option>
                <option value="Đầy đủ">Đầy đủ</option>
            </select>
        </div>
        <div class="form-group">
            <label for="tang">Tầng</label>
            <input type="number" class="form-control" id="tang" name="tang" min="1" max="15" required>
        </div>
        <div class="form-group">
            <label for="loaiVanPhong">Loại Văn Phòng</label>
            <select class="form-control" id="loaiVanPhong" name="loaiVanPhong" required>
                <option value="Trọn gói">Trọn gói</option>
                <option value="Chia sẻ">Chia sẻ</option>
            </select>
        </div>
        <div class="form-group">
            <label for="giaChoThue">Giá Cho Thuê (VNĐ)</label>
            <input type="number" class="form-control" id="giaChoThue" name="giaChoThue" min="1000000" step="0.01" required>
        </div>
        <div class="form-group">
            <label for="ngayBatDau">Ngày Bắt Đầu</label>
            <input type="date" class="form-control" id="ngayBatDau" name="ngayBatDau" required>
        </div>
        <div class="form-group">
            <label for="ngayKetThuc">Ngày Kết Thúc</label>
            <input type="date" class="form-control" id="ngayKetThuc" name="ngayKetThuc" required>
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
        <a href="offices" class="btn btn-secondary ml-2">Cancel</a>
    </form>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
