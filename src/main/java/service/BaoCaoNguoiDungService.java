package service;

import model.BaoCaoBinhLuan;
import model.BaoCaoNguoiDung;

public class BaoCaoNguoiDungService extends DAOService<BaoCaoNguoiDung>{
	public BaoCaoNguoiDungService() {
		
	}
	public Integer insert(BaoCaoNguoiDung baoCaoNguoiDungo) {
		String sql="insert into baocaonguoidung (MaNguoiDungBaoCao, MaNguoiDungBiBaoCao, NgayGioBaoCao, LiDo)"
				+ "values (?,?,?,?)";
		return insert(sql, baoCaoNguoiDungo.getMaNguoiDungBaoCao(),baoCaoNguoiDungo.getMaNguoiDungBiBaoCao(),baoCaoNguoiDungo.getNgayGioBaoCao(),baoCaoNguoiDungo.getLiDo());
	}
}
