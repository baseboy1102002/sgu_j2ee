package model;

import java.util.Date;

public class NguoiDung {
	private int maNguoiDung;
	private String email;
	private String hoVaTen;
	private String maQR;
	private String hinhDaiDien;
	private String soDienThoai;
	private Date ngaySinh;
	private String loaiTaiKhoan;
	private String maXacNhan;
	private String matKhau;
	private String trangThai;

	public NguoiDung() {
		super();
	}

	public NguoiDung(int maNguoiDung, String hoVaTen, String hinhDaiDien) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.hoVaTen = hoVaTen;
		this.hinhDaiDien = hinhDaiDien;
	}

	public NguoiDung(int maNguoiDung, String email, String hoVaTen, String maQR, String hinhDaiDien, String soDienThoai,
			Date ngaySinh, String loaiTaiKhoan, String maXacNhan, String matKhau, String trangThai) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.email = email;
		this.hoVaTen = hoVaTen;
		this.maQR = maQR;
		this.hinhDaiDien = hinhDaiDien;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.loaiTaiKhoan = loaiTaiKhoan;
		this.maXacNhan = maXacNhan;
		this.matKhau = matKhau;
		this.trangThai = trangThai;
	}

	public int getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getMaQR() {
		return maQR;
	}

	public void setMaQR(String maQR) {
		this.maQR = maQR;
	}

	public String getHinhDaiDien() {
		return hinhDaiDien;
	}

	public void setHinhDaiDien(String hinhDaiDien) {
		this.hinhDaiDien = hinhDaiDien;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getLoaiTaiKhoan() {
		return loaiTaiKhoan;
	}

	public void setLoaiTaiKhoan(String loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}

	public String getMaXacNhan() {
		return maXacNhan;
	}

	public void setMaXacNhan(String maXacNhan) {
		this.maXacNhan = maXacNhan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "NguoiDung [maNguoiDung=" + maNguoiDung + ", email=" + email + ", hoVaTen=" + hoVaTen + ", maQR=" + maQR
				+ ", hinhDaiDien=" + hinhDaiDien + ", soDienThoai=" + soDienThoai + ", ngaySinh=" + ngaySinh
				+ ", tenTaiKhoan=" + ", loaiTaiKhoan=" + loaiTaiKhoan + ", maXacNhan=" + maXacNhan + ", matKhau="
				+ matKhau + ", trangThai=" + trangThai + "]";
	}

}
