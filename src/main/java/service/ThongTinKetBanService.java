package service;

import java.util.List;

import model.NguoiDung;
import model.ThongTinKetBan;
import modelMapper.NguoiDungMapper;
import modelMapper.ThongTinKetBanMapper;

public class ThongTinKetBanService extends DAOService<ThongTinKetBan>{
	public ThongTinKetBanService() {
		
	}
	public List<ThongTinKetBan> geThongTinKetBansLaBan(int maNguoiDung){
		String sql = "SELECT * FROM thongtinketban WHERE (MaNguoiDung1 = ? AND TrangThai = 'daketban') OR (MaNguoiDung2 = ? AND TrangThai = 'daketban')";
		List<ThongTinKetBan> friends = query(sql, new ThongTinKetBanMapper(), maNguoiDung,  maNguoiDung);
		return friends.isEmpty() ? null : friends;
	}
}
