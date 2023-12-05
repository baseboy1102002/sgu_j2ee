package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DBContext.DBContext;
import model.BaoCaoBaiviet;
import model.BaoCaoBinhLuan;
import model.BaoCaoNguoiDung;
import model.QuanLyBaiViet;
import model.QuanLyBinhLuan;
import model.QuanLyNguoiDung;

public class AdminService {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private DBContext dbc = new DBContext();

	public List<BaoCaoBaiviet> getAllBaoCaoBaiViet() {
		List<BaoCaoBaiviet> baocaobaivietList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM BAOCAOBAIVIET"
						+ " ORDER BY mabaiviet ASC";
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int manguoidung = rs.getInt("manguoidung");
				int mabaiviet = rs.getInt("mabaiviet");
				Timestamp ngaygiobaocao = rs.getTimestamp("ngaygiobaocao");
				String lido = rs.getString("lido");
				baocaobaivietList.add(new BaoCaoBaiviet(manguoidung, mabaiviet, ngaygiobaocao, lido));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
		return baocaobaivietList;
	}

	public List<BaoCaoNguoiDung> getAllBaoCaoNguoiDung() {
		List<BaoCaoNguoiDung> baocaonguoidungList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM BAOCAONGUOIDUNG"
						+ " ORDER BY manguoidungbibaocao ASC";
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int manguoidungbaocao = rs.getInt("manguoidungbaocao");
				int manguoidungbibaocao = rs.getInt("manguoidungbibaocao");
				Timestamp ngaygiobaocao = rs.getTimestamp("ngaygiobaocao");
				String lido = rs.getString("lido");
				baocaonguoidungList.add(new BaoCaoNguoiDung(manguoidungbaocao, manguoidungbibaocao, ngaygiobaocao, lido));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
		return baocaonguoidungList;
	}

	public List<BaoCaoBinhLuan> getAllBaoCaoBinhLuan() {
		List<BaoCaoBinhLuan> baocaobinhluanList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM BAOCAOBINHLUAN"
						+ " ORDER BY mabinhluan ASC";
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int manguoidung = rs.getInt("manguoidung");
				int mabinhluan = rs.getInt("mabinhluan");
				Timestamp ngaygiobaocao = rs.getTimestamp("ngaygiobaocao");
				String lido = rs.getString("lido");
				baocaobinhluanList.add(new BaoCaoBinhLuan(manguoidung, mabinhluan, ngaygiobaocao, lido));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
		return baocaobinhluanList;
	}

	public List<QuanLyBaiViet> getAllQuanLyBaiViet() {
		List<QuanLyBaiViet> quanlybaivietList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM QUANLYBAIVIET"
						+ " ORDER BY MaBaiViet ASC";
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int maquanly = rs.getInt("maquanly");
				int mabaiviet = rs.getInt("mabaiviet");
				Timestamp ngaygiocapnhat = rs.getTimestamp("ngaygiocapnhat");
				String chitietcapnhat = rs.getString("chitietcapnhat");
				quanlybaivietList.add(new QuanLyBaiViet(maquanly, mabaiviet, ngaygiocapnhat, chitietcapnhat));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
		return quanlybaivietList;
	}

	public List<QuanLyNguoiDung> getAllQuanLyNguoiDung() {
		List<QuanLyNguoiDung> quanlynguoidungList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM QUANLYNGUOIDUNG"
						+ " ORDER BY manguoidung ASC";
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int maquanly = rs.getInt("maquanly");
				int manguoidung = rs.getInt("manguoidung");
				Timestamp ngaygiocapnhat = rs.getTimestamp("ngaygiocapnhat");
				String chitietcapnhat = rs.getString("chitietcapnhat");
				quanlynguoidungList.add(new QuanLyNguoiDung(maquanly, manguoidung, ngaygiocapnhat, chitietcapnhat));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
		return quanlynguoidungList;
	}

	public List<QuanLyBinhLuan> getAllQuanLyBinhLuan() {
		List<QuanLyBinhLuan> quanlybinhluanList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM QUANLYBINHLUAN"
						+ " ORDER BY mabinhluan ASC";
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int maquanly = rs.getInt("maquanly");
				int mabinhluan = rs.getInt("mabinhluan");
				Timestamp ngaygiocapnhat = rs.getTimestamp("ngaygiocapnhat");
				String chitietcapnhat = rs.getString("chitietcapnhat");
				quanlybinhluanList.add(new QuanLyBinhLuan(maquanly, mabinhluan, ngaygiocapnhat, chitietcapnhat));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
		return quanlybinhluanList;
	}

	public void banBaiViet(int mabaiviet, int maquanly) {
		try {
			String deleteSql = "DELETE FROM BaoCaoBaiViet WHERE MaBaiViet = ?";
	        conn = dbc.getConnection();
	        pstmt = conn.prepareStatement(deleteSql);
	        pstmt.setInt(1, mabaiviet);
	        pstmt.executeUpdate();

	        String insertSql = "INSERT INTO QuanLyBaiViet (MaQuanLy, MaBaiViet, NgayGioCapNhat, ChiTietCapNhat) VALUES (?, ?, ?, ?)";
	        pstmt = conn.prepareStatement(insertSql);
	        pstmt.setInt(1, maquanly);
	        pstmt.setInt(2, mabaiviet);

	        Date now = new Date();
	        Timestamp timestamp = new Timestamp(now.getTime());

	        pstmt.setTimestamp(3, timestamp);
	        pstmt.setString(4, "Cam bai viet");
	        pstmt.executeUpdate();

	        String updateSql = "UPDATE BaiViet SET TrangThai = 'systembanned' WHERE MaBaiViet = ?";
	        pstmt = conn.prepareStatement(updateSql);
	        pstmt.setInt(1, mabaiviet);
	        pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
	}

	public void undoBanBaiViet(int mabaiviet, int maquanly) {
		try {
	        String insertSql = "INSERT INTO QuanLyBaiViet (MaQuanLy, MaBaiViet, NgayGioCapNhat, ChiTietCapNhat) VALUES (?, ?, ?, ?)";
	        conn = dbc.getConnection();
	        pstmt = conn.prepareStatement(insertSql);
	        pstmt.setInt(1, maquanly);
	        pstmt.setInt(2, mabaiviet);

	        Date now = new Date();
	        Timestamp timestamp = new Timestamp(now.getTime());

	        pstmt.setTimestamp(3, timestamp);
	        pstmt.setString(4, "Huy cam bai viet");
	        pstmt.executeUpdate();

	        String updateSql = "UPDATE BaiViet SET TrangThai = 'yes' WHERE MaBaiViet = ?";
	        pstmt = conn.prepareStatement(updateSql);
	        pstmt.setInt(1, mabaiviet);
	        pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
	}

	public void banNguoiDung(int manguoidung, int maquanly) {
		try {
			String deleteSql = "DELETE FROM BaoCaoNguoiDung WHERE MaNguoiDungBiBaoCao = ?";
	        conn = dbc.getConnection();
	        pstmt = conn.prepareStatement(deleteSql);
	        pstmt.setInt(1, manguoidung);
	        pstmt.executeUpdate();

	        String insertSql = "INSERT INTO QuanLyNguoiDung (MaQuanLy, MaNguoiDung, NgayGioCapNhat, ChiTietCapNhat) VALUES (?, ?, ?, ?)";
	        pstmt = conn.prepareStatement(insertSql);
	        pstmt.setInt(1, maquanly);
	        pstmt.setInt(2, manguoidung);

	        Date now = new Date();
	        Timestamp timestamp = new Timestamp(now.getTime());

	        pstmt.setTimestamp(3, timestamp);
	        pstmt.setString(4, "Cam nguoi dung");
	        pstmt.executeUpdate();

	        String updateSql = "UPDATE NguoiDung SET TrangThai = 'systembanned' WHERE MaNguoiDung = ?";
	        pstmt = conn.prepareStatement(updateSql);
	        pstmt.setInt(1, manguoidung);
	        pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
	}

	public void undoBanNguoiDung(int manguoidung, int maquanly) {
		try {
	        String insertSql = "INSERT INTO QuanLyNguoiDung (MaQuanLy, MaNguoiDung, NgayGioCapNhat, ChiTietCapNhat) VALUES (?, ?, ?, ?)";
	        conn = dbc.getConnection();
	        pstmt = conn.prepareStatement(insertSql);
	        pstmt.setInt(1, maquanly);
	        pstmt.setInt(2, manguoidung);

	        Date now = new Date();
	        Timestamp timestamp = new Timestamp(now.getTime());

	        pstmt.setTimestamp(3, timestamp);
	        pstmt.setString(4, "Huy cam bai viet");
	        pstmt.executeUpdate();

	        String updateSql = "UPDATE NguoiDung SET TrangThai = 'normal' WHERE MaNguoiDung = ?";
	        pstmt = conn.prepareStatement(updateSql);
	        pstmt.setInt(1, manguoidung);
	        pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
	}

	public void banBinhLuan(int mabinhluan, int maquanly) {
		try {
			String deleteSql = "DELETE FROM BaoCaoBinhLuan WHERE MaBinhLuan = ?";
	        conn = dbc.getConnection();
	        pstmt = conn.prepareStatement(deleteSql);
	        pstmt.setInt(1, mabinhluan);
	        pstmt.executeUpdate();

	        String insertSql = "INSERT INTO QuanLyBinhLuan (MaQuanLy, MaBinhLuan, NgayGioCapNhat, ChiTietCapNhat) VALUES (?, ?, ?, ?)";
	        pstmt = conn.prepareStatement(insertSql);
	        pstmt.setInt(1, maquanly);
	        pstmt.setInt(2, mabinhluan);

	        Date now = new Date();
	        Timestamp timestamp = new Timestamp(now.getTime());

	        pstmt.setTimestamp(3, timestamp);
	        pstmt.setString(4, "Cam binh luan");
	        pstmt.executeUpdate();

	        String updateSql = "UPDATE BinhLuanBaiViet SET TrangThai = 'systembanned' WHERE MaBinhLuan = ?";
	        pstmt = conn.prepareStatement(updateSql);
	        pstmt.setInt(1, mabinhluan);
	        pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
	}

	public void undoBanBinhLuan(int mabinhluan, int maquanly) {
		try {
	        String insertSql = "INSERT INTO QuanLyBinhLuan (MaQuanLy, MaBinhLuan, NgayGioCapNhat, ChiTietCapNhat) VALUES (?, ?, ?, ?)";
	        conn = dbc.getConnection();
	        pstmt = conn.prepareStatement(insertSql);
	        pstmt.setInt(1, maquanly);
	        pstmt.setInt(2, mabinhluan);

	        Date now = new Date();
	        Timestamp timestamp = new Timestamp(now.getTime());

	        pstmt.setTimestamp(3, timestamp);
	        pstmt.setString(4, "Huy cam binh luan");
	        pstmt.executeUpdate();

	        String updateSql = "UPDATE BinhLuanBaiViet SET TrangThai = 'new' WHERE MaBinhLuan = ?";
	        pstmt = conn.prepareStatement(updateSql);
	        pstmt.setInt(1, mabinhluan);
	        pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
	}

}
