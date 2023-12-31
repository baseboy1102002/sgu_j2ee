package model;

import java.util.List;

public class BaiVietView {
	private BaiViet baiViet;
	private TuongTacBaiViet loginUserTuongTacBaiViet;
	private List<FileBaiViet> fileHinhAnhs;
	private List<FileBaiViet> fileDinhKems;
	private List<TuongTacBaiViet> top3TuongTac;
	private int binhLuanCount;
	private int tongLuotTuongTac;

	public BaiVietView() {
	}

	public BaiVietView(BaiViet baiViet, TuongTacBaiViet loginUserTuongTacBaiViet, List<FileBaiViet> fileHinhAnhs,
			List<FileBaiViet> fileDinhKems, List<TuongTacBaiViet> top3TuongTac, int binhLuanCount,
			int tongLuotTuongTac) {
		this.baiViet = baiViet;
		this.loginUserTuongTacBaiViet = loginUserTuongTacBaiViet;
		this.fileHinhAnhs = fileHinhAnhs;
		this.fileDinhKems = fileDinhKems;
		this.top3TuongTac = top3TuongTac;
		this.binhLuanCount = binhLuanCount;
		this.tongLuotTuongTac = tongLuotTuongTac;
	}

	public BaiViet getBaiViet() {
		return baiViet;
	}

	public void setBaiViet(BaiViet baiViet) {
		this.baiViet = baiViet;
	}

	public TuongTacBaiViet getLoginUserTuongTacBaiViet() {
		return loginUserTuongTacBaiViet;
	}

	public void setLoginUserTuongTacBaiViet(TuongTacBaiViet loginUserTuongTacBaiViet) {
		this.loginUserTuongTacBaiViet = loginUserTuongTacBaiViet;
	}

	public List<FileBaiViet> getFileHinhAnhs() {
		return fileHinhAnhs;
	}

	public void setFileHinhAnhs(List<FileBaiViet> fileHinhAnhs) {
		this.fileHinhAnhs = fileHinhAnhs;
	}

	public List<FileBaiViet> getFileDinhKems() {
		return fileDinhKems;
	}

	public void setFileDinhKems(List<FileBaiViet> fileDinhKems) {
		this.fileDinhKems = fileDinhKems;
	}

	public List<TuongTacBaiViet> getTop3TuongTac() {
		return top3TuongTac;
	}

	public void setTop3TuongTac(List<TuongTacBaiViet> top3TuongTac) {
		this.top3TuongTac = top3TuongTac;
	}

	public int getBinhLuanCount() {
		return binhLuanCount;
	}

	public void setBinhLuanCount(int binhLuanCount) {
		this.binhLuanCount = binhLuanCount;
	}

	public int getTongLuotTuongTac() {
		return tongLuotTuongTac;
	}

	public void setTongLuotTuongTac(int tongLuotTuongTac) {
		this.tongLuotTuongTac = tongLuotTuongTac;
	}

}
