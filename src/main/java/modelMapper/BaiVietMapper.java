package modelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.BaiViet;

public class BaiVietMapper implements rowMapper<BaiViet> {
	
	@Override
	public BaiViet mapRow(ResultSet rs) {
		BaiViet baiViet = new BaiViet();
		try {
			baiViet.setMaBaiViet(rs.getInt("MaBaiViet"));
			baiViet.setMaNguoiDung(rs.getInt("MaNguoiDung"));
			
			baiViet.setNgayDang(rs.getTimestamp("NgayDang"));
			baiViet.setNoiDung(rs.getString("NoiDung"));
			baiViet.setTrangThai(rs.getString("TrangThai"));
			return baiViet;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
