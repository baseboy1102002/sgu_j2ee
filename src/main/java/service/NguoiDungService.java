package service;

import java.util.List;

import model.NguoiDung;
import modelMapper.NguoiDungMapper;





import model.NguoiDung;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBContext.DBContext;
import controller.web.EmailSender;
import controller.web.SessionManager;

public class NguoiDungService extends DAOService<NguoiDung>{
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private DBContext dbc = new DBContext();
	private int rowsInserted = 0;

	public NguoiDung DangNhap(String email, String password) {
		try {
			String sql = "SELECT * FROM nguoidung WHERE Email = ? AND MatKhau = ?";
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// User exists, create and return a NguoiDung object
				return new NguoiDung(rs.getInt("MaNguoiDung"), rs.getString("Email"), rs.getString("HoVaTen"),
						rs.getString("MaQR"), rs.getString("HinhDaiDien"), rs.getString("SoDienThoai"),
						rs.getDate("NgaySinh"), rs.getString("LoaiTaiKhoan"), rs.getString("MaXacNhan"),
						rs.getString("MatKhau"), rs.getString("TrangThai"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close resources in a finally block
			closeResources(conn, pstmt, rs);
		}
		return null; // Return null if no user found
	}

	public NguoiDung DangKi(String email, String password, String name, String confirmCode) {
		try {
			String sql = "INSERT INTO nguoidung (Email, HoVaTen, MaXacNhan, MatKhau, MaQR, SoDienThoai, HinhDaiDien, NgaySinh, LoaiTaiKhoan, TrangThai, TenTaiKhoan) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, name);
			pstmt.setString(3, confirmCode);
			pstmt.setString(4, password);
			pstmt.setString(5, " ");
			pstmt.setString(6, " ");
			pstmt.setString(7, "user.png");
			
			Date now = new Date(1); 
			pstmt.setDate(8, now);
			
			pstmt.setString(9, "user");
			pstmt.setString(10, "online");
			pstmt.setString(11, " ");
			rowsInserted = pstmt.executeUpdate();
			if (rowsInserted > 0) {
				// User exists, create and return a NguoiDung object
				return new NguoiDung(getID(email), email, name, " ", "user.png", " ", now, 
						"user", confirmCode, password, " ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close resources in a finally block
			closeResources(conn, pstmt, rs);
		}
		return null; // Return null if no user found
	}
	public boolean XacNhanTaiKhoan(String email, String confirmCode) {
		try {
			String sql = "UPDATE nguoidung SET MaXacNhan = 'confirmed!' WHERE MaXacNhan = ? AND Email = ?";
			
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, confirmCode);
			pstmt.setString(2, email);
			rowsInserted = pstmt.executeUpdate();
			if (rowsInserted > 0) {
				// User exists, create and return a NguoiDung object
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close resources in a finally block
			closeResources(conn, pstmt, rs);
		}
		return false; // Return null if no user found
	}

	public boolean KiemTraTaiKhoanTonTai(String email) {
		try {
			String sql = "SELECT * FROM nguoidung WHERE Email = ?";
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close resources in a finally block
			closeResources(conn, pstmt, rs);
		}
		return false;
	}
	
	public boolean DoiMatKhau(String email, String password, String name) {
		try {
			String sql = "UPDATE nguoidung SET MatKhau = ? WHERE Email = ?";
			
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, email);
			rowsInserted = pstmt.executeUpdate();
			if (rowsInserted > 0) {
				EmailSender.sendChangedPassword(email, name, password);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close resources in a finally block
			closeResources(conn, pstmt, rs);
		}
		return false; // Return null if no user found
	}
	
	public int getID(String email) {
		try {
			String sql = "SELECT * FROM nguoidung WHERE Email = ?";
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// User exists, create and return a NguoiDung object
				return rs.getInt("MaNguoiDung");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close resources in a finally block
			closeResources(conn, pstmt, rs);
		}
		return 0; // Return null if no user found
	}
	
	public int getMaXacNhan(String email) {
		try {
			String sql = "SELECT * FROM nguoidung WHERE Email = ?";
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// User exists, create and return a NguoiDung object
				return rs.getInt("MaXacNhan");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close resources in a finally block
			closeResources(conn, pstmt, rs);
		}
		return 0; // Return null if no user found
	}
	public boolean QuenMatKhau(String email) {
		try {
			String sql = "SELECT * FROM nguoidung WHERE Email = ?";
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				EmailSender.sendForgetPassword(email, rs.getString("HoVaTen"), rs.getString("MatKhau"));
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close resources in a finally block
			closeResources(conn, pstmt, rs);
		}
		return false; // Return null if no user found
	}
	public boolean CaiDat(String email, String img, String name, String phone, String Strdob, int id) {
		java.sql.Date dob = java.sql.Date.valueOf(Strdob);
		try {
			String sql = "UPDATE nguoidung SET HoVaTen = ?, Email = ?, NgaySinh = ?, SoDienThoai = ?, HinhDaiDien = ? WHERE MaNguoiDung = ?";
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setDate(3, dob);
			pstmt.setString(4, phone);
			pstmt.setString(5, img);
			pstmt.setInt(6, id);
			rowsInserted = pstmt.executeUpdate();
			if (rowsInserted > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close resources in a finally block
			closeResources(conn, pstmt, rs);
		}
		return false; // Return null if no user found
	}
	// Utility method to close database resources
	private static void closeResources(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public NguoiDung getNguoiDungById(int maNguoiDung) {
		String sql = "select * from nguoidung where MaNguoiDung =?";
		List<NguoiDung> nguoiDungs = query(sql, new NguoiDungMapper(), maNguoiDung);

		return nguoiDungs.isEmpty() ? null : nguoiDungs.get(0);

	}
}
