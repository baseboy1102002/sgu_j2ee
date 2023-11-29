package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import model.BaiViet;
import model.NguoiDung;
import modelMapper.BaiVietMapper;
import modelMapper.NguoiDungMapper;

public class SearchService{
	private DAOService<NguoiDung> ndDAO = new DAOService<NguoiDung>();
	private DAOService<BaiViet> bvDAO = new DAOService<BaiViet>();
	
	public List<NguoiDung> getAllUser() {
		String sql = "Select * from nguoidung";
		return ndDAO.query(sql, new NguoiDungMapper());
	}
	
	public List<NguoiDung> findUsers(String name, int user_id) {
		String sql = String.format("SELECT * FROM nguoidung where EXISTS ("
				+ "	SELECT * from thongtinketban WHERE thongtinketban.MaNguoiDung1 = %d and nguoidung.MaNguoiDung <> thongtinketban.MaNguoiDung2 and nguoidung.MaNguoiDung <> %d"
				+ ") AND nguoidung.HoVaTen like '%%%s%%'", user_id, user_id, name);
//		SELECT * FROM nguoidung where EXISTS (
//				SELECT * from thongtinketban WHERE thongtinketban.MaNguoiDung1 = 1 and nguoidung.MaNguoiDung <> thongtinketban.MaNguoiDung2 and nguoidung.MaNguoiDung <> 1
//			)
		return ndDAO.query(sql, new NguoiDungMapper());
	}
	public List<BaiViet> findPosts(String value){
		String sql = String.format("Select * from baiviet where noidung like '%%%s%%'", value);
		return bvDAO.query(sql, new BaiVietMapper());
	}
}
