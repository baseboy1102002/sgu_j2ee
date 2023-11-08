package service;

import java.util.List;

import model.NguoiDung;
import model.ThongBao;
import modelMapper.ThongBaoMapper;

public class ThongbaoService extends DAOService<ThongBao> {
	public List<ThongBao> getThongBao(NguoiDung currentUser) {
		String sql = "SELECT  b.*, n.HoVaTen\r\n"
				+ "FROM baiviet b\r\n"
				+ "INNER JOIN thongtinketban t ON (b.MaNguoiDung = t.MaNguoiDung1 OR b.MaNguoiDung = t.MaNguoiDung2)\r\n"
				+ "INNER JOIN nguoidung n ON (n.MaNguoiDung = b.MaNguoiDung)\r\n"
				+ "WHERE (t.MaNguoiDung1 = ? OR t.MaNguoiDung2 = ?) AND t.TrangThai = 'daketban';";
		return query(sql, new ThongBaoMapper(), currentUser.getMaNguoiDung(), currentUser.getMaNguoiDung());
	}
}
