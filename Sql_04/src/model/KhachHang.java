package model;

import java.sql.Date;

public class KhachHang {
	private String hoVaTen, id;
	private Date ngaySinh;
	private String diaChi;
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public KhachHang() {
		super();
	}
	public KhachHang(String hoVaTen, String id, Date ngaySinh, String diaChi) {
		super();
		this.hoVaTen = hoVaTen;
		this.id = id;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
	}
	
	
	
	
	
	
}
