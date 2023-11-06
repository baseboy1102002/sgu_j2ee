package modelMapper;

import java.sql.ResultSet;

import model.thongbao;

public class ThongBaoMapper implements rowMapper<thongbao> {

	@Override
	public thongbao mapRow(ResultSet rs) {
		try {
			thongbao Thongbao = new thongbao();
			Thongbao.setUsersPost("HoVaTen");
			BaiVietMapper bvMapper = new BaiVietMapper();
			Thongbao.setBaiviet(bvMapper.mapRow(rs));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
