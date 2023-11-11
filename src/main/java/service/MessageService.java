package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import DBContext.DBContext;
import model.ModelPair;
import model.NguoiDung;
import model.TinNhan;

public class MessageService {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private DBContext dbc = new DBContext();

	public List<NguoiDung> getAllSortedBanBeByID(int userid, int userfocusid) {
		List<NguoiDung> listndsorted = new ArrayList<>();
		List<NguoiDung> listndunsorted = getAllBanBeByID(userid);

		if (userfocusid != 0) {
			NguoiDung userWithFocus = null;
			List<NguoiDung> otherUsers = new ArrayList<>();

			for (NguoiDung user : listndunsorted) {
				if (user.getMaNguoiDung() == userfocusid) {
					userWithFocus = user;
				} else {
					otherUsers.add(user);
				}
			}

			if (userWithFocus != null) {
				listndsorted.add(userWithFocus);
			}
			listndsorted.addAll(getSortedBanBeWithNewestMessage(userid, otherUsers));
		} else {
			listndsorted = getSortedBanBeWithNewestMessage(userid, listndunsorted);
		}

		return listndsorted;
	}

	public List<NguoiDung> getSortedBanBeWithNewestMessage(int userId0, List<NguoiDung> userList) {
		List<LocalDateTime> newestMessageTimes = getNewestMessageTimes(userId0, userList);

		List<ModelPair<NguoiDung, LocalDateTime>> userTimeModelPairs = new ArrayList<>();
		for (int i = 0; i < userList.size(); i++) {
			userTimeModelPairs.add(new ModelPair<>(userList.get(i), newestMessageTimes.get(i)));
		}

		userTimeModelPairs.sort((ModelPair1, ModelPair2) -> {
			LocalDateTime time1 = ModelPair1.getValue();
			LocalDateTime time2 = ModelPair2.getValue();
			if (time1 != null && time2 != null) {
				return time2.compareTo(time1);
			} else if (time1 == null) {
				return -1;
			} else {
				return 1;
			}
		});

		List<NguoiDung> sortedNguoiDungList = userTimeModelPairs.stream().map(ModelPair::getKey)
				.collect(Collectors.toList());

		return sortedNguoiDungList;
	}

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
				if (manguoidung == id)
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

	public List<LocalDateTime> getNewestMessageTimes(int userId0, List<NguoiDung> userList) {
		List<LocalDateTime> newestMessageTimes = new ArrayList<>();
		try {
			conn = dbc.getConnection();
			for (NguoiDung user : userList) {
				int userId = user.getMaNguoiDung();
				String sql = "SELECT MAX(ngaygiogui) AS max_ngaygiogui " + "FROM TinNhan "
						+ "WHERE (manguoigui = ? AND manguoinhan = ?) OR (manguoigui = ? AND manguoinhan = ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, userId);
				pstmt.setInt(2, userId0);
				pstmt.setInt(3, userId0);
				pstmt.setInt(4, userId);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					try {
						LocalDateTime maxNgayGui = rs.getTimestamp("max_ngaygiogui").toLocalDateTime();
						newestMessageTimes.add(maxNgayGui);
					} catch (NullPointerException e) {
						newestMessageTimes.add(LocalDateTime.of(1000, 1, 1, 0, 0)); // A distant future date
					}

				} else {
					newestMessageTimes.add(LocalDateTime.of(1000, 1, 1, 0, 0));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}

		return newestMessageTimes;
	}

	public NguoiDung getNguoiDungFocus(int id) {
		NguoiDung nd = new NguoiDung();
		try {
			String sql = "SELECT manguoidung, hovaten, hinhdaidien, trangthai " + "FROM NguoiDung "
					+ "WHERE manguoidung=?";
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int manguoidung = rs.getInt("manguoidung");
				String hovaten = rs.getString("hovaten");
				String hinhdaidien = rs.getString("hinhdaidien");
				String trangthai = rs.getString("trangthai");
				nd = new NguoiDung(manguoidung, hovaten, hinhdaidien, trangthai);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
		return nd;
	}

	public List<TinNhan> getAllTinNhanById(int userid1, int userid2) {
		List<TinNhan> listtn = new ArrayList<>();

		try {
			String sql = "SELECT *" + "FROM tinnhan"
					+ " WHERE (manguoigui = ? AND manguoinhan = ?) OR (manguoigui = ? AND manguoinhan = ?)"
					+ " ORDER BY ngaygiogui";
			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userid1);
			pstmt.setInt(2, userid2);
			pstmt.setInt(3, userid2);
			pstmt.setInt(4, userid1);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int matinnhan = rs.getInt("matinnhan");
				int manguoigui = rs.getInt("manguoigui");
				int manguoinhan = rs.getInt("manguoinhan");
				String noidung = rs.getString("noidung");
				Timestamp ngaygiogui = rs.getTimestamp("ngaygiogui");
				String trangthai = rs.getString("trangthai");
				TinNhan tn = new TinNhan(matinnhan, manguoinhan, manguoigui, noidung, ngaygiogui, trangthai);

				listtn.add(tn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}

		return listtn;
	}

	public void GuiTinNhan(int useridgui, int useridnhan, String noidung) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Date ngaygiogui = new Date(Calendar.getInstance().getTime().getTime());
			Timestamp timestamp = new Timestamp(ngaygiogui.getTime());
			String trangthai = "binhthuong";

			String sql = "INSERT INTO TinNhan (manguoigui, manguoinhan, noidung, ngaygiogui, trangthai)"
					+ " VALUES (?, ?, ?, ?, ?)";

			conn = dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, useridgui);
			pstmt.setInt(2, useridnhan);
			pstmt.setString(3, noidung);
			pstmt.setTimestamp(4, timestamp);
			pstmt.setString(5, trangthai);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
	}

}
