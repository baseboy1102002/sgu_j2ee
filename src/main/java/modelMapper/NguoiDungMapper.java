package modelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.NguoiDung;

public class NguoiDungMapper implements rowMapper<NguoiDung> {
@Override
public NguoiDung mapRow(ResultSet rs) {
	NguoiDung nguoiDung = new NguoiDung();
	try {
		nguoiDung.setMaNguoiDung(rs.getInt("MaNguoiDung"));
		nguoiDung.setEmail(rs.getString("Email"));
		nguoiDung.setHoVaTen(rs.getString("HoVaTen"));
		nguoiDung.setMaQR(rs.getString("MaQR"));
		nguoiDung.setHinhDaiDien(rs.getString("HinhDaiDien"));
		nguoiDung.setSoDienThoai(rs.getString("SoDienThoai"));
		nguoiDung.setNgaySinh(rs.getDate("NgaySinh"));
		nguoiDung.setLoaiTaiKhoan(rs.getString("LoaiTaiKhoan"));
		nguoiDung.setMaXacNhan(rs.getString("MaXacNhan"));
		nguoiDung.setMatKhau(rs.getString("MatKhau"));
		nguoiDung.setTrangThai(rs.getString("TrangThai"));
		
		return nguoiDung;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	// TODO Auto-generated method stub
	return null;
}
}
