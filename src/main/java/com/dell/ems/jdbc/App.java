package com.dell.ems.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
	// data-source properties
	static final String DBURL ="jdbc:mysql://localhost:3306/ems_system";
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String USERNAME = "root";
	static final String PASSWORD = "root";
	
    public static void main( String[] args ) throws SQLException {
    	
    	Connection conn = null;
    	Statement stm = null;
    	ResultSet rst = null;
    	
    	try {
    		// 1. registering jdbc driver
			Class.forName(JDBC_DRIVER);
			
			// 2. get connection
			conn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
			
			// 3. create jdbc statement
			stm = conn.createStatement();
			
			// 4. execute (eg : select query )
			String query = "select * from employee";
			rst = stm.executeQuery(query);
			
			// 5. print resultset
			printData(rst);
			
			if(conn != null)
				System.out.println("-- DB Connection / Query execution Successfull ! ---");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("-- DB Connection Failure --");
			e.printStackTrace();
		} finally {
			//clean up
			// 5. close connection
			if(stm != null)
				stm.close();
			if(conn != null)
				conn.close();
		}
    }
    
    private static void printData(ResultSet rst) throws SQLException {
    	while(rst.next()) {
    		System.out.println("-------------");
    		System.out.println("Id : "+rst.getInt("id") + " , Name  : "+rst.getString("full_name") 
    		+ " , Email : "+rst.getString("email") +  " , Salary : "+rst.getDouble("salary") + " , Dept : "+rst.getString("dept"));
    	}
    }
}
