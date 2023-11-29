package modelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Post;

public class PostMapper implements rowMapper<Post>{

	@Override
	public Post mapRow(ResultSet rs) {
		try {
			Post post = new Post();
			post.setContent(rs.getString("noi_dung_bai_viet"));
			post.setAuthorName(rs.getString("ten_tac_gia"));
			post.setUploadDate(rs.getTimestamp("ngay_tao"));
			return post;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
