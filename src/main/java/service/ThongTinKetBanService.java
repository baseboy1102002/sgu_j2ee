package service;

import java.util.List;

import model.ThongTinKetBan;
import modelMapper.ThongTinKetBanMapper;

public class ThongTinKetBanService extends DAOService<ThongTinKetBan>{
	public ThongTinKetBanService() {

	}
	public List<ThongTinKetBan> geThongTinKetBansLaBan(int maNguoiDung){
		String sql = "SELECT * FROM thongtinketban WHERE (MaNguoiDung1 = ? AND TrangThai = 'daketban') OR (MaNguoiDung2 = ? AND TrangThai = 'daketban')";
		List<ThongTinKetBan> friends = query(sql, new ThongTinKetBanMapper(), maNguoiDung,  maNguoiDung);
		return friends.isEmpty() ? null : friends;
	}
	public ThongTinKetBan getTrangThaiKetBanHaiNguoiDung(int maNguoiDung1, int maNguoiDung2){
		String sql = "SELECT * FROM thongtinketban \r\n"
				+ "WHERE (MaNguoiDung1 = ? AND MaNguoiDung2 = ?) \r\n"
				+ "OR (MaNguoiDung2 = ? AND MaNguoiDung1 = ?)";
		List<ThongTinKetBan> friends = query(sql, new ThongTinKetBanMapper(), maNguoiDung1, maNguoiDung2, maNguoiDung1, maNguoiDung2);
		return friends.isEmpty() ? null : friends.get(0);
	}
	public Integer insertNewFriend(int maNguoiDung1, int maNguoiDung2) {
		String sql = "INSERT INTO thongtinketban(MaNguoiDung1, MaNguoiDung2, TrangThai) VALUE(?, ?, 'chochapnhan')";
		return insert(sql, maNguoiDung1, maNguoiDung2);
	}

}
