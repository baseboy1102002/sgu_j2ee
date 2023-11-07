package modelMapper;

import java.sql.ResultSet;

import model.thongbao;

public class ThongBaoMapper implements rowMapper<thongbao> {

	@Override
	public thongbao mapRow(ResultSet rs) {
		try {
			thongbao Thongbao = new thongbao();
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
