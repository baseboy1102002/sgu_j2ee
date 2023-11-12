package model;

import java.util.Date;

public class TuongTacBaiViet {
	private int maNguoiDung;
	private int maBaiViet;
	private Date ngayGioTuongTac;
	private String trangThai;


	public TuongTacBaiViet() {
		super();
	}


	public TuongTacBaiViet(int maNguoiDung, int maBaiViet, Date ngayGioTuongTac, String trangThai) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.maBaiViet = maBaiViet;
		this.ngayGioTuongTac = ngayGioTuongTac;
		this.trangThai = trangThai;
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


	public Date getNgayGioTuongTac() {
		return ngayGioTuongTac;
	}


	public void setNgayGioTuongTac(Date ngayGioTuongTac) {
		this.ngayGioTuongTac = ngayGioTuongTac;
	}


	public String getTrangThai() {
		return trangThai;
	}


	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}


	@Override
	public String toString() {
		return "TuongTacBaiViet [maNguoiDung=" + maNguoiDung + ", maBaiViet=" + maBaiViet + ", ngayGioTuongTac="
				+ ngayGioTuongTac + ", trangThai=" + trangThai + "]";
	}


}
