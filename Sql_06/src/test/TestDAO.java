package test;

import dataaccessobject.SachDAO;
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
		
		for (int i = 0; i < 1000; i++) {
			Sach s = new Sach("MSTQN"+i, "", 0, 0);
			SachDAO.getInstance().delete(s);
		}
		
	}

}
