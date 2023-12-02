package service;

import model.BaoCaoBaiviet;
import model.BaoCaoBinhLuan;

public class BaoCaoBinhLuanService extends DAOService<BaoCaoBinhLuan> {
	
	public BaoCaoBinhLuanService () {
		
	}

	public Integer insert(BaoCaoBinhLuan baoCaoBinhLuan) {

		String sql="insert into baocaobinhluan (MaNguoiDung, MaBinhLuan,NgayGioBaoCao,LiDo)"
				+ "values (?,?,?,?)";
		return insert(sql, baoCaoBinhLuan.getMaNguoiDung(),baoCaoBinhLuan.getMaBinhLuan(),baoCaoBinhLuan.getNgayGioBaoCao(),baoCaoBinhLuan.getLiDo());
	}
	
}
