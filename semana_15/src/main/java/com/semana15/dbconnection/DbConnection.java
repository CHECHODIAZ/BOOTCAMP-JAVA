package com.semana15.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbConnection {
	
	public static Connection getConections() {
		String url ="jdbc:mysql://127.0.0.1:3306/semana15?serverTimezone=UTC&userSSL=false";
		String user ="root";
		String password = "root";
		String driverName = "com.mysql.cj.jdbc.Driver";
		Connection connection = null;
		try {
			Class.forName(driverName);
			try {
				connection = DriverManager.getConnection(url, user, password);
					
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;	
	}
	public static void main(String[] args) {
		DbConnection.getConections();
		System.out.println("connection obtenida");
	}

}
