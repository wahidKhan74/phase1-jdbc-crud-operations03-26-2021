package com.dell.ems.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadEmployee {
	
	static Connection conn = null;
	static Statement stm = null;
	static ResultSet rst = null;
	
	public static void main(String[] args) {
		
		try {
			// 1. get connection 
			conn = DatabaseConnection.initConnection();
			// 2. create statment
			stm = conn.createStatement();
			// 3. execute query 
			String query = "select * from employee";
			rst = stm.executeQuery(query);			
			// 4. print resultset
			printData(rst);
		} catch (Exception e) {
			
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
