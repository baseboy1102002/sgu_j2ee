package modelMapper;

import java.sql.ResultSet;

import model.ThongBao;

public class ThongBaoMapper implements rowMapper<ThongBao> {

	@Override
	public ThongBao mapRow(ResultSet rs) {
		try {
			ThongBao Thongbao = new ThongBao();
			Thongbao.setUsersPost(rs.getString("HoVaTen"));
			BaiVietMapper bvMapper = new BaiVietMapper();
			Thongbao.setBaiviet(bvMapper.mapRow(rs));
			return Thongbao;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
