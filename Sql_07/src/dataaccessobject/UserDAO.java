package dataaccessobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.User;
import test.TestUserDAO;

public class UserDAO implements DAOInterface<User>{
	
	public static UserDAO getInstance() {
		return new UserDAO();
	}
	
	@Override
	public int insert(User t) {
		int results = -1; 
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			String sql = "INSERT INTO `user` (username, password, name) VALUES (?,?,?);";
			PreparedStatement pst = con.prepareStatement(sql);
			//B3
			pst.setString(1, t.getUsername());
			pst.setString(2, t.getPassword());
			pst.setString(3, t.getName());
			results = pst.executeUpdate();
			//B4
//			System.out.println("~sql Insert: "+sql + ", results = " + results);			
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			System.out.println("insert~"+t.getUsername()+"~"+t.getPassword()+"~"+t.getName());
			TestUserDAO.insertFail ++;
			e.printStackTrace();
		}
		return results;
	}
	//insert2 data with Statement JDBC
	public int insert2(User t) {
		int results = -1; 
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			Statement st = con.createStatement();
			//B3
			String sql = "INSERT INTO `user` (username, password, name) "
					+ "VALUES ('"+ t.getUsername() + "', '" + t.getPassword() + "', '" + t.getName() + "');";
			results = st.executeUpdate(sql);
			//B4
//			System.out.println("~sql Insert: "+sql + ", results = " + results);			
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			System.out.println("insert2~"+t.getUsername()+"~"+t.getPassword()+"~"+t.getName());
			TestUserDAO.insert2Fail ++;
			e.printStackTrace();
		}
		return results;
	}
	
	
	@Override
	public int update(User t) {
		int results = -1; 
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			String sql = "UPDATE `User`"
					+ "SET username=?, password=?, name=?"
					+ "WHERE username=?;"; 
			PreparedStatement pst = con.prepareStatement(sql);
			//B3
			pst.setString(1, t.getUsername());
			pst.setString(2, t.getPassword());
			pst.setString(3, t.getName());
			pst.setString(4, t.getUsername());
			results = pst.executeUpdate();
			//B4
//			System.out.println("~sql Update: "+sql + ", results = " + results);			
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			System.out.println("update~"+t.getUsername()+"~"+t.getPassword()+"~"+t.getName());
			TestUserDAO.updateFail ++;
			e.printStackTrace();
		}
		return results;
	}
	// update2 with Statement JDBC
	public int update2(User t) {
		int results = -1; 
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			
			Statement st = con.createStatement();
			//B3
			String sql = "UPDATE `User`"
					+ "SET username='" + t.getUsername() + "', password='" + t.getPassword() + "', name='" + t.getName() + "' "
					+ "WHERE username='" + t.getUsername() + "';" ; 
			results = st.executeUpdate(sql);
			//B4
//			System.out.println("~sql Update: "+sql + ", results = " + results);			
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			System.out.println("update2~"+t.getUsername()+"~"+t.getPassword()+"~"+t.getName());
			TestUserDAO.update2Fail ++;
			e.printStackTrace();
		}
		return results;
	}
	

	@Override
	public int delete(User t) {
		int results = -1; 
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			String sql = "DELETE FROM `User` WHERE username=?;"; 
			PreparedStatement pst = con.prepareStatement(sql);
			//B3
			pst.setString(1, t.getUsername());
			results = pst.executeUpdate();
			//B4
//			System.out.println("~sql Delete: "+sql + ", results = " + results);			
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			System.out.println("delete~"+t.getUsername()+"~"+t.getPassword()+"~"+t.getName());
			TestUserDAO.deleteFail ++;
			e.printStackTrace();
		}
		return results;
	}
	// delete2 with Statement JDBC
	public int delete2(User t) {
		int results = -1; 
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			
			Statement st = con.createStatement();
			//B3
			String sql = "DELETE FROM `User` WHERE username='" + t.getUsername() + "';"; 
			results = st.executeUpdate(sql);
			//B4
//			System.out.println("~sql Delete: "+sql + ", results = " + results);			
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			System.out.println("delete2~"+t.getUsername()+"~"+t.getPassword()+"~"+t.getName());
			TestUserDAO.delete2Fail ++;
			e.printStackTrace();
		}
		return results;
	}
	
	
	@Override
	public ArrayList<User> selectAll() {
		
		ArrayList<User> arrUser = new ArrayList<User>();
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			String sql = "SELECT * FROM `User`;";
			PreparedStatement pst = con.prepareStatement(sql);
			//B3
			ResultSet rs = pst.executeQuery();
			//B4
//			System.out.println("~sql Query: "+sql);
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				arrUser.add(new User(username, password, name));
			}
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrUser;
	}
	// selectAll2 with Statement JDBC
	public ArrayList<User> selectAll2() {
		
		ArrayList<User> arrUser = new ArrayList<User>();
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			
			Statement st = con.createStatement();
			//B3
			String sql = "SELECT * FROM `User`;";
			ResultSet rs = st.executeQuery(sql);
			//B4
//			System.out.println("~sql Query: "+sql);
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				arrUser.add(new User(username, password, name));
			}
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrUser;
	}


	@Override
	public User selectById(User t) {
		
		User user = null;
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			String sql = "SELECT * FROM `User` WHERE username= ?;";
			PreparedStatement pst = con.prepareStatement(sql);
			//B3
			pst.setString(1, t.getUsername());
			ResultSet rs = pst.executeQuery();
			//B4
//			System.out.println("~sql Query: "+sql);
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				user = new User(username, password, name);
			}
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	// selectById2 with Statement JDBC
	public User selectById2(User t) {
		User user = null;
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			Statement st = con.createStatement();
			//B3
			String sql = "SELECT * FROM `User` WHERE username= '" + t.getUsername() + "';";
			ResultSet rs = st.executeQuery(sql);
			//B4
//			System.out.println("~sql Query: "+sql);
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				user = new User(username, password, name);
			}
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public ArrayList<User> selectByCondition(String condition) {
		ArrayList<User> arrUser = new ArrayList<User>();
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			String sql = "SELECT * FROM `User` WHERE ?;";
			PreparedStatement pst = con.prepareStatement(sql);
			//B3
			pst.setString(1, condition);
			ResultSet rs = pst.executeQuery();
			//B4
//			System.out.println("~sql Query: "+sql);
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				arrUser.add(new User(username, password, name));
			}
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrUser;
	}
	// selectByCondition2 with Statement JDBC
	public ArrayList<User> selectByCondition2(String condition) {
		ArrayList<User> arrUser = new ArrayList<User>();
		try {
			//B1
			Connection con = JDBCUtil.initConnection();
			//B2
			Statement st = con.createStatement();
			//B3
			String sql = "SELECT * FROM `User` WHERE " + condition + ";";
			ResultSet rs = st.executeQuery(sql);
			//B4
//			System.out.println("~sql Query: "+sql);
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				arrUser.add(new User(username, password, name));
			}
			//B5
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrUser;
	}

}
