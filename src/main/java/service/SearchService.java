package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import model.BaiViet;
import model.NguoiDung;
import model.ThongTinKetBan;
import modelMapper.BaiVietMapper;
import modelMapper.NguoiDungMapper;
import modelMapper.ThongTinKetBanMapper;

public class SearchService{
	private DAOService<NguoiDung> ndDAO = new DAOService<NguoiDung>();
	private DAOService<BaiViet> bvDAO = new DAOService<BaiViet>();
	private DAOService<ThongTinKetBan> ttDao = new DAOService<ThongTinKetBan>();
	
	public List<NguoiDung> getAllUser() {
		String sql = "Select * from nguoidung";
		return ndDAO.query(sql, new NguoiDungMapper());
	}
	
	public List<NguoiDung> findUsers(String name, String user_id) {
		String sql = String.format("SELECT * FROM  nguoidung as ndR where NOT EXISTS ( SELECT * from nguoidung as nd, thongtinketban WHERE thongtinketban.MaNguoiDung1 = nd.MaNguoiDung and ndR.MaNguoiDung = thongtinketban.MaNguoiDung2) AND ndR.MaNguoiDung <> %s and ndR.HoVaTen like '%%%s%%'", user_id, name);
//SELECT * FROM nguoidung as ndR where NOT EXISTS (
		//SELECT * from nguoidung as nd, thongtinketban WHERE thongtinketban.MaNguoiDung1 = nd.MaNguoiDung and ndR.MaNguoiDung = thongtinketban.MaNguoiDung2
	//) and ndR.MaNguoiDung <> 1 and ndR.HoVaTen like '%user%'

		return ndDAO.query(sql, new NguoiDungMapper());
	}
	public List<BaiViet> findPosts(String value){
		String sql = String.format("Select * from baiviet where noidung like '%%%s%%' and TrangThai = 'yes'", value);
		return bvDAO.query(sql, new BaiVietMapper());
	}
	
	public void addFriend(String myId, String friendId) {
		String sqlString = String.format("INSERT INTO thongtinketban (MaNguoiDung1, MaNguoiDung2, TrangThai) values (%s, %s, '%s')", myId, friendId, "chochapnhan" );
		ttDao.insert(sqlString);
	}
}
