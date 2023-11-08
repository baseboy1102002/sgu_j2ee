package model;

import java.util.Date;

public class BaoCaoBaiviet {
	private int maNguoiDung;
	private int maBaiViet;
	private Date ngayGioBaoCao;
	private String liDo;

	public BaoCaoBaiviet() {
		// Initialize default values if needed
	}

	public BaoCaoBaiviet(int maNguoiDung, int maBaiViet, Date ngayGioBaoCao, String liDo) {
		this.maNguoiDung = maNguoiDung;
		this.maBaiViet = maBaiViet;
		this.ngayGioBaoCao = ngayGioBaoCao;
		this.liDo = liDo;
	}

	public int getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public int getMaBaiViet() {
		return maBaiViet;
	}

	public void setMaBaiViet(int maBaiViet) {
		this.maBaiViet = maBaiViet;
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
		return "BaoCaoBaiviet{" + "maNguoiDung=" + maNguoiDung + ", maBaiViet=" + maBaiViet + ", ngayGioBaoCao="
				+ ngayGioBaoCao + ", liDo='" + liDo + '\'' + '}';
	}
}
