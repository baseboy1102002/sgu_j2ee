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
	
}
