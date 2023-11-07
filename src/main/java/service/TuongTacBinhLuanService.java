package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.TuongTacBinhLuan;

public class TuongTacBinhLuanService extends DAOService<TuongTacBinhLuan> {

	public TuongTacBinhLuanService() {

	}

	public int getTongSoBinhLuanBaiViet(int maBaiViet) {
		String sql = "SELECT COUNT(*) AS tongLuotTT FROM `tuongtacbinhluan` WHERE MaBaiViet = ? ";
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
}
