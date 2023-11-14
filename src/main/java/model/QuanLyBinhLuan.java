package model;

import java.util.Date;

public class QuanLyBinhLuan {
    private int maQuanLy;
    private int maBinhLuan;
    private Date ngayGioCapNhat;
    private String chiTietCapNhat;

    public QuanLyBinhLuan() {
        // Initialize default values if needed
    }

    public QuanLyBinhLuan(int maQuanLy, int maBinhLuan, Date ngayGioCapNhat, String chiTietCapNhat) {
        this.maQuanLy = maQuanLy;
        this.maBinhLuan = maBinhLuan;
        this.ngayGioCapNhat = ngayGioCapNhat;
        this.chiTietCapNhat = chiTietCapNhat;
    }

    public int getMaQuanLy() {
        return maQuanLy;
    }

    public void setMaQuanLy(int maQuanLy) {
        this.maQuanLy = maQuanLy;
    }

    public int getMaBinhLuan() {
        return maBinhLuan;
    }

    public void setMaBinhLuan(int maBinhLuan) {
        this.maBinhLuan = maBinhLuan;
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
        return "QuanLyBinhLuan{" +
                "maQuanLy=" + maQuanLy +
                ", maBinhLuan=" + maBinhLuan +
                ", ngayGioCapNhat=" + ngayGioCapNhat +
                ", chiTietCapNhat='" + chiTietCapNhat + '\'' +
                '}';
    }
}
