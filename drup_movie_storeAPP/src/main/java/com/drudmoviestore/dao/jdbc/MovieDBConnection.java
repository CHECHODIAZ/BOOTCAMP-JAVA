package com.drudmoviestore.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MovieDBConnection {
	
	public static Connection getConnection() {
		
		String url ="jdbc:postgresql://ec2-52-54-212-232.compute-1.amazonaws.com:5432/dd4m283uvn4d9b?serverTimezone=UTC&userSSL=false";
		String user ="kygpwpubecdjel";
		String password = "d884ca8f605fb98c5af23a0b071939c0e9fd60aecc549d96895e0aae362a7220";
		String driverName = "org.postgresql.Driver";
		Connection connection = null;
		try {
			Class.forName(driverName);
			try {
				connection = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	

}