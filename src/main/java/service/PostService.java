package service;

import java.util.List;

import model.Post;
import model.nguoidung;
import modelMapper.PostMapper;

public class PostService extends DAOService<Post> {

	public List<Post> findAll() {
		String sql = "select * from Post";
		return query(sql, new PostMapper());
	}

	public List<Post> findByConditions (int condition3) {
		int condition1 = 1;
		String condition2 = "abc";
		String sql = "select * from Post where condition1=? and condition2=? and condition3=?";
		return query(sql, new PostMapper(), condition1, condition2, condition3);
	}

	public Post findById(int postId) {
		String sql = "select * form Post where id=?";
		List<Post> post = query(sql, new PostMapper(), postId);
		return post.isEmpty() ? null : post.get(0);
	}

	public int savePost(Post post) {
		String sql="insert into Post (content, blahblah)"
				+ "values (?, ?)";
		return insert(sql, post.getContent(), post.getUploadDate());
	}

	public Boolean updatePost(Post post) {
		String sql = "update Post set content=?, blahblah=?";
		return update(sql, post.getContent(), post.getAuthorName());
	}

	public Boolean deletePost(int postId) {
		String sql="delete from Post where id=?";
		return update(sql, postId);
	}
	public List<Post> getPostByIsFriend(nguoidung nguoidung){
		String sql = "";

		return null;
	}
}