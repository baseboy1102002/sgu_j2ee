package service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import DBContext.DBContext;

public class FriendActionService {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private DBContext dbc = new DBContext();

	public void ActionHuyKetBan(int user1, int user2) {
	    try {
	        String sql = "DELETE FROM ThongTinKetBan " +
	                     "WHERE (manguoidung1 = ? AND manguoidung2 = ?) OR (manguoidung1 = ? AND manguoidung2 = ?)";
	        conn = dbc.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, user1);
	        pstmt.setInt(2, user2);
	        pstmt.setInt(3, user2);
	        pstmt.setInt(4, user1);
	        pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
			dbc.closeConnection(conn);
		}
	}

	public void UpdateActionChan(int user1, int user2) {
	    try {
	        String insertQuery = "INSERT INTO ThongTinKetBan (manguoidung1, manguoidung2, trangthai) VALUES (?, ?, 'chan')";
	        conn = new DBContext().getConnection();
	        pstmt = conn.prepareStatement(insertQuery);
	        pstmt.setInt(1, user1);
	        pstmt.setInt(2, user2);
	        pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	    	dbc.closeConnection(conn);
	    }
	}

	public void ActionChan(int user1, int user2) {
		ActionHuyKetBan(user1, user2);
		UpdateActionChan(user1, user2);
	}

	public void ActionChapNhanKetBan(int user1, int user2) {
		try {
			String sql = "UPDATE ThongTinKetBan " +
                    "SET TrangThai = 'daketban' " +
                    "WHERE manguoidung1 = ? AND manguoidung2 = ?";
	        conn = dbc.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, user2);
	        pstmt.setInt(2, user1);
	        pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
			dbc.closeConnection(conn);
		}
	}

	public void ActionHuyLoiMoiKetBan1(int user1, int user2) {
		try {
	        String sql = "DELETE FROM ThongTinKetBan " +
	                     "WHERE manguoidung1 = ? AND manguoidung2 = ?";
	        conn = dbc.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, user2);
	        pstmt.setInt(2, user1);
	        pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
			dbc.closeConnection(conn);
		}
	}

	public void ActionHuyLoiMoiKetBan2(int user1, int user2) {
		try {
	        String sql = "DELETE FROM ThongTinKetBan " +
	                     "WHERE manguoidung1 = ? AND manguoidung2 = ?";
	        conn = dbc.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, user1);
	        pstmt.setInt(2, user2);
	        pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
			dbc.closeConnection(conn);
		}
	}

	public void ActionBoChan(int user1, int user2) {
		try {
	        String sql = "DELETE FROM ThongTinKetBan " +
	                     "WHERE manguoidung1 = ? AND manguoidung2 = ?";
	        conn = dbc.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, user1);
	        pstmt.setInt(2, user2);
	        pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
			dbc.closeConnection(conn);
		}
	}

}
