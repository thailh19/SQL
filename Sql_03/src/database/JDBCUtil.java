package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JDBCUtil {
	
	public static Connection initConnection () {
		Connection c = null;
		/*
		com.mysql.jdbc.Driver driver;
		try {
			System.out.println("---");
			driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
		} catch (SQLException e1) {
			System.out.println("------");
			e1.printStackTrace();
		} */
		
		String url = "jdbc:mySQL://localhost:3306/mydata";
		String username = "root";
		String password = "";
		
		try {
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (SQLException e) {
			System.out.println("close err");
		}
	}
	
	public static void printInfor (Connection c) {
		try {
			DatabaseMetaData mtdt = c.getMetaData();
			System.out.println(mtdt.getDatabaseProductName());
			System.out.println(mtdt.getDatabaseProductVersion());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
