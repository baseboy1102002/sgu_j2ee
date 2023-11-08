package model;

import java.util.Date;

public class BaiViet {
	private int MaBaiViet;
	private int MaNguoiDung;
	private Date NgayDang;
	private String NoiDung;
	private String TrangThai;
	
	public int getMaBaiViet() {
		return MaBaiViet;
	}
	public void setMaBaiViet(int maBaiViet) {
		MaBaiViet = maBaiViet;
	}
	public int getMaNguoiDung() {
		return MaNguoiDung;
	}
	public void setMaNguoiDung(int maNguoiDung) {
		MaNguoiDung = maNguoiDung;
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
	@Override
	public String toString() {
		return "BaiViet [MaBaiViet=" + MaBaiViet + ", MaNguoiDung=" + MaNguoiDung + ", NgayDang=" + NgayDang
				+ ", NoiDung=" + NoiDung + ", TrangThai=" + TrangThai + "]";
	}
	
	
}
