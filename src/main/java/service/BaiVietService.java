package service;

import java.util.List;

import model.BaiViet;
import modelMapper.BaiVietMapper;

public class BaiVietService extends DAOService<BaiViet>{
	public int saveBaiViet(BaiViet baiviet) {
		String sql="insert into baiviet (NgayDang, NoiDung, TrangThai, MaNguoiDung)"
				+ "values (?, ?, ?, ?)";
		return insert(sql, baiviet.getNgayDang(), baiviet.getNoiDung(), baiviet.getTrangThai(), baiviet.getMaNguoiDung());
	}
	
	public Boolean deleteBaiViet(int MaBaiViet) {
		String sql = "update baiviet set TrangThai = 'xoa' where MaBaiViet = ?";
		return update(sql, MaBaiViet);
	}
	
	public Boolean updateBaiViet(String NoiDung, int MaBaiViet) {
		String sql = "update baiviet set NoiDung = ? where MaBaiViet = ?";
		return update(sql, NoiDung, MaBaiViet);
	}

}
