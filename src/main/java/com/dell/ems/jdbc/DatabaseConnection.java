package com.dell.ems.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	// data-source properties
	static final String DBURL = "jdbc:mysql://localhost:3306/ems_system";
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";

	public static Connection initConnection() {
		
		Connection conn = null;
		try {
			// 1. registering jdbc driver
			Class.forName(JDBC_DRIVER);
			// 2. get connection
			conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
			if(conn != null)
				System.out.println("-- DB Connection / Query execution Successfull ! ---");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("-- DB Connection Failure --");
			e.printStackTrace();
		}
		return conn;

		
	}
}
