package model;

import java.util.Date;

public class QuanLyNguoiDung {
    private int maQuanLy;
    private int maNguoiDung;
    private Date ngayGioCapNhat;
    private String chiTietCapNhat;

    public QuanLyNguoiDung() {
        // Initialize default values if needed
    }

    public QuanLyNguoiDung(int maQuanLy, int maNguoiDung, Date ngayGioCapNhat, String chiTietCapNhat) {
        this.maQuanLy = maQuanLy;
        this.maNguoiDung = maNguoiDung;
        this.ngayGioCapNhat = ngayGioCapNhat;
        this.chiTietCapNhat = chiTietCapNhat;
    }

    public int getMaQuanLy() {
        return maQuanLy;
    }

    public void setMaQuanLy(int maQuanLy) {
        this.maQuanLy = maQuanLy;
    }

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public Date getNgayGioCapNhat() {
        return ngayGioCapNhat;
    }

    public void setNgayGioCapNhat(Date ngayGioCapNhat) {
        this.ngayGioCapNhat = ngayGioCapNhat;
    }

    public String getChiTietCapNhat() {
        return chiTietCapNhat;
    }

    public void setChiTietCapNhat(String chiTietCapNhat) {
        this.chiTietCapNhat = chiTietCapNhat;
    }

    @Override
    public String toString() {
        return "QuanLyNguoiDung{" +
                "maQuanLy=" + maQuanLy +
                ", maNguoiDung=" + maNguoiDung +
                ", ngayGioCapNhat=" + ngayGioCapNhat +
                ", chiTietCapNhat='" + chiTietCapNhat + '\'' +
                '}';
    }
}
