package model;

public class FileBaiViet {
private int maFile;
private String tenFile;
private String loaiFile;
private int maBaiViet;
private String trangThai;



public FileBaiViet() {
	super();
}



public FileBaiViet(int maFile, String tenFile, String loaiFile, int maBaiViet, String trangThai) {
	super();
	this.maFile = maFile;
	this.tenFile = tenFile;
	this.loaiFile = loaiFile;
	this.maBaiViet = maBaiViet;
	this.trangThai = trangThai;
}



public int getMaFile() {
	return maFile;
}



public void setMaFile(int maFile) {
	this.maFile = maFile;
}



public String getTenFile() {
	return tenFile;
}



public void setTenFile(String tenFile) {
	this.tenFile = tenFile;
}



public String getLoaiFile() {
	return loaiFile;
}



public void setLoaiFile(String loaiFile) {
	this.loaiFile = loaiFile;
}



public int getMaBaiViet() {
	return maBaiViet;
}



public void setMaBaiViet(int maBaiViet) {
	this.maBaiViet = maBaiViet;
}



public String getTrangThai() {
	return trangThai;
}



public void setTrangThai(String trangThai) {
	this.trangThai = trangThai;
}



@Override
public String toString() {
	return "FileBaiViet [maFile=" + maFile + ", tenFile=" + tenFile + ", loaiFile=" + loaiFile + ", maBaiViet="
			+ maBaiViet + ", trangThai=" + trangThai + "]";
}




}
