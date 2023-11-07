package model;

public class thongbao {
	private baiviet baiviet;
	private String usersPost;
	
	public thongbao() {
		super();
	}
	public thongbao(model.baiviet baiviet, String usersPost) {
		super();
		this.baiviet = baiviet;
		this.usersPost = usersPost;
	}
	public baiviet getBaiviet() {
		return baiviet;
	}
	public void setBaiviet(baiviet baiviet) {
		this.baiviet = baiviet;
	}
	public String getUsersPost() {
		return usersPost;
	}
	public void setUsersPost(String usersPost) {
		this.usersPost = usersPost;
	}

}
