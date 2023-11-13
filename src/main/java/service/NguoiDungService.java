package service;

import java.util.List;

import model.NguoiDung;
import modelMapper.NguoiDungMapper;

public class NguoiDungService extends DAOService<NguoiDung>{
	
	public NguoiDungService() {
		
	}
	
	public NguoiDung getNguoiDungById(int maNguoiDung) {
		String sql = "select * from nguoidung where MaNguoiDung =?";
		List<NguoiDung> nguoiDungs = query(sql, new NguoiDungMapper(), maNguoiDung);
		System.out.println(nguoiDungs.get(0));
		System.out.println(nguoiDungs);
		return nguoiDungs.isEmpty() ? null : nguoiDungs.get(0);
		
	}
	
}
