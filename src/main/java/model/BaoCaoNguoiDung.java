package model;

import java.util.Date;

public class BaoCaoNguoiDung {
    private int maNguoiDungBaoCao;
    private int maNguoiDungBiBaoCao;
    private Date ngayGioBaoCao;
    private String liDo;

    public BaoCaoNguoiDung() {
        // Initialize default values if needed
    }

    public BaoCaoNguoiDung(int maNguoiDungBaoCao, int maNguoiDungBiBaoCao, Date ngayGioBaoCao, String liDo) {
        this.maNguoiDungBaoCao = maNguoiDungBaoCao;
        this.maNguoiDungBiBaoCao = maNguoiDungBiBaoCao;
        this.ngayGioBaoCao = ngayGioBaoCao;
        this.liDo = liDo;
    }

    public int getMaNguoiDungBaoCao() {
        return maNguoiDungBaoCao;
    }

    public void setMaNguoiDungBaoCao(int maNguoiDungBaoCao) {
        this.maNguoiDungBaoCao = maNguoiDungBaoCao;
    }

    public int getMaNguoiDungBiBaoCao() {
        return maNguoiDungBiBaoCao;
    }

    public void setMaNguoiDungBiBaoCao(int maNguoiDungBiBaoCao) {
        this.maNguoiDungBiBaoCao = maNguoiDungBiBaoCao;
    }

    public Date getNgayGioBaoCao() {
        return ngayGioBaoCao;
    }

    public void setNgayGioBaoCao(Date ngayGioBaoCao) {
        this.ngayGioBaoCao = ngayGioBaoCao;
    }

    public String getLiDo() {
        return liDo;
    }

    public void setLiDo(String liDo) {
        this.liDo = liDo;
    }

    @Override
    public String toString() {
        return "BaoCaoNguoiDung{" +
                "maNguoiDungBaoCao=" + maNguoiDungBaoCao +
                ", maNguoiDungBiBaoCao=" + maNguoiDungBiBaoCao +
                ", ngayGioBaoCao=" + ngayGioBaoCao +
                ", liDo='" + liDo + '\'' +
                '}';
    }
}
