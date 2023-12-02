package service;

import java.util.List;

import model.BaoCaoBinhLuan;
import model.BaoCaoNguoiDung;
import modelMapper.BaoCaoNguoiDungMapper;
import modelMapper.rowMapper;

public class BaoCaoNguoiDungService extends DAOService<BaoCaoNguoiDung>{
	public BaoCaoNguoiDungService() {
		
	}
	public Integer insert(BaoCaoNguoiDung baoCaoNguoiDungo) {
		String sql="insert into baocaonguoidung (MaNguoiDungBaoCao, MaNguoiDungBiBaoCao, NgayGioBaoCao, LiDo)"
				+ "values (?,?,?,?)";
		return insert(sql, baoCaoNguoiDungo.getMaNguoiDungBaoCao(),baoCaoNguoiDungo.getMaNguoiDungBiBaoCao(),baoCaoNguoiDungo.getNgayGioBaoCao(),baoCaoNguoiDungo.getLiDo());
	}
	public boolean getBaoCaoNguoiDung(int MaNguoiDungBaoCao, int MaNguoiDungBiBaoCao) {
		String sql = "SELECT * FROM baocaonguoidung WHERE MaNguoiDungBaoCao = ? AND MaNguoiDungBiBaoCao = ?";
		List<BaoCaoNguoiDung> baoCaoNguoiDung = query(sql, new BaoCaoNguoiDungMapper(), MaNguoiDungBaoCao, MaNguoiDungBiBaoCao);
		return baoCaoNguoiDung.isEmpty() ? false : true;
	}
}
