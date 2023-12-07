package service;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

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

	public Boolean deleteFileBaiViet(List<Integer> ListMaFile, List<String> ListTenFile , HttpServletRequest req) {
		if (ListMaFile.size()>1) {
			String sql = String.format("delete from filebaiviet where MaFile in (%s)",
					ListMaFile.stream()
                    .map(v -> "?")
                    .collect(Collectors.joining(", ")));
			for (String fileName: ListTenFile) {
				File filetoDelete = new File(req.getServletContext().getRealPath("/files/"+fileName));
				filetoDelete.delete();
			}
			return update(sql, ListMaFile.toArray(Integer[]::new));
		} else {
			String sql = "delete from filebaiviet where MaFile = ?";
			return update(sql, ListMaFile.get(0));
		}
	}

	public Boolean deleteFileBaiVietByMaBaiViet(int MaBaiViet, HttpServletRequest req) {
		String sql = "delete from filebaiviet where MaBaiViet = ?";
		List<String> deleteFileNames = getAllFileTenFileBaiViet(MaBaiViet);
		for (String fileName: deleteFileNames) {
			File filetoDelete = new File(req.getServletContext().getRealPath("/files/"+fileName));
			filetoDelete.delete();
		}
		return update(sql, MaBaiViet);
	}

	public List<String> getAllFileTenFileBaiViet(int MaBaiViet) {
		String sql = "select * from filebaiviet where MaBaiViet = ?";
		List<FileBaiViet> listBaiViet = query(sql, new FileBaiVietMapper(), MaBaiViet);
		return listBaiViet.stream().map(e -> e.getTenFile()).toList();
	}

}
