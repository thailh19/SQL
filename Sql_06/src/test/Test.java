package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;

public class Test {

	public static void main(String[] args) {
		//Step1: create connection
		// currently this connection to "nhasach" database
		// At Step3, sql command execute with "mydata" database so it will fail ...
		Connection c = JDBCUtil.initConnection();
		
		JDBCUtil.printInfor(c);
		
		try {
			//Step2: create statement
			
			Statement st = c.createStatement();
			
			//Step3: run SQL command
			String sqlCmd = "INSERT INTO `nguoidung` (`username`, `password`, `email`, `maGiangVien`, `maSinhVien`) "
					+ "VALUES (\"thu.phuong\", \"abc\", \"thphuong.tran80@gmail.com\", \"05\", NULL);";
			String sqlCmd2 = "UPDATE `sinhvien` SET `hoDem` = 'Hoa', ten = 'Phuong' WHERE `maSinhVien` = \"005\"; ";
			int check = st.executeUpdate(sqlCmd2);
			
			//Step4: process some results from B3
			if(check == 0) {
				System.out.println("cap nhat that bai");
			}
			else {
				System.out.println("cap nhat thanh cong, so dong du lieu " + check);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//Step5: close connection
		JDBCUtil.closeConnection(c);
	}

}
