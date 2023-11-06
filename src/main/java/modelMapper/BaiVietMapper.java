package modelMapper;
import java.sql.ResultSet;

import model.baiviet;

public class BaiVietMapper implements rowMapper<baiviet>{
	@Override
	public baiviet mapRow(ResultSet rs) {
		try {
			baiviet bViet = new baiviet();
			bViet.setMaBaiViet(rs.getInt("MaBaiViet"));
			bViet.setNgayDang(rs.getDate("NgayDang"));
			bViet.setNoiDung(rs.getString("NoiDung"));
			bViet.setTrangThai(rs.getString("TrangThai"));
			bViet.setMaNguoiDung(rs.getInt("MaNguoiDung"));
			return bViet;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
