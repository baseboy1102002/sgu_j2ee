package model;

import java.util.Date;

public class QuanLyBaiViet {
    private int maQuanLy;
    private int maBaiViet;
    private Date ngayGioCapNhat;
    private String chiTietCapNhat;

    public QuanLyBaiViet() {
        // Initialize default values if needed
    }

    public QuanLyBaiViet(int maQuanLy, int maBaiViet, Date ngayGioCapNhat, String chiTietCapNhat) {
        this.maQuanLy = maQuanLy;
        this.maBaiViet = maBaiViet;
        this.ngayGioCapNhat = ngayGioCapNhat;
        this.chiTietCapNhat = chiTietCapNhat;
    }

    public int getMaQuanLy() {
        return maQuanLy;
    }

    public void setMaQuanLy(int maQuanLy) {
        this.maQuanLy = maQuanLy;
    }

    public int getMaBaiViet() {
        return maBaiViet;
    }

    public void setMaBaiViet(int maBaiViet) {
        this.maBaiViet = maBaiViet;
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
        return "QuanLyBaiViet{" +
                "maQuanLy=" + maQuanLy +
                ", maBaiViet=" + maBaiViet +
                ", ngayGioCapNhat=" + ngayGioCapNhat +
                ", chiTietCapNhat='" + chiTietCapNhat + '\'' +
                '}';
    }
}
