package modelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.TuongTacBinhLuan;

public class TuongTacBinhLuanMapper implements rowMapper<TuongTacBinhLuan> {
	@Override
	public TuongTacBinhLuan mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		TuongTacBinhLuan tuongTacBinhLuan = new TuongTacBinhLuan();
		try {
			tuongTacBinhLuan.setMaBinhLuan(rs.getInt("MaBinhLuan"));
			tuongTacBinhLuan.setMaNguoiDung(rs.getInt("MaNguoiDung"));
			tuongTacBinhLuan.setNgayGioTuongTac(rs.getDate("NgayGioTuongTac"));
			tuongTacBinhLuan.setTrangThai(rs.getString("TrangThai"));
			return tuongTacBinhLuan;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
