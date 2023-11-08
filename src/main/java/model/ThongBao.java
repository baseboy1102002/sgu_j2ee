package model;

public class ThongBao {
	private BaiViet baiviet;
	private String usersPost;
	
	public ThongBao() {
		super();
	}
	public ThongBao(model.BaiViet baiviet, String usersPost) {
		super();
		this.baiviet = baiviet;
		this.usersPost = usersPost;
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

}
