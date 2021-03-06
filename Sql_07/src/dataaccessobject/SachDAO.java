package dataaccessobject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Sach;

public class SachDAO implements DAOInterface<Sach>{

	public static SachDAO getInstance() {
		return new SachDAO();
	}
	
	@Override
	public int insert(Sach t) {
		int results = -1; 
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			Statement st = con.createStatement();
			//B3
			String sql = "INSERT INTO `sach` (id, tenSach, giaBan, namXuatBan) VALUES (" + "'" + t.getId() + "', '"
			+ t.getTenSach() + "', '" + t.getGiaBan() + "', '" + t.getNamXuatBan() + "');";
			results = st.executeUpdate(sql);
			//B4
			System.out.println("~sql Insert: "+sql + ", results = " + results);			
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public int update(Sach t) {
		int results = -1; 
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			Statement st = con.createStatement();
			//B3
			String sql = "UPDATE `sach`"
					+ "SET tensach='" + t.getTenSach()+"', giaBan='" + t.getGiaBan() + "', namXuatBan='" + t.getNamXuatBan()+"' "
					+ "WHERE id='"+ t.getId() + "';"; 
			results = st.executeUpdate(sql);
			//B4
			System.out.println("~sql Update: "+sql + ", results = " + results);			
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	@Override
	public int delete(Sach t) {
		int results = -1; 
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			Statement st = con.createStatement();
			//B3
			String sql = "DELETE FROM `sach`"
					+ " WHERE id='"+ t.getId() + "';"; 
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
	public ArrayList<Sach> selectAll() {
		
		ArrayList<Sach> arrSach = new ArrayList<Sach>();
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			Statement st = con.createStatement();
			//B3
			String sql = "SELECT * FROM `sach`;";
			System.out.println("~sql Query: "+sql);
			ResultSet rs = st.executeQuery(sql);
			//B4
			while (rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				int giaBan = rs.getInt("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				arrSach.add(new Sach(id, tenSach, giaBan, namXuatBan));
			}
			
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrSach;
	}

	@Override
	public Sach selectById(Sach t) {
		
		Sach sach = null;
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			Statement st = con.createStatement();
			//B3
			String sql = "SELECT * FROM `sach` WHERE id= '" + t.getId() +"';";
			System.out.println("~sql Query: "+sql);
			ResultSet rs = st.executeQuery(sql);
			//B4
			while (rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				int giaBan = rs.getInt("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				sach = new Sach(id, tenSach, giaBan, namXuatBan);
			}
			
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sach;
	}

	@Override
	public ArrayList<Sach> selectByCondition(String condition) {
		ArrayList<Sach> arrSach = new ArrayList<Sach>();
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			Statement st = con.createStatement();
			//B3
			String sql = "SELECT * FROM `sach` WHERE " + condition +";";
			System.out.println("~sql Query: "+sql);
			ResultSet rs = st.executeQuery(sql);
			//B4
			while (rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				int giaBan = rs.getInt("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				arrSach.add(new Sach(id, tenSach, giaBan, namXuatBan));
			}
			
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrSach;
	}

}
