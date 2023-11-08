package model;

import java.util.Date;

public class BaoCaoBinhLuan {
	private int maNguoiDung;
	private int maBinhLuan;
	private Date ngayGioBaoCao;
	private String liDo;

	public BaoCaoBinhLuan() {
		// Initialize default values if needed
	}

	public BaoCaoBinhLuan(int maNguoiDung, int maBinhLuan, Date ngayGioBaoCao, String liDo) {
		this.maNguoiDung = maNguoiDung;
		this.maBinhLuan = maBinhLuan;
		this.ngayGioBaoCao = ngayGioBaoCao;
		this.liDo = liDo;
	}

	public int getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public int getMaBinhLuan() {
		return maBinhLuan;
	}

	public void setMaBinhLuan(int maBinhLuan) {
		this.maBinhLuan = maBinhLuan;
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
		return "BaoCaoBinhLuan{" + "maNguoiDung=" + maNguoiDung + ", maBinhLuan=" + maBinhLuan + ", ngayGioBaoCao="
				+ ngayGioBaoCao + ", liDo='" + liDo + '\'' + '}';
	}
}
