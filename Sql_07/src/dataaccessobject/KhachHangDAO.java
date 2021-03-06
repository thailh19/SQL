package dataaccessobject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.KhachHang;
import model.Sach;

public class KhachHangDAO implements DAOInterface<KhachHang>{

	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}
	
	@Override
	public int insert(KhachHang t) {
		int results = -1; 
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			Statement st = con.createStatement();
			//B3
			String sql = "INSERT INTO `khachhang` (id, hoVaTen, ngaySinh, diaChi) VALUES (" + "'" + t.getId() + "', '"
			+ t.getHoVaTen() + "', '" + t.getNgaySinh() + "', '" + t.getDiaChi() + "');";
			results = st.executeUpdate(sql);
			//B4
			System.out.println("~sql Insert: "+sql + ", results = " + results);			
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public int update(KhachHang t) {
		int results = -1; 
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			Statement st = con.createStatement();
			//B3
			String sql = "UPDATE `khachhang`"
					+ "SET hoVaTen='" + t.getHoVaTen()+"', ngaySinh='" + t.getNgaySinh() + "', diaChi='" + t.getDiaChi()+"' "
					+ "WHERE id='"+ t.getId() + "';"; 
			results = st.executeUpdate(sql);
			//B4
			System.out.println("~sql Insert: "+sql + ", results = " + results);			
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public int delete(KhachHang t) {
		int results = -1; 
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			Statement st = con.createStatement();
			//B3
			String sql = "DELETE FROM `khachhang`"
					+ "WHERE id='"+ t.getId() + "';"; 
			results = st.executeUpdate(sql);
			//B4
			System.out.println("~sql Delete: "+sql + ", results = " + results);			
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> arrKhachHang = new ArrayList<KhachHang>();
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			Statement st = con.createStatement();
			//B3
			String sql = "SELECT * FROM `khachhang`;";
			System.out.println("~sql Query: "+sql);
			ResultSet rs = st.executeQuery(sql);
			//B4
			while (rs.next()) {
				String id = rs.getString("id");
				String hoVaTen = rs.getString("hoVaTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");
				arrKhachHang.add(new KhachHang(id, hoVaTen, ngaySinh, diaChi));
			}
			
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrKhachHang;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		KhachHang khachHang = null;
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			Statement st = con.createStatement();
			//B3
			String sql = "SELECT * FROM `khachhang` WHERE id= '" + t.getId() +"';";
			System.out.println("~sql Query: "+sql);
			ResultSet rs = st.executeQuery(sql);
			//B4
			while (rs.next()) {
				String id = rs.getString("id");
				String hoVaTen = rs.getString("hoVaTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");
				khachHang = new KhachHang(id, hoVaTen, ngaySinh, diaChi);
			}
			
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return khachHang;
	}

	@Override
	public ArrayList<KhachHang> selectByCondition(String condition) {

		ArrayList<KhachHang> khachHang = new ArrayList<KhachHang>();
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			Statement st = con.createStatement();
			//B3
			String sql = "SELECT * FROM `khachhang` WHERE " + condition +";";
			System.out.println("~sql Query: "+sql);
			ResultSet rs = st.executeQuery(sql);
			//B4
			while (rs.next()) {
				String id = rs.getString("id");
				String hoVaTen = rs.getString("hoVaTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");
				khachHang.add(new KhachHang(id, hoVaTen, ngaySinh, diaChi));
			}
			
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return khachHang;
	}

}
