/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.SanPham;
import Service.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author XPS
 */
public class SanPhamDAO {
    public int themSP(SanPham sp) {
        String sql = "INSERT INTO SanPham (MaSP, TenSP, LoaiSP, Gia, SoLuong, MauSac, KichThuoc, ChatLieu, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, sp.getMasp());
            pstm.setString(2, sp.getTensp());
            pstm.setString(3, sp.getLoaisp());
            pstm.setFloat(4, sp.getGia());
            pstm.setInt(5, sp.getSluong());
            pstm.setString(6, sp.getMausac());
            pstm.setString(7, sp.getKichThuoc());
            pstm.setString(8, sp.getChatLieu());
            pstm.setString(9, sp.getTrangThai());
            if (pstm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception ex) {
        }
        return 0;
    }

    // Trong SanPhamDAO.java
    public int suaSP(SanPham sp, String Masp) {
        String sql = "update SanPham set\n"
                + "MaSP = ?,\n"
                + "TenSP = ?,\n"
                + "LoaiSP = ?,\n"
                + "Gia = ?\n" 
                + "SoLuong = ?"
                + "MauSac = ?,\n"
                + "KichThuoc = ?,\n"
                + "ChatLieu = ?,\n"
                + "TrangThai = ?\n" 
                + "WHERE MaSP = ?";   

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, sp.getMasp());
            pstm.setString(2, sp.getTensp());
            pstm.setString(3, sp.getLoaisp());
            pstm.setFloat(4, sp.getGia());
            pstm.setInt(5, sp.getSluong());
            pstm.setString(6, sp.getMausac());
            pstm.setString(7, sp.getKichThuoc());
            pstm.setString(8, sp.getChatLieu());
            pstm.setString(9, sp.getTrangThai());
            if (pstm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception ex) {
            ex.printStackTrace(); // Nên in ra lỗi để debug
        }
        return 0;
    }

    public int xoaSP(int Masp) {
        String sql = "delete SanPham where MaSP = ?";

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, Masp);
            if (pstm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception ex) {
        }
        return 0;
    }

    public Object[] getRow(SanPham sp) {
        String MaSP = sp.getMasp();
        String tenSP = sp.getTensp();
        String LoaiSP = sp.getLoaisp();
        float Gia = sp.getGia();
        int SoLuong = sp.getSluong();
        String MauSac = sp.getMausac();
        String KichThuoc = sp.getKichThuoc();
        String ChatLieu = sp.getChatLieu();
        String trangThai = sp.getTrangThai();

        Object[] row = new Object[]{MaSP, tenSP, LoaiSP, Gia, SoLuong, MauSac, KichThuoc, ChatLieu, trangThai};
        return row;
    }

    public List<SanPham> getAll() {
        List<SanPham> listsp = new ArrayList<>();
        String sql = "SELECT * FROM SanPham";
        try {
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String MaSP = rs.getString(1);
                String tenSP = rs.getString(2);
                String LoaiSP = rs.getString(3);
                float Gia = rs.getFloat(4);
                int SoLuong = rs.getInt(5);
                String MauSac = rs.getString(6);
                String KichThuoc = rs.getString(7);
                String ChatLieu = rs.getString(8);
                String trangThai = rs.getString(9);
                SanPham sp = new SanPham(MaSP, tenSP, LoaiSP, Gia, SoLuong, MauSac, KichThuoc, ChatLieu, trangThai);
                listsp.add(sp);
            }
        } catch (Exception ex) {
        }

        return listsp;
    }
}
