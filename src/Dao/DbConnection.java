package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static void main(String[] args) {
		
		
	}	
	
	public static Connection getDB() {
		Connection conn=null;
		
		String url="jdbc:mysql://localhost:3306/adoption";
		String user="root";
		String password= "1234";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =DriverManager.getConnection(url, user, password);
				
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
