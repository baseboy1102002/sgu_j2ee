package service;

import java.util.List;

import model.BaiViet;
import model.Post;
import modelMapper.BaiVietMapper;
import modelMapper.PostMapper;

public class BaiVietService extends DAOService<BaiViet> {

	public BaiVietService() {
		
	}
	
//	Lấy bài viết dựa theo khóa của nó
	public BaiViet getBaiVietById(int maBaiViet) {
		String sql = "select * from baiviet where MaBaiViet = ?";
		List<BaiViet> baiViets = query(sql, new BaiVietMapper(), maBaiViet);
		return baiViets.isEmpty() ? null : baiViets.get(0);
	}
	
	
	
	
}
