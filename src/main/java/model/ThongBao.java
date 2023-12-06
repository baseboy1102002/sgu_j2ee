package model;

public class ThongBao {
	private BaiViet baiviet;
	private String usersPost;
	private String anhDaiDien;
	public ThongBao() {
		super();
	}
	public ThongBao(BaiViet baiviet, String usersPost, String anhDaiDien) {
		super();
		this.baiviet = baiviet;
		this.usersPost = usersPost;
		this.anhDaiDien = anhDaiDien;
	}
	public BaiViet getBaiviet() {
		return baiviet;
	}
	public void setBaiviet(BaiViet baiviet) {
		this.baiviet = baiviet;
	}
	public String getUsersPost() {
		return usersPost;
	}
	public void setUsersPost(String usersPost) {
		this.usersPost = usersPost;
	}
	public String getAnhDaiDien() {
		return anhDaiDien;
	}
	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}
	

}
