package com.semana_17.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.semana_17.DBconnection.CarouselDBConnection;
import com.semana_17.entity.Carousel;

public class CarouselDao {
	
	public Collection<List<Object>> FindAll() throws Throwable{
	    
		String sql = "SELECT * FROM carousel";
		Connection conx = CarouselDBConnection.getConnection();
		PreparedStatement pre = conx.prepareStatement(sql);
		ResultSet result = pre.executeQuery();
		Carousel carousel = new Carousel();
		
		Collection<List<Object>> colec = new ArrayList();
		
		while(result.next()) {
			List<Object> lis = new ArrayList();
			carousel.setId(result.getInt("id"));
			carousel.setDescripcion(result.getString("Descripcion"));
			carousel.setImagen(result.getString("imagen"));
			carousel.setActive(result.getInt("active"));
			
			//System.out.println(carousel.getDescripcion());
			//System.out.println(result.getString("Descripcion"));
			lis.add(carousel.getActive());
			lis.add(carousel.getImagen());
			lis.add(carousel.getDescripcion());
			lis.add(carousel.getId());
			colec.add(lis);
		}
		try {
			conx.close();
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return colec;
	}

	public void delete(Integer idInteger) throws Exception {
		String sql2 = "SELECT count(*) FROM carousel WHERE id ="+idInteger;
		Connection conxi = CarouselDBConnection.getConnection();
		PreparedStatement prep = conxi.prepareStatement(sql2);
		ResultSet result = prep.executeQuery();
		if(result.next()) {
			if (result.getInt(1) > 0) {
				String sql = "DELETE FROM carousel WHERE id =?";
				Connection conx = CarouselDBConnection.getConnection();
				PreparedStatement pre = conx.prepareStatement(sql);
				pre.setLong(1, idInteger);
				pre.executeUpdate();
				System.out.println("BORRADO");
			}else {
				throw new Exception("No se encontro Id");
			}
		}
	}

	public Carousel getOne(Integer id) throws SQLException {
		
		String sql2 = "SELECT * FROM carousel WHERE id ="+id;
		Connection conx = CarouselDBConnection.getConnection();
		PreparedStatement prep = conx.prepareStatement(sql2);
		ResultSet result = prep.executeQuery();
		Carousel car = new Carousel();
		while(result.next()) {
			car.setImagen(result.getString("imagen"));
			car.setDescripcion(result.getString("descripcion"));
			car.setActive(result.getInt("active"));
			car.setId(result.getInt("id"));
		}
		return car;
	}
	
	public void update(Carousel entity, Integer id) throws Throwable {
		// UPDATE TABLA SET CAMPO1 =?, CAMPO2=?, CAMPON=? WHERE ID = ?
		entity.setId(id);
		String sql = "UPDATE carousel SET descripcion='"+entity.getDescripcion()+"', imagen='"+entity.getImagen()+"', active='"+entity.getActive()+"' WHERE id = "+entity.getId();

		try (Connection con = CarouselDBConnection.getConnection();) {

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

	
public static void main(String[] args) throws Throwable {
		
		CarouselDao re =new CarouselDao();
		Collection<List<Object>> list = re.FindAll();
		for(List<Object> obj : list) {
			obj.get(0);
			obj.get(1);
			obj.get(2);
			System.out.println(obj.get(0));
			System.out.println(obj.get(1));
			System.out.println(obj.get(2));
		}
		//re.delete(1);
		System.out.println(re.getOne(11).getImagen());
		
	}

}
