package dataaccessobject;

import java.util.ArrayList;

import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang>{

	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}
	
	@Override
	public int insert(KhachHang t) {
		return 0;
	}

	@Override
	public int update(KhachHang t) {
		return 0;
	}

	@Override
	public int delete(KhachHang t) {
		return 0;
	}

	@Override
	public ArrayList<KhachHang> selectAll() {
		return null;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		return null;
	}

	@Override
	public ArrayList<KhachHang> selectByCondition(String condition) {
		return null;
	}

}
