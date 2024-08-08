package com.example.module3kt.controller;


import com.example.module3kt.model.Office;
import com.example.module3kt.service.IOfficeDAO;
import com.example.module3kt.service.OfficeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "officeServlet", value = "/offices")
public class OfficeServlet extends HttpServlet {
    private static final IOfficeDAO officeDAO = new OfficeDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        action = action == null ? "" : action;

        switch (action) {
            case "create":
                showFormCreate(req, resp);
                break;
//            case "search":
//                searchOfficeByName(req, resp);
//                break;
            case "delete":
                showFormDelete(req, resp);
                break;
            default:
                List<Office> officeList = officeDAO.getAllOffices();
                req.setAttribute("officeList",officeList);
                RequestDispatcher dispatcher = req.getRequestDispatcher("office/list.jsp");
                dispatcher.forward(req,resp);


        }
    }

    private void showFormDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String maMB = req.getParameter("maMB");
        Office office = officeDAO.FindByMaMb(maMB); // Lấy thông tin văn phòng từ cơ sở dữ liệu

        if (office != null) {
            req.setAttribute("office", office);
            RequestDispatcher dispatcher = req.getRequestDispatcher("office/delete.jsp");
            try {
                dispatcher.forward(req, resp);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            resp.sendRedirect("offices");
        }

    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("office/create.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "create":
                creatOffice(req, resp);
                break;
            case "delete":
                deleteOffice(req,resp);
                break;
            default:
                break;


        }
    }

    private void deleteOffice(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String maMB = req.getParameter("maMB");
        try {
            officeDAO.deleteOffice(maMB);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("offices");
    }

        private void creatOffice(HttpServletRequest req, HttpServletResponse resp) {
            String maMB = req.getParameter("maMB");
            int dienTich = Integer.parseInt(req.getParameter("dienTich"));
            String trangThai = req.getParameter("trangThai");
            int tang = Integer.parseInt(req.getParameter("tang"));
            String loaiVanPhong = req.getParameter("loaiVanPhong");
            double giaChoThue = Double.parseDouble(req.getParameter("giaChoThue"));
            java.util.Date ngayBatDau = java.sql.Date.valueOf(req.getParameter("ngayBatDau"));
            java.util.Date ngayKetThuc = java.sql.Date.valueOf(req.getParameter("ngayKetThuc"));

            Office newOffice = new Office(maMB, dienTich, trangThai, tang, loaiVanPhong, giaChoThue, ngayBatDau, ngayKetThuc);
            try {
                officeDAO.addOffice(newOffice);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                resp.sendRedirect("offices");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }
}

