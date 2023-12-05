package service;

import model.BaoCaoBaiviet;

public class BaoCaoBaiVietService extends DAOService<BaoCaoBaiviet> {

	public BaoCaoBaiVietService() {

	}

	public Integer insert(BaoCaoBaiviet baoCaoBaiviet) {

		String sql="insert into baocaobaiviet (MaNguoiDung, MaBaiViet,NgayGioBaoCao,LiDo)"
				+ "values (?,?,?,?)";
		return insert(sql, baoCaoBaiviet.getMaNguoiDung(),baoCaoBaiviet.getMaBaiViet(),baoCaoBaiviet.getNgayGioBaoCao(),baoCaoBaiviet.getLiDo());
	}
}
