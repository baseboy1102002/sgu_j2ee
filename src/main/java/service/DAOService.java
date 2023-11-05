package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import modelMapper.rowMapper;


public class DAOService<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "amip");
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
		
	}
	
	public void closeConnection(Connection conn, PreparedStatement pstm, ResultSet rs) {
		try {
			if(conn!=null)
				conn.close();
			if(pstm!=null)
				pstm.close();
			if(rs!=null)
				rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void rollBackconnection(Connection conn) {
		if(conn!=null) {
			try {
				conn.rollback();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<T> query(String sql, rowMapper<T> rmp, Object...params) {
		List<T> results = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstm = conn.prepareStatement(sql);
			setParamaters(pstm, params);
			rs = pstm.executeQuery();
			while(rs.next()) {
				results.add(rmp.mapRow(rs));
			}
			return results;
		} catch(SQLException e) {
			e.printStackTrace();
			return results;
		} finally {
			closeConnection(conn, pstm, rs);
		}
	}
	
	public Integer insert(String sql, Object...params) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Integer id = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			pstm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			setParamaters(pstm, params);
			pstm.executeUpdate();
			rs = pstm.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getInt(1);
			}
			conn.commit();
			return id;
		} catch(SQLException e) {
			e.printStackTrace();
			rollBackconnection(conn);
			return id;
		} finally {
			closeConnection(conn, pstm, rs);
		}
	}

	public Boolean update(String sql, Object...params) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			pstm = conn.prepareStatement(sql);
			setParamaters(pstm, params);
			pstm.executeUpdate();
			conn.commit();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
			rollBackconnection(conn);
			return false;
		} finally {
			closeConnection(conn, pstm, null);
		}
	}
	
	public int count(String sql, Object... params) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			pstm = conn.prepareStatement(sql);
			setParamaters(pstm, params);
			rs = pstm.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
			conn.commit();
			return count;
		} catch(SQLException e) {
			e.printStackTrace();
			rollBackconnection(conn);
			return count;
		} finally {
			closeConnection(conn, pstm, null);
		}
	}
	
	public void setParamaters(PreparedStatement pstm, Object...params) {
		try {
			for(int i=0; i<params.length; i++) {
				Object param = params[i];
				int currInx = i+1;
				if(param instanceof Integer)
					pstm.setInt(currInx, (Integer)param);
				else if(param instanceof String)
					pstm.setString(currInx, (String)param);
				else if(param instanceof Timestamp)
					pstm.setTimestamp(currInx, (Timestamp)param);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}