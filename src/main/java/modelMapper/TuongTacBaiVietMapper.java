package modelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.TuongTacBaiViet;

public class TuongTacBaiVietMapper implements rowMapper<TuongTacBaiViet> {

	@Override
	public TuongTacBaiViet mapRow(ResultSet rs) {
		TuongTacBaiViet tuongTacBaiViet = new TuongTacBaiViet();
		try {
			tuongTacBaiViet.setMaBaiViet(rs.getInt("MaBaiViet"));
			tuongTacBaiViet.setMaNguoiDung(rs.getInt("MaNguoiDung"));
			tuongTacBaiViet.setNgayGioTuongTac(rs.getDate("NgayGioTuongTac"));
			tuongTacBaiViet.setTrangThai(rs.getString("TrangThai"));
			return tuongTacBaiViet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}
	
}
