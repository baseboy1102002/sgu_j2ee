package model;

import java.util.Date;

public class nguoidung {
	private int MaNguoiDung;
	private String Email;
	private String HoVaTen;
	private String MaQR;
	private String HinhDaiDien;
	private String SoDienThoai;
	private Date NgaySinh;
	private String TenTaiKhoan;
	private String LoaiTaiKhoan;
	private String MaXacNhan;
	private String MatKhau;
	private String TrangThai;
	public nguoidung() {
	}
	
	public nguoidung(int maNguoiDung, String email, String hoVaTen, String maQR, String hinhDaiDien, String soDienThoai,
			Date ngaySinh, String tenTaiKhoan, String loaiTaiKhoan, String maXacNhan, String matKhau,
			String trangThai) {
		super();
		MaNguoiDung = maNguoiDung;
		Email = email;
		HoVaTen = hoVaTen;
		MaQR = maQR;
		HinhDaiDien = hinhDaiDien;
		SoDienThoai = soDienThoai;
		NgaySinh = ngaySinh;
		TenTaiKhoan = tenTaiKhoan;
		LoaiTaiKhoan = loaiTaiKhoan;
		MaXacNhan = maXacNhan;
		MatKhau = matKhau;
		TrangThai = trangThai;
	}

	public int getMaNguoiDung() {
		return MaNguoiDung;
	}
	public void setMaNguoiDung(int maNguoiDung) {
		MaNguoiDung = maNguoiDung;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getHoVaTen() {
		return HoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		HoVaTen = hoVaTen;
	}
	public String getMaQR() {
		return MaQR;
	}
	public void setMaQR(String maQR) {
		MaQR = maQR;
	}
	public String getHinhDaiDien() {
		return HinhDaiDien;
	}
	public void setHinhDaiDien(String hinhDaiDien) {
		HinhDaiDien = hinhDaiDien;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getTenTaiKhoan() {
		return TenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		TenTaiKhoan = tenTaiKhoan;
	}
	public String getLoaiTaiKhoan() {
		return LoaiTaiKhoan;
	}
	public void setLoaiTaiKhoan(String loaiTaiKhoan) {
		LoaiTaiKhoan = loaiTaiKhoan;
	}
	public String getMaXacNhan() {
		return MaXacNhan;
	}
	public void setMaXacNhan(String maXacNhan) {
		MaXacNhan = maXacNhan;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}	
}
