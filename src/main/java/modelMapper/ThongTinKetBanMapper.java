package modelMapper;

import java.sql.ResultSet;

import model.ThongBao;
import model.ThongTinKetBan;

public class ThongTinKetBanMapper implements rowMapper<ThongTinKetBan>{
	@Override
	public ThongTinKetBan mapRow(ResultSet rs) {
		try {
			ThongTinKetBan ThongTinKetBan = new ThongTinKetBan();
			ThongTinKetBan.setMaNguoiDung1(rs.getInt("MaNguoiDung1"));
			ThongTinKetBan.setMaNguoidung2(rs.getInt("MaNguoiDung2"));
			ThongTinKetBan.setTrangThai(rs.getString("TrangThai"));
			return ThongTinKetBan;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
