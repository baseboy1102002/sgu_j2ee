package model;

import java.util.Date;

public class BaiViet {
	private int maBaiViet;
	private Date ngayDang;
	private String noiDung;
	private String trangThai;
	private int maNguoiDung;
	public BaiViet() {
		super();
	}

	public BaiViet(int maBaiViet, Date ngayDang, String noiDung, String trangThai, int maNguoiDung) {
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

	public Date getNgayDang() {
		return ngayDang;
	}

	public void setNgayDang(Date ngayDang) {
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

	@Override
	public String toString() {
		return "BaiViet [maBaiViet=" + maBaiViet + ", ngayDang=" + ngayDang + ", noiDung=" + noiDung + ", trangThai="
				+ trangThai + ", maNguoiDung=" + maNguoiDung + "]";
	}
}
