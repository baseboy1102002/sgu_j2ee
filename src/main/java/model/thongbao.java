package model;

public class thongbao {
	private baiviet baiviet;
	private String UsersPost;
	public thongbao() {
		super();
	}
	public thongbao(model.baiviet baiviet, String usersPost) {
		super();
		this.baiviet = baiviet;
		UsersPost = usersPost;
	}
	public baiviet getBaiviet() {
		return baiviet;
	}
	public void setBaiviet(baiviet baiviet) {
		this.baiviet = baiviet;
	}
	public String getUsersPost() {
		return UsersPost;
	}
	public void setUsersPost(String usersPost) {
		UsersPost = usersPost;
	}
	
	
}
