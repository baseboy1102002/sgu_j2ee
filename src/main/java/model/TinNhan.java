package model;

import java.util.Date;

public class TinNhan {
    private int maTinNhan;
    private int maNguoiGui;
    private int maNguoiNhan;
    private String noiDung;
    private Date ngayGioGui;
    private String trangThai;

    public TinNhan() {
        // Initialize default values if needed
    }

    public TinNhan(int maTinNhan, int maNguoiGui, int maNguoiNhan, String noiDung, Date ngayGioGui, String trangThai) {
        this.maTinNhan = maTinNhan;
        this.maNguoiGui = maNguoiGui;
        this.maNguoiNhan = maNguoiNhan;
        this.noiDung = noiDung;
        this.ngayGioGui = ngayGioGui;
        this.trangThai = trangThai;
    }

    public int getMaTinNhan() {
        return maTinNhan;
    }

    public void setMaTinNhan(int maTinNhan) {
        this.maTinNhan = maTinNhan;
    }

    public int getMaNguoiGui() {
        return maNguoiGui;
    }

    public void setMaNguoiGui(int maNguoiGui) {
        this.maNguoiGui = maNguoiGui;
    }

    public int getMaNguoiNhan() {
        return maNguoiNhan;
    }

    public void setMaNguoiNhan(int maNguoiNhan) {
        this.maNguoiNhan = maNguoiNhan;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getNgayGioGui() {
        return ngayGioGui;
    }

    public void setNgayGioGui(Date ngayGioGui) {
        this.ngayGioGui = ngayGioGui;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "TinNhan{" +
                "maTinNhan=" + maTinNhan +
                ", maNguoiGui=" + maNguoiGui +
                ", maNguoiNhan=" + maNguoiNhan +
                ", noiDung='" + noiDung + '\'' +
                ", ngayGioGui=" + ngayGioGui +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
