package model;

import java.util.Date;

public class TuongTacBinhLuan {
	private int maNguoiDung;
	private int maBinhLuan;
	private Date ngayGioTuongTac;
	private String trangThai;
	
	public TuongTacBinhLuan() {
		super();
	}

	public TuongTacBinhLuan(int maNguoiDung, int maBinhLuan, Date ngayGioTuongTac, String trangThai) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.maBinhLuan = maBinhLuan;
		this.ngayGioTuongTac = ngayGioTuongTac;
		this.trangThai = trangThai;
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
		return "TuongTacBinhLuan [maNguoiDung=" + maNguoiDung + ", maBinhLuan=" + maBinhLuan + ", ngayGioTuongTac="
				+ ngayGioTuongTac + ", trangThai=" + trangThai + "]";
	}
	
	
}
