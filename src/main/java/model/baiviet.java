package model;

import java.util.Date;

public class baiviet {
	int MaBaiViet;
	Date NgayDang;
	String NoiDung;
	String TrangThai;
	int MaNguoiDung;
	
	public baiviet() {
	}

	public baiviet(int maBaiViet, Date ngayDang, String noiDung, String trangThai, int maNguoiDung) {
		MaBaiViet = maBaiViet;
		NgayDang = ngayDang;
		NoiDung = noiDung;
		TrangThai = trangThai;
		MaNguoiDung = maNguoiDung;
	}

	public int getMaBaiViet() {
		return MaBaiViet;
	}

	public void setMaBaiViet(int maBaiViet) {
		MaBaiViet = maBaiViet;
	}

	public Date getNgayDang() {
		return NgayDang;
	}

	public void setNgayDang(Date ngayDang) {
		NgayDang = ngayDang;
	}

	public String getNoiDung() {
		return NoiDung;
	}

	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}

	public String getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}

	public int getMaNguoiDung() {
		return MaNguoiDung;
	}

	public void setMaNguoiDung(int maNguoiDung) {
		MaNguoiDung = maNguoiDung;
	}
	
	
}
