package model;

public class ThongTinKetBan {
	private int manguoidung1;
	private int manguoidung2;
	private String trangthai;

	public ThongTinKetBan() {
		super();
	}

	public ThongTinKetBan(int manguoidung1, int manguoidung2, String trangthai) {
		super();
		this.manguoidung1 = manguoidung1;
		this.manguoidung2 = manguoidung2;
		this.trangthai = trangthai;
	}

	public int getManguoidung1() {
		return manguoidung1;
	}

	public void setManguoidung1(int manguoidung1) {
		this.manguoidung1 = manguoidung1;
	}

	public int getManguoidung2() {
		return manguoidung2;
	}

	public void setManguoidung2(int manguoidung2) {
		this.manguoidung2 = manguoidung2;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

}
