package service;

import java.util.List;

import model.BinhLuanBaiViet;
import modelMapper.BinhLuanBaiVietMapper;

public class BinhLuanBaiVietService  extends DAOService<BinhLuanBaiViet>{
	public BinhLuanBaiVietService() {
		
	}
	
	public List<BinhLuanBaiViet> getBinhLuansByBaiVietId(int maBaiViet) {
			String sql = "Select * from binhluanbaiviet where MaBaiViet = ?";
			return query(sql, new BinhLuanBaiVietMapper(), maBaiViet);		
	}
	
	
}
