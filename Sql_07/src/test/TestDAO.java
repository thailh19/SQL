package test;

import java.sql.Date;
import java.util.ArrayList;

import dataaccessobject.KhachHangDAO;
import dataaccessobject.SachDAO;
import model.KhachHang;
import model.Sach;

public class TestDAO {

	public static void main(String[] args) {
		/*Sach sach = new Sach("001", "Harry Porter Chapter 01", 150000, 2011);
		SachDAO sachDao = SachDAO.getInstance();
		sachDao.insert(sach);
		for (int i = 0; i < 1000; i++) {
			Sach s = new Sach("MSTQN"+i, "Mao Sơn Tróc Quỷ Nhân - Chapter" + i, 55000, 2019);
			SachDAO.getInstance().insert(s);
		} */
		
		
		/*Sach sach = new Sach("002", "Toan Roi Rac Quyen 2", 120000, 2016);
		SachDAO.getInstance().update(sach);
		*/
		/*
		for (int i = 0; i < 1000; i++) {
			Sach s = new Sach("MSTQN"+i, "", 0, 0);
			SachDAO.getInstance().delete(s);
		} */
		
		/*Date date = new Date(1980 - 1900, 10, 30);
		KhachHang kh = new KhachHang("tuyet.dt80", "Đào Thị Tuyết", date, "08 - Hàng Bài - Ba Đình - Hà Nội");
		KhachHangDAO.getInstance().insert(kh);
		
		KhachHang kh2 = new KhachHang("tuyet.dt80", "Đào Thị Tuyết", date, "08 - Hàng Bài - Hà Nội");
		KhachHangDAO.getInstance().update(kh2);*/
		
		/*ArrayList<Sach> sach = SachDAO.getInstance().selectAll(); */
		/*ArrayList<Sach> sach = SachDAO.getInstance().selectByCondition("giaBan>= '110000'");
		
		for (Sach sach2 : sach) {
			System.out.println(sach2.toString());
		} */
		
		/*Sach sach2 = SachDAO.getInstance().selectById(new Sach("002","", 0,0));
		System.out.println(sach2);*/
		
		ArrayList<KhachHang> khachHang = KhachHangDAO.getInstance().selectAll();
		for (KhachHang khachHang2 : khachHang) {
			System.out.println(khachHang2.toString());
		}
		
		KhachHang kh = new KhachHang();
		kh.setId("tuyet.dt80");
		KhachHang khachHang2 = KhachHangDAO.getInstance().selectById(kh);
		System.out.println(khachHang2);
		
		
		ArrayList<KhachHang> khachHang1 = KhachHangDAO.getInstance().selectByCondition("ngaySinh< '1980-01-01'");
		
		for (KhachHang khachHang11 : khachHang1) {
			System.out.println(khachHang11.toString());
		}
		
	}

}
