package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.TuongTacBaiViet;
import modelMapper.TuongTacBaiVietMapper;

public class TuongTacBaiVietService extends DAOService<TuongTacBaiViet> {
	public TuongTacBaiVietService() {

	}

//	Lấy tổng lượt tương tác của 1 bài viết
	public int getTongLuotTuongTacBaiViet(int maBaiViet) {
		String sql = "SELECT COUNT(*) AS tongLuotTT FROM `tuongtacbaiviet` WHERE MaBaiViet = ? ";
		Connection conn = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rSet = null;
		int tongLuotTT = 0;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, maBaiViet);
			rSet = preparedStatement.executeQuery();

			if (rSet.next()) {

				tongLuotTT = rSet.getInt("tongLuotTT");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			closeConnection(conn, preparedStatement, rSet);
		}

		return tongLuotTT;
	}

//	Cái này để lấy ra top 3 tương tác của bài viết
	public List<TuongTacBaiViet> getTop3TuongTacBaiViet(int maBaiViet) {
		String sql = "SELECT * FROM `tuongtacbaiviet` WHERE MaBaiViet = ? GROUP BY TrangThai ORDER BY COUNT(TrangThai) DESC LIMIT 3";
		return query(sql, new TuongTacBaiVietMapper(), maBaiViet);
	}

//	Cái này để lấy tương tác của người dùng cụ thể với một bài viết cụ thể
	public TuongTacBaiViet getUserTuongTacBaiViet(int maBaiViet, int maNguoiDung) {
		String sql = "Select * from `tuongtacbaiviet` Where MaNguoiDung =? AND MaBaiViet = ?";
		List<TuongTacBaiViet> tuongTacBaiViets = query(sql, new TuongTacBaiVietMapper(), maNguoiDung, maBaiViet);
		return tuongTacBaiViets.isEmpty() ? null : tuongTacBaiViets.get(0);
	}

	public Integer addTuongTacBaiViet(TuongTacBaiViet tuongTacBaiViet) {
		String sql ="INSERT INTO `tuongtacbaiviet` (`MaNguoiDung`, `MaBaiViet`, `NgayGioTuongTac`, `TrangThai`) VALUES (?, ?, ?, ?)";
		return insert(sql, tuongTacBaiViet.getMaNguoiDung(),tuongTacBaiViet.getMaBaiViet(),tuongTacBaiViet.getNgayGioTuongTac(),tuongTacBaiViet.getTrangThai());
	}

	public boolean updateTuongTacBaiViet(TuongTacBaiViet tuongTacBaiViet) {
		String sql="UPDATE `tuongtacbaiviet` SET  `NgayGioTuongTac` = ?, `TrangThai` = ? WHERE `tuongtacbaiviet`.`MaNguoiDung` = ? AND `tuongtacbaiviet`.`MaBaiViet` = ?";
		return update(sql, tuongTacBaiViet.getNgayGioTuongTac(),tuongTacBaiViet.getTrangThai(),tuongTacBaiViet.getMaNguoiDung(),tuongTacBaiViet.getMaBaiViet());
	}
	
	public boolean deleteTuongTacBaiViet(int maBaiViet, int maNguoiDung) {
		String sql="DELETE FROM `tuongtacbaiviet` WHERE `tuongtacbaiviet`.`MaNguoiDung` = ? AND `tuongtacbaiviet`.`MaBaiViet` = ?";
		return update(sql, maNguoiDung,maBaiViet);
		
		
	}
	
}
