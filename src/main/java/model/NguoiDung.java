package model;

import java.util.Date;

public class NguoiDung {
	private int manguoidung;
	private String email;
	private String hovaten;
	private String maqr;
	private String hinhdaidien;
	private String sodienthoai;
	private Date ngaysinh;
	private String tentaikhoan;
	private String loaitaikhoan;
	private String maxacnhan;
	private String matkhau;
	private String trangthai;

	public NguoiDung() {
		super();
	}
	
	


	public NguoiDung(int manguoidung, String hovaten, String hinhdaidien) {
		super();
		this.setManguoidung(manguoidung);
		this.setHovaten(hovaten);
		this.setHinhdaidien(hinhdaidien);
	}

	public NguoiDung(int manguoidung, String email, String hovaten, String maqr, String hinhdaidien, String sodienthoai,
			Date ngaysinh, String loaitaikhoan, String maxacnhan, String matkhau, String trangthai) {
		super();
		this.manguoidung = manguoidung;
		this.email = email;
		this.hovaten = hovaten;
		this.maqr = maqr;
		this.hinhdaidien = hinhdaidien;
		this.sodienthoai = sodienthoai;
		this.ngaysinh = ngaysinh;
		this.loaitaikhoan = loaitaikhoan;
		this.maxacnhan = maxacnhan;
		this.matkhau = matkhau;
		this.trangthai = trangthai;
	}

	public int getManguoidung() {
		return manguoidung;
	}

	public void setManguoidung(int manguoidung) {
		this.manguoidung = manguoidung;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHovaten() {
		return hovaten;
	}

	public void setHovaten(String hovaten) {
		this.hovaten = hovaten;
	}

	public String getMaqr() {
		return maqr;
	}

	public void setMaqr(String maqr) {
		this.maqr = maqr;
	}

	public String getHinhdaidien() {
		return hinhdaidien;
	}

	public void setHinhdaidien(String hinhdaidien) {
		this.hinhdaidien = hinhdaidien;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getLoaitaikhoan() {
		return loaitaikhoan;
	}

	public void setLoaitaikhoan(String loaitaikhoan) {
		this.loaitaikhoan = loaitaikhoan;
	}

	public String getMaxacnhan() {
		return maxacnhan;
	}

	public void setMaxacnhan(String maxacnhan) {
		this.maxacnhan = maxacnhan;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	
	
	public String getTentaikhoan() {
		return tentaikhoan;
	}



	public void setTentaikhoan(String tentaikhoan) {
		this.tentaikhoan = tentaikhoan;
	}


}
