package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DBContext.DBContext;
import model.NguoiDung;
import model.ThongTinKetBan;

public class FriendService {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private DBContext dbc = new DBContext();

	public List<NguoiDung> getAllBanBeByID(int id) {
		List<NguoiDung> nguoiDungList = new ArrayList<>();
		try {
			String sql = "SELECT NguoiDung.manguoidung, NguoiDung.hovaten, NguoiDung.hinhdaidien "
					+ "FROM ThongTinKetBan " + "INNER JOIN NguoiDung ON "
					+ "(ThongTinKetBan.manguoidung1 = NguoiDung.manguoidung OR "
					+ "ThongTinKetBan.manguoidung2 = NguoiDung.manguoidung) "
					+ "WHERE (ThongTinKetBan.manguoidung1 = ? OR " + "ThongTinKetBan.manguoidung2 = ?) AND "
					+ "ThongTinKetBan.trangthai = 'daketban'";
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int manguoidung = rs.getInt("manguoidung");
				if(manguoidung == id)
					continue;
				String hovaten = rs.getString("hovaten");
				String hinhdaidien = rs.getString("hinhdaidien");
				NguoiDung nguoiDung = new NguoiDung(manguoidung, hovaten, hinhdaidien);
				nguoiDungList.add(nguoiDung);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
		return nguoiDungList;
	}

	// loi moi cua nguoi khac
	public List<NguoiDung> getAllLoiMoiKetBanByID(int id) {
		List<NguoiDung> nguoiDungList = new ArrayList<>();

		try {
			String sql = "SELECT NguoiDung.manguoidung, NguoiDung.hovaten, NguoiDung.hinhdaidien "
					+ "FROM ThongTinKetBan "
					+ "INNER JOIN NguoiDung ON ThongTinKetBan.manguoidung1 = NguoiDung.manguoidung "
					+ "WHERE ThongTinKetBan.manguoidung2 = ? AND ThongTinKetBan.trangthai = 'chochapnhan'";
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int manguoidung = rs.getInt("manguoidung");
				String hovaten = rs.getString("hovaten");
				String hinhdaidien = rs.getString("hinhdaidien");
				NguoiDung nguoiDung = new NguoiDung(manguoidung, hovaten, hinhdaidien);
				nguoiDungList.add(nguoiDung);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
		return nguoiDungList;
	}

	// loi moi cua minh
	public List<NguoiDung> getAllLoiMoiCuaBanByID(int id) {
		List<NguoiDung> nguoiDungList = new ArrayList<>();
		try {
			String sql = "SELECT NguoiDung.manguoidung, NguoiDung.hovaten, NguoiDung.hinhdaidien "
					+ "FROM ThongTinKetBan "
					+ "INNER JOIN NguoiDung ON ThongTinKetBan.manguoidung2 = NguoiDung.manguoidung "
					+ "WHERE ThongTinKetBan.manguoidung1 = ? AND ThongTinKetBan.trangthai = 'chochapnhan'";
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int manguoidung = rs.getInt("manguoidung");
				String hovaten = rs.getString("hovaten");
				String hinhdaidien = rs.getString("hinhdaidien");
				NguoiDung nguoiDung = new NguoiDung(manguoidung, hovaten, hinhdaidien);
				nguoiDungList.add(nguoiDung);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
		return nguoiDungList;
	}

	public List<NguoiDung> getAllChanByID(int id) {
		List<NguoiDung> nguoiDungList = new ArrayList<>();
		try {
			String sql = "SELECT NguoiDung.manguoidung, NguoiDung.hovaten, NguoiDung.hinhdaidien "
					+ "FROM ThongTinKetBan "
					+ "INNER JOIN NguoiDung ON ThongTinKetBan.manguoidung2 = NguoiDung.manguoidung "
					+ "WHERE ThongTinKetBan.manguoidung1 = ? AND ThongTinKetBan.trangthai = 'chan'";
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int manguoidung = rs.getInt("manguoidung");
				String hovaten = rs.getString("hovaten");
				String hinhdaidien = rs.getString("hinhdaidien");

				NguoiDung nguoiDung = new NguoiDung(manguoidung, hovaten, hinhdaidien);
				nguoiDungList.add(nguoiDung);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
		return nguoiDungList;
	}

}
