/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author XPS
 */
public class KhuyenMai {
    private String maKH;
    private String masp;
    private String tenKm;
    private String ngayBdau;
    private String ngayKthuc;
    private String loaiSp;
    private float giamgia;
    private String trangThai;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKH, String masp, String tenKm, String ngayBdau, String ngayKthuc, String loaiSp, float giamgia, String trangThai) {
        this.maKH = maKH;
        this.masp = masp;
        this.tenKm = tenKm;
        this.ngayBdau = ngayBdau;
        this.ngayKthuc = ngayKthuc;
        this.loaiSp = loaiSp;
        this.giamgia = giamgia;
        this.trangThai = trangThai;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTenKm() {
        return tenKm;
    }

    public void setTenKm(String tenKm) {
        this.tenKm = tenKm;
    }

    public String getNgayBdau() {
        return ngayBdau;
    }

    public void setNgayBdau(String ngayBdau) {
        this.ngayBdau = ngayBdau;
    }

    public String getNgayKthuc() {
        return ngayKthuc;
    }

    public void setNgayKthuc(String ngayKthuc) {
        this.ngayKthuc = ngayKthuc;
    }

    public String getLoaiSp() {
        return loaiSp;
    }

    public void setLoaiSp(String loaiSp) {
        this.loaiSp = loaiSp;
    }

    public float getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(float giamgia) {
        this.giamgia = giamgia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
