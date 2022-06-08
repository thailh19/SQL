package model;

public class Sach {
	private String id, tenSach;
	private int giaBan;
	private int namXuatBan;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public int getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}
	public int getNamXuatBan() {
		return namXuatBan;
	}
	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	public Sach() {
		super();
	}
	public Sach(String id, String tenSach, int giaBan, int namXuatBan) {
		super();
		this.id = id;
		this.tenSach = tenSach;
		this.giaBan = giaBan;
		this.namXuatBan = namXuatBan;
	}
	@Override
	public String toString() {
		return "Sach [id=" + id + ", tenSach=" + tenSach + ", giaBan=" + giaBan + ", namXuatBan=" + namXuatBan + "]";
	}
	
	
}
