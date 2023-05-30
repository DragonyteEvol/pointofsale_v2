package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDatabase {

	private static Connection connection;
	
	private ConnectionDatabase() {
		super();
	}

	@SuppressWarnings("finally")
	public static Connection getConnection() {
		try {
			if(connection==null) {
				connection = DriverManager.getConnection("jdbc:mysql://172.17.0.2:3306/pos","root","1234");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			return connection;
		}
		
	}
	
}
