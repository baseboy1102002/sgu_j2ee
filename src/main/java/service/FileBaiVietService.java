package service;

import java.util.List;

import model.FileBaiViet;
import modelMapper.FileBaiVietMapper;

public class FileBaiVietService extends DAOService<FileBaiViet> {

	public FileBaiVietService() {


	}

	public List<FileBaiViet> getFileBaiVietsByMaBaiViet(int maBaiViet){
		String sql = "Select * From filebaiviet where MaBaiViet = ?";
		return query(sql, new FileBaiVietMapper(), maBaiViet);
	}

	public int saveFileBaiViet(FileBaiViet file) {
		String sql = "insert into filebaiviet (TenFile, LoaiFile, MaBaiViet, TrangThai) values (?, ?, ?, ?)";
		return insert(sql, file.getTenFile(), file.getLoaiFile(), file.getMaBaiViet(), file.getTrangThai());
	}

	public Boolean deleteFileBaiViet(int MaFile) {
		String sql = "delete from filebaiviet where MaFile = ?";
		return update(sql, MaFile);
	}

	public Boolean deleteAllFileBaiViet(int MaBaiViet) {
		String sql = "delete from filebaiviet where MaBaiViet = ?";
		return update(sql, MaBaiViet);
	}

}
