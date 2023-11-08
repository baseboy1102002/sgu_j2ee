package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.TuongTacBinhLuan;
import modelMapper.TuongTacBinhLuanMapper;

public class TuongTacBinhLuanService extends DAOService<TuongTacBinhLuan> {

	public TuongTacBinhLuanService() {

	}

	public int getTongSoTuongTacBinhLuan(int maBinhLuan) {
		String sql = "SELECT COUNT(*) AS tongLuotTT FROM `tuongtacbinhluan` WHERE MaBinhLuan = ? ";
		Connection conn = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rSet = null;
		int tongLuotTT = 0;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, maBinhLuan);
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
	

	public List<TuongTacBinhLuan> getTop3TuongTacBinhLuan(int maBinhLuan){
		String sql = "Select * from tuongtacbinhluan where MaBinhLuan =? group by trangthai order by count(trangthai) desc limit 3";
		
		return query(sql, new TuongTacBinhLuanMapper(), maBinhLuan);
	}
	
	public TuongTacBinhLuan getUserTuongTacBinhLuan(int maBinhLuan,int maNguoiDung) {
		String sql = "Select * from tuongtacbinhluan where MaBinhLuan =? and MaNguoiDung = ?";
		List<TuongTacBinhLuan> tuongTacBinhLuans = query(sql,new TuongTacBinhLuanMapper(), maBinhLuan, maNguoiDung);
		return tuongTacBinhLuans.isEmpty() ? null : tuongTacBinhLuans.get(0);		
	}
	
}
