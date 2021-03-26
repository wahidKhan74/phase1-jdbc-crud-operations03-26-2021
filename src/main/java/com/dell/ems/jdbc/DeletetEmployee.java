package com.dell.ems.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletetEmployee {
	
	static Connection conn = null;
	static Statement stm = null;
	
	public static void main(String[] args) throws SQLException {
		

		try {
			// 1. get connection 
			conn = DatabaseConnection.initConnection();
			// 2. create statment
			stm = conn.createStatement();
			
			// 3. execute delete query 
			String query = "delete from employee "+
					"where id=6 ";
			
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
