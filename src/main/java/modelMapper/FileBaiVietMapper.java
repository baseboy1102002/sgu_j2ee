package modelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.FileBaiViet;

public class FileBaiVietMapper implements rowMapper<FileBaiViet> {
@Override
public FileBaiViet mapRow(ResultSet rs) {
	FileBaiViet fileBaiViet = new FileBaiViet();
	try {
		fileBaiViet.setMaBaiViet(rs.getInt("MaBaiViet"));
		fileBaiViet.setMaFile(rs.getInt("MaFile"));
		fileBaiViet.setTenFile(rs.getString("TenFile"));
		fileBaiViet.setTrangThai(rs.getString("TrangThai"));
		fileBaiViet.setLoaiFile(rs.getString("LoaiFile"));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// TODO Auto-generated method stub
	return null;
}
}
