/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.KhuyenMai;
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
public class KhuyenMaiDAO {

    public int capNhatKhuyenMai(KhuyenMai km) {
        String sql = "UPDATE KhuyenMai SET TenKM = ?, NgayBdau = ?, NgayKthuc = ?, LoaiSP = ?, GiamGia = ?, TrangThai = ? WHERE MaKM = ?";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, km.getTenKm());
            pstm.setString(2, km.getNgayBdau());
            pstm.setString(3, km.getNgayKthuc());
            pstm.setString(4, km.getLoaiSp());
            pstm.setFloat(5, km.getGiamgia());
            pstm.setString(6, km.getTrangThai());
            pstm.setString(7, km.getMaKM()); // WHERE MaKM

            return pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); // In lỗi ra console
        }
        return 0;
    }

    public int luuKhuyenMai(KhuyenMai km) {
        String sql = "INSERT INTO KhuyenMai (MaKM, MaSP, TenKM, NgayBdau, NgayKthuc, LoaiSP, GiamGia, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, km.getMaKM());
            ps.setString(2, km.getMasp()); // Cái này rất quan trọng
            ps.setString(3, km.getTenKm());
            ps.setString(4, km.getNgayBdau());
            ps.setString(5, km.getNgayKthuc());
            ps.setString(6, km.getLoaiSp());
            ps.setFloat(7, km.getGiamgia());
            ps.setString(8, km.getTrangThai());

            if (ps.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int xoaKhuyenMai(String maKM) {
        String sql = "DELETE FROM KhuyenMai WHERE MaKM = ?";

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, maKM);

            if (pstm.executeUpdate() > 0) {
                return 1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    public List<KhuyenMai> getAllKM() {
        List<KhuyenMai> listKM = new ArrayList<>();
        String sql = "SELECT * FROM KhuyenMai";

        try {
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                String maKM = rs.getString(1);
                String masp = rs.getString(2);
                String tenKm = rs.getString(3);
                String ngayBdau = rs.getString(4);
                String ngayKthuc = rs.getString(5);
                String loaiSp = rs.getString(6);
                float giamgia = rs.getFloat(7);
                String trangThai = rs.getString(8);

                KhuyenMai km = new KhuyenMai(maKM, masp, tenKm, ngayBdau, ngayKthuc, loaiSp, giamgia, trangThai);
                listKM.add(km);
            }
        } catch (Exception ex) {
            ex.printStackTrace(); // in lỗi để dễ debug
        }

        return listKM;
    }

    public Object[] getRowKM(KhuyenMai km) {
        String maKM = km.getMaKM();
        String masp = km.getMasp();
        String tenKm = km.getTenKm();
        String ngayBdau = km.getNgayBdau();
        String ngayKthuc = km.getNgayKthuc();
        String loaiSp = km.getLoaiSp();
        float giamgia = km.getGiamgia();
        String trangThai = km.getTrangThai();

        Object[] row = new Object[]{maKM, masp, tenKm, ngayBdau, ngayKthuc, loaiSp, giamgia, trangThai};
        return row;
    }

}
