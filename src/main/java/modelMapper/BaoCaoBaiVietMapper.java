package modelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.BaoCaoBaiviet;

public class BaoCaoBaiVietMapper {
	public BaoCaoBaiviet mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		BaoCaoBaiviet baoCaoBaiviet = new BaoCaoBaiviet();
		try {
			baoCaoBaiviet.setLiDo(rs.getString("LiDo"));
			baoCaoBaiviet.setMaBaiViet(rs.getInt("MaBaiViet"));
			baoCaoBaiviet.setNgayGioBaoCao(rs.getTimestamp("NgayGioBaoCao"));
			baoCaoBaiviet.setMaNguoiDung(rs.getInt("MaNguoiDung"));
			
			return baoCaoBaiviet;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}
}
