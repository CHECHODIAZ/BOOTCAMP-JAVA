package com.drudmoviestore.movie.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.drudmoviestore.dao.UserDao;
import com.drudmoviestore.dao.jdbc.MovieDBConnection;
import com.drudmoviestore.entity.User;

public class UserDaoImpl implements UserDao {

	
	public Object save(User entity) throws Throwable {
		String sql = "INSERT INTO usrs (name , usr , pass , country,ocupation) VALUES ('"
				+ entity.getName() + "','" + entity.getUser() + "','"
				+ entity.getPassword() + "','" + entity.getCountry() + "','" + entity.getOcupation() + "')";
				
				try (Connection con = MovieDBConnection.getConnection();) {

					try (PreparedStatement st = con.prepareStatement(sql)) {
						
						st.execute();
						
						try (ResultSet res = st.getGeneratedKeys()) {
							
							if(res.next()) {
								
								Long lastGeneratedId = res.getLong(1);
								
								entity.setId(lastGeneratedId);
							}
						}
					}
				}catch (Exception e) {			
					throw new Exception("we can not insert:" +sql, e);
				}
				
		 return entity;
	}


	public Object getUserByUserNameAndPassword(String us, String pass) throws Throwable {
		String sql  = "SELECT * FROM usrs WHERE UPPER(usr) = '" + us.toUpperCase()+ "' AND pass ='"+pass+"'";
		String entity = null;
		User use = null;

		try (Connection con = MovieDBConnection.getConnection();) {

			try (Statement st = con.createStatement()) {

				try (ResultSet res = st.executeQuery(sql)) {
					
					if(res != null && res.next()) {
					entity = res.getString("name");	
					String pas = res.getString("pass");
					String usr = res.getString("usr");
					use = new User(usr,pas);
					}
				}
			}
		}catch (Exception e) {			
			throw new Exception("No se pudo consultar:" +sql, e);
		}

		return entity;
		
	}
	 
	public static void main(String[] args) throws Throwable {
		UserDaoImpl r = new UserDaoImpl();
		User p = new User();
		r.getUserByUserNameAndPassword("pepe", "pepe");
		System.out.println(p.getPassword());
	}
}
