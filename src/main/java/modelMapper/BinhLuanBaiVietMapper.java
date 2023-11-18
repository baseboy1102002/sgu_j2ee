package modelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.BinhLuanBaiViet;

public class BinhLuanBaiVietMapper implements rowMapper<BinhLuanBaiViet> {
	@Override
	public BinhLuanBaiViet mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		BinhLuanBaiViet binhLuanBaiViet = new BinhLuanBaiViet();

		try {
			binhLuanBaiViet.setMaBinhLuan(rs.getInt("MaBinhLuan"));
			binhLuanBaiViet.setMaBaiViet(rs.getInt("MaBaiViet"));
			binhLuanBaiViet.setMaNguoiDung(rs.getInt("MaNguoiDung"));
			binhLuanBaiViet.setNgayGioBinhLuan(rs.getTimestamp("NgayGioBinhLuan"));
			binhLuanBaiViet.setNoiDung(rs.getString("NoiDung"));
			binhLuanBaiViet.setTrangThai(rs.getString("TrangThai"));
			binhLuanBaiViet.setAnhBinhLuan(rs.getString("AnhBinhLuan"));
			return binhLuanBaiViet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
