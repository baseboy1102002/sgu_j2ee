package model;

public class FileTinNhan {
    private int maFile;
    private String tenFile;
    private String loaiFile;
    private int maTinNhan;

    public FileTinNhan() {
        // Initialize default values if needed
    }

    public FileTinNhan(int maFile, String tenFile, String loaiFile, int maTinNhan) {
        this.maFile = maFile;
        this.tenFile = tenFile;
        this.loaiFile = loaiFile;
        this.maTinNhan = maTinNhan;
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

    public int getMaTinNhan() {
        return maTinNhan;
    }

    public void setMaTinNhan(int maTinNhan) {
        this.maTinNhan = maTinNhan;
    }

    @Override
    public String toString() {
        return "FileTinNhan{" +
                "maFile=" + maFile +
                ", tenFile='" + tenFile + '\'' +
                ", loaiFile='" + loaiFile + '\'' +
                ", maTinNhan=" + maTinNhan +
                '}';
    }
}
