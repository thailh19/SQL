package test;

import java.sql.Connection;

import database.JDBCUtil;

public class Test {

	public static void main(String[] args) {
		Connection c = JDBCUtil.initConnection();
		JDBCUtil.printInfor(c);
		JDBCUtil.closeConnection(c);
	}

}
