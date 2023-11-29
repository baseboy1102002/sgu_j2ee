package model;

import java.util.List;

public class BinhLuanView {
	private BinhLuanBaiViet binhLuanBaiViet;
	private int tongLuotTuongTac;
	private TuongTacBinhLuan loginUserTuongTacBinhLuan;
	private List<TuongTacBinhLuan> top3TuongTac;
	private String anhDaiDienNguoiDang;
	private String hoVaTenNguoiDang;
	private int maNguoiDang;



	public BinhLuanView() {
	}



	public BinhLuanView(BinhLuanBaiViet binhLuanBaiViet, int tongLuotTuongTac,
			TuongTacBinhLuan loginUserTuongTacBinhLuan, List<TuongTacBinhLuan> top3TuongTac, String anhDaiDienNguoiDang,
			String hoVaTenNguoiDang,  int maNguoiDang) {
		this.binhLuanBaiViet = binhLuanBaiViet;
		this.tongLuotTuongTac = tongLuotTuongTac;
		this.loginUserTuongTacBinhLuan = loginUserTuongTacBinhLuan;
		this.top3TuongTac = top3TuongTac;
		this.anhDaiDienNguoiDang = anhDaiDienNguoiDang;
		this.hoVaTenNguoiDang = hoVaTenNguoiDang;
		this.setMaNguoiDang(maNguoiDang);
	}



	public BinhLuanBaiViet getBinhLuanBaiViet() {
		return binhLuanBaiViet;
	}



	public void setBinhLuanBaiViet(BinhLuanBaiViet binhLuanBaiViet) {
		this.binhLuanBaiViet = binhLuanBaiViet;
	}



	public int getTongLuotTuongTac() {
		return tongLuotTuongTac;
	}



	public void setTongLuotTuongTac(int tongLuotTuongTac) {
		this.tongLuotTuongTac = tongLuotTuongTac;
	}



	public TuongTacBinhLuan getLoginUserTuongTacBinhLuan() {
		return loginUserTuongTacBinhLuan;
	}



	public void setLoginUserTuongTacBinhLuan(TuongTacBinhLuan loginUserTuongTacBinhLuan) {
		this.loginUserTuongTacBinhLuan = loginUserTuongTacBinhLuan;
	}



	public List<TuongTacBinhLuan> getTop3TuongTac() {
		return top3TuongTac;
	}



	public void setTop3TuongTac(List<TuongTacBinhLuan> top3TuongTac) {
		this.top3TuongTac = top3TuongTac;
	}



	public String getAnhDaiDienNguoiDang() {
		return anhDaiDienNguoiDang;
	}



	public void setAnhDaiDienNguoiDang(String anhDaiDienNguoiDang) {
		this.anhDaiDienNguoiDang = anhDaiDienNguoiDang;
	}



	public String getHoVaTenNguoiDang() {
		return hoVaTenNguoiDang;
	}



	public void setHoVaTenNguoiDang(String hoVaTenNguoiDang) {
		this.hoVaTenNguoiDang = hoVaTenNguoiDang;
	}



	@Override
	public String toString() {
		return "BinhLuanView [binhLuanBaiViet=" + binhLuanBaiViet + ", tongLuotTuongTac=" + tongLuotTuongTac
				+ ", loginUserTuongTacBinhLuan=" + loginUserTuongTacBinhLuan + ", top3TuongTac=" + top3TuongTac
				+ ", anhDaiDienNguoiDang=" + anhDaiDienNguoiDang + ", hoVaTenNguoiDang=" + hoVaTenNguoiDang + "]";
	}



	public int getMaNguoiDang() {
		return maNguoiDang;
	}



	public void setMaNguoiDang(int maNguoiDang) {
		this.maNguoiDang = maNguoiDang;
	}





}
