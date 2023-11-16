package service;

import java.util.List;

import model.NguoiDung;
import model.ThongBao;
import modelMapper.ThongBaoMapper;

public class ThongbaoService extends DAOService<ThongBao> {
	public List<ThongBao> getThongBao(int currentUser) {
		String sql = "SELECT DISTINCT b.*, n.HoVaTen\r\n"
				+ "FROM baiviet AS b\r\n"
				+ "INNER JOIN thongtinketban t ON (b.MaNguoiDung = t.MaNguoiDung1 OR b.MaNguoiDung = t.MaNguoiDung2)\r\n"
				+ "INNER JOIN nguoidung n ON (n.MaNguoiDung = b.MaNguoiDung)\r\n"
				+ "WHERE (t.MaNguoiDung1 = 4 OR t.MaNguoiDung2 = 4) AND t.TrangThai = 'daketban'  AND b.MaNguoiDung <> 4\r\n"
				+ "ORDER BY b.NgayDang DESC;";
		return query(sql, new ThongBaoMapper(), currentUser, currentUser);
	}
}
