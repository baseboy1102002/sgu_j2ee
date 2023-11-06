package modelMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.NguoiDung;

public class NguoiDungMapper implements rowMapper<NguoiDung> {
@Override
public NguoiDung mapRow(ResultSet rs) {
	NguoiDung nguoiDung = new NguoiDung();
	try {
		nguoiDung.setManguoidung(rs.getInt("MaNguoiDung"));
		nguoiDung.setEmail(rs.getString("Email"));
		nguoiDung.setHovaten(rs.getString("HoVaTen"));
		nguoiDung.setMaqr(rs.getString("MaQR"));
		nguoiDung.setHinhdaidien(rs.getString("HinhDaiDien"));
		nguoiDung.setSodienthoai(rs.getString("SoDienThoai"));
		nguoiDung.setNgaysinh(rs.getDate("NgaySinh"));
		nguoiDung.setLoaitaikhoan(rs.getString("LoaiTaiKhoan"));
		nguoiDung.setMaxacnhan(rs.getString("MaXacNhan"));
		nguoiDung.setMatkhau(rs.getString("MatKhau"));
		nguoiDung.setTrangthai(rs.getString("TrangThai"));
		nguoiDung.setTentaikhoan(rs.getString("TenTaiKhoan"));
		return nguoiDung;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	// TODO Auto-generated method stub
	return null;
}
}
