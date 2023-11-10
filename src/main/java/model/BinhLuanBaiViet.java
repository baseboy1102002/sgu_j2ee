package model;

import java.util.Date;

public class BinhLuanBaiViet {
	private int maBinhLuan;
	private int maNguoiDung;
	private int maBaiViet;
	private Date ngayGioBinhLuan;
	private String trangThai;
	private String noiDung;
	private String anhBinhLuan;

	public BinhLuanBaiViet() {
		super();
	}

	public BinhLuanBaiViet(int maBinhLuan, int maNguoiDung, int maBaiViet, Date ngayGioBinhLuan, String trangThai,
			String noiDung, String anhBinhLuan) {
		super();
		this.maBinhLuan = maBinhLuan;
		this.maNguoiDung = maNguoiDung;
		this.maBaiViet = maBaiViet;
		this.ngayGioBinhLuan = ngayGioBinhLuan;
		this.trangThai = trangThai;
		this.noiDung = noiDung;
		this.anhBinhLuan = anhBinhLuan;
	}
	public int getMaBinhLuan() {
		return maBinhLuan;
	}
	public void setMaBinhLuan(int maBinhLuan) {
		this.maBinhLuan = maBinhLuan;
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
	public Date getNgayGioBinhLuan() {
		return ngayGioBinhLuan;
	}
	public void setNgayGioBinhLuan(Date ngayGioBinhLuan) {
		this.ngayGioBinhLuan = ngayGioBinhLuan;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getAnhBinhLuan() {
		return anhBinhLuan;
	}
	public void setAnhBinhLuan(String anhBinhLuan) {
		this.anhBinhLuan = anhBinhLuan;
	}
	@Override
	public String toString() {
		return "BinhLuanBaiViet [maBinhLuan=" + maBinhLuan + ", maNguoiDung=" + maNguoiDung + ", maBaiViet=" + maBaiViet
				+ ", ngayGioBinhLuan=" + ngayGioBinhLuan + ", trangThai=" + trangThai + ", noiDung=" + noiDung
				+ ", anhBinhLuan=" + anhBinhLuan + "]";
	}
}
