package clase2repasoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexxionDB {
	static String db = "protalento";
	static String login = "root";
	static String password = "";
	static String url = "jdbc:mysql://localhost/"+db;
	
	Connection conn = null;
	

	public ConexxionDB() {
		try {	
			conn = DriverManager.getConnection(url, login, password);
			if(conn != null) {
				System.out.println("contectado con la base de datos"+db);
			}
		} catch (SQLException e) {
			System.out.println("SQLExeption");
			e.printStackTrace();
		} 
		
	}
	
	public static void main(String[] args) {
		ConexxionDB miConexion = new ConexxionDB();
	}
	public Connection getconexion() {
		return conn;
		
	}
	
	
	
	
		/*try {
		conn = DriverManager.getConnection(url, login, password);
		if (conn != null) {
			System.out.println("conectado a la base de datos");
		}
		
	} cath (SQLException e){
		System.out.println("SQLException"+e);
		e.printStackTrace();
	} cath (Exception e){
		System.out.println("Exception"+e);
		e.printStackTrace();
	}
	
}*/

}
