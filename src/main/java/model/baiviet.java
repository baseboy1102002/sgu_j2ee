package model;

import java.sql.Timestamp;
import java.util.Date;


public class baiviet {
	int maBaiViet;
	Timestamp ngayDang;
	String noiDung;
	String trangThai;
	int maNguoiDung;
	
	public baiviet() {
		super();
	}
	public baiviet(int maBaiViet, Timestamp ngayDang, String noiDung, String trangThai, int maNguoiDung) {
		super();
		this.maBaiViet = maBaiViet;
		this.ngayDang = ngayDang;
		this.noiDung = noiDung;
		this.trangThai = trangThai;
		this.maNguoiDung = maNguoiDung;
	}
	public int getMaBaiViet() {
		return maBaiViet;
	}
	public void setMaBaiViet(int maBaiViet) {
		this.maBaiViet = maBaiViet;
	}
	public Timestamp getNgayDang() {
		return ngayDang;
	}
	public void setNgayDang(Timestamp ngayDang) {
		this.ngayDang = ngayDang;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public int getMaNguoiDung() {
		return maNguoiDung;
	}
	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

}
	