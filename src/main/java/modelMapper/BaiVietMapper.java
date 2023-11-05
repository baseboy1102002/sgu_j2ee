package modelMapper;
import java.sql.ResultSet;

import org.eclipse.jdt.internal.compiler.lookup.TagBits;

import model.BaiViet;

public class BaiVietMapper implements rowMapper<BaiViet>{
	@Override
	public BaiViet mapRow(ResultSet rs) {
		try {
			BaiViet bViet = new BaiViet();
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
