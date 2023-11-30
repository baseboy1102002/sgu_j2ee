package modelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.BaoCaoNguoiDung;

public class BaoCaoNguoiDungMapper implements rowMapper<BaoCaoNguoiDung> {
	public BaoCaoNguoiDung mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		BaoCaoNguoiDung baoCaoNguoiDung = new BaoCaoNguoiDung();
		try {
			baoCaoNguoiDung.setLiDo(rs.getString("LiDo"));
			baoCaoNguoiDung.setMaNguoiDungBaoCao(rs.getInt("MaNguoiDungBaoCao"));
			baoCaoNguoiDung.setNgayGioBaoCao(rs.getTimestamp("NgayGioBaoCao"));
			baoCaoNguoiDung.setMaNguoiDungBiBaoCao(rs.getInt("MaNguoiDungBiBaoCao"));
			
			return baoCaoNguoiDung;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}
}
