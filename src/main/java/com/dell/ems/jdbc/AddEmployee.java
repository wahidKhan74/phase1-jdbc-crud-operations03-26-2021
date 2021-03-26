package com.dell.ems.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddEmployee {
	
	static Connection conn = null;
	static Statement stm = null;
	
	public static void main(String[] args) throws SQLException {
		

		try {
			// 1. get connection 
			conn = DatabaseConnection.initConnection();
			// 2. create statment
			stm = conn.createStatement();
			// 3. execute query 
			String query = "insert into employee"
					+"(full_name,email,dept, salary) "+
					"values ('Ravi Kiran','ravi.kiran@gmail.com','Engineering',1975000.23)";
			
			int rowAffected = stm.executeUpdate(query);			
			
			if(rowAffected>0)
				System.out.println(" No of Rows Affected "+rowAffected);
		} catch (Exception e) {
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

}
