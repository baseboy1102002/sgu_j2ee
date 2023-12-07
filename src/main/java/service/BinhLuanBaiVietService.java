package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.BinhLuanBaiViet;
import modelMapper.BinhLuanBaiVietMapper;

public class BinhLuanBaiVietService extends DAOService<BinhLuanBaiViet> {
	public BinhLuanBaiVietService() {

	}

	public List<BinhLuanBaiViet> getBinhLuansByBaiVietId(int maBaiViet) {
		String sql = "Select * from binhluanbaiviet where MaBaiViet = ? and TrangThai = 'new' order by NgayGioBinhLuan desc";
		return query(sql, new BinhLuanBaiVietMapper(), maBaiViet);
	}

	public Integer addBinhLuan(BinhLuanBaiViet binhLuanBaiViet) {
		String sql = "INSERT INTO `binhluanbaiviet` (`MaNguoiDung`, `MaBaiViet`, `NgayGioBinhLuan`, `TrangThai`, `NoiDung`, `AnhBinhLuan`) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		return insert(sql, binhLuanBaiViet.getMaNguoiDung(), binhLuanBaiViet.getMaBaiViet(),
				binhLuanBaiViet.getNgayGioBinhLuan(), binhLuanBaiViet.getTrangThai(), binhLuanBaiViet.getNoiDung(),
				binhLuanBaiViet.getAnhBinhLuan());
	}

	public BinhLuanBaiViet getBinhLuanBaiVietById(int maBinhLuan) {
		String sql = "select * from binhluanbaiviet where MaBinhLuan = ?";
		List<BinhLuanBaiViet> binhLuanBaiViets = query(sql, new BinhLuanBaiVietMapper(), maBinhLuan);
		return binhLuanBaiViets.isEmpty() ? null : binhLuanBaiViets.get(0);

	}

	public Boolean updateBinhLuan(BinhLuanBaiViet binhLuanBaiViet) {
		String sql = "UPDATE `binhluanbaiviet` SET  `NgayGioBinhLuan` = ?, `NoiDung` = ?, `AnhBinhLuan` = ? WHERE `binhluanbaiviet`.`MaBinhLuan` = ? ";
		return update(sql, binhLuanBaiViet.getNgayGioBinhLuan(),binhLuanBaiViet.getNoiDung(),binhLuanBaiViet.getAnhBinhLuan(),binhLuanBaiViet.getMaBinhLuan());
	}

	public Boolean deleteBinhLuanById(int maBinhLuan) {
		String sql = "UPDATE `binhluanbaiviet` SET  TrangThai = ?  WHERE `binhluanbaiviet`.`MaBinhLuan` = ? ";
		return update(sql,"xoa" ,maBinhLuan);

	}
	
	public int getTongLuotBinhLuanByBaiVietId(int maBaiViet) {
		String sql = "Select COUNT(*) AS tongLuotBinhLuan from binhluanbaiviet where MaBaiViet = ? and TrangThai = 'new'";
		Connection conn = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rSet = null;
		int tongLuotBinhLuan = 0;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, maBaiViet);
			rSet = preparedStatement.executeQuery();

			if (rSet.next()) {
				tongLuotBinhLuan = rSet.getInt("tongLuotBinhLuan");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			closeConnection(conn, preparedStatement, rSet);
		}
		return tongLuotBinhLuan;

	}


}
