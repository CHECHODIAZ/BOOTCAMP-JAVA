package com.drudmoviestore.movie.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.drudmoviestore.dao.MovieDao;
import com.drudmoviestore.dao.jdbc.MovieDBConnection;
import com.drudmoviestore.entity.Movie;


public class MovieDaoImpl<T> implements MovieDao{


	public Map<Long,List<Object>> findBySQL(String whereSQL) throws Throwable {

		//connection
		Connection conx = MovieDBConnection.getConnection();

		Statement pre = conx.createStatement();
		ResultSet resp = pre.executeQuery(whereSQL);
		Movie movie = new Movie();
		Map<Long,List<Object>> mapMovie = new HashMap<Long,List<Object>>();
		while(resp.next()) {
			movie.setName(resp.getString("name"));
			movie.setGender(resp.getString("gender"));
			movie.setDirector(resp.getString("director"));
			movie.setSummary(resp.getString("summary"));
			movie.setId(resp.getLong("id"));

			List<Object> give = new ArrayList();
			give.add(movie.getName());
			give.add(movie.getGender());
			give.add(movie.getDirector());
			give.add(movie.getSummary());

			mapMovie.put(movie.getId(),give);

			System.out.println();
		}


		return mapMovie;

	}

	public List<Object> getOne(Long id) throws Throwable {
		if(id == null) {
			throw new Exception("we have no an id to look up for it");
		}

		List<Object> entity = null;

		String sql  = "SELECT * FROM MOVIES WHERE ID = " + id;

		Map<Long,List<Object>> list = this.findBySQL(sql);

		if(!list.isEmpty()) {
			entity = list.get(id);
		}

		return entity;

	}


	public List<Object> getByWord(String words) throws Throwable {
		if(words == null) {
			throw new Exception("we have no an id to look up for it");
		}

		List<Object> entity = null;

		String sql  = "SELECT * FROM PUBLIC.movies WHERE UPPER(name) iLIKE '"+words.toUpperCase()+"' OR UPPER(gender) ILIKE '"+words.toUpperCase()+"' OR UPPER(director) ILIKE '"+words.toUpperCase()+"'";

		Map<Long,List<Object>> list = this.findBySQL(sql);

		if(!list.isEmpty()) {
			for (Map.Entry<Long,List<Object>> entry : list.entrySet()) {
				if(entry.getValue().contains(words)) {
					entity=entry.getValue();
				}
			}

		}

		return entity;	

	}


	public void delete(Long id) throws Throwable {
		if(id == null) {
			throw new Exception("This id is NULL");
		}

		String sql = "DELETE FROM MOVIES WHERE id =? ";

		//connection
		try (Connection con = MovieDBConnection.getConnection()) {

			try (PreparedStatement st = con.prepareStatement(sql)) {

				st.setLong(1, id);

				st.executeUpdate();
			}
		}catch (Exception e) {			
			throw new Exception("we can not delete it:" +sql, e);
		}


	}


	public Object save(Movie entity) throws Throwable {
		String sql = "INSERT INTO movies (name , gender , director , summary) VALUES ('"
				+ entity.getName() + "','" + entity.getGender() + "','"
				+ entity.getDirector() + "','" + entity.getSummary() + "')";

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


	public void update(Movie entity, Long id) throws Throwable {
		// UPDATE TABLA SET CAMPO1 =?, CAMPO2=?, CAMPON=? WHERE ID = ?
		entity.setId(id);
		String sql = "UPDATE MOVIES SET name='"+entity.getName()+"', gender='"+entity.getGender()+"', director='"+entity.getDirector()+"', summary='"+entity.getSummary()+"' WHERE id = "+entity.getId();

		try (Connection con = MovieDBConnection.getConnection();) {

			try (PreparedStatement st = con.prepareStatement(sql)) {

				st.execute();
			}
		}catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException) {
				throw new Exception("we can not update, data already exist: " + sql, e);
			}
			throw new Exception("we can not update:" +sql, e);
		}

	}


	public Map<Long,List<Object>> findAll() throws Throwable{

		String sql  = "SELECT * FROM MOVIES";
		Map<Long, List<Object>> list = null;
		try {
			list = this.findBySQL(sql);
		} catch (Throwable e) {
			throw new Exception("we can not insert:" +sql, e);
		}
		return list;
	}


}
