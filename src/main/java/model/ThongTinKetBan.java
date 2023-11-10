package model;

public class ThongTinKetBan {
	private int maNguoiDung1;
	private int maNguoidung2;
	private String trangThai;

	public ThongTinKetBan() {
		super();
	}
	
	

	public ThongTinKetBan(int maNguoiDung1, int maNguoidung2, String trangThai) {
		this.maNguoiDung1 = maNguoiDung1;
		this.maNguoidung2 = maNguoidung2;
		this.trangThai = trangThai;
	}



	public int getMaNguoiDung1() {
		return maNguoiDung1;
	}

	public void setMaNguoiDung1(int maNguoiDung1) {
		this.maNguoiDung1 = maNguoiDung1;
	}

	public int getMaNguoidung2() {
		return maNguoidung2;
	}

	public void setMaNguoidung2(int maNguoidung2) {
		this.maNguoidung2 = maNguoidung2;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "ThongTinKetBan [maNguoiDung1=" + maNguoiDung1 + ", maNguoidung2=" + maNguoidung2 + ", trangThai="
				+ trangThai + "]";
	}

	
	
}
