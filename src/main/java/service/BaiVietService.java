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
	
	public Boolean deleteBaiVietById(int maBaiViet) {
		String sql ="update baiviet set TrangThai = 'xoa' Where MaBaiViet=?";
		return update(sql, maBaiViet);
		
	}
	public int saveBaiViet(BaiViet baiviet) {
		String sql="insert into baiviet (NgayDang, NoiDung, TrangThai, MaNguoiDung)"
				+ "values (?, ?, ?, ?)";
		return insert(sql, baiviet.getNgayDang(), baiviet.getNoiDung(), baiviet.getTrangThai(), baiviet.getMaNguoiDung());
	}
	
	public Boolean deleteBaiViet(int MaBaiViet) {
		String sql = "update baiviet set TrangThai = 'No' where MaBaiViet = ?";
		return update(sql, MaBaiViet);
	}
	
	public Boolean updateBaiViet(String NoiDung, int MaBaiViet) {
		String sql = "update baiviet set NoiDung = ? where MaBaiViet = ?";
		return update(sql, NoiDung, MaBaiViet);
	}
	
}
