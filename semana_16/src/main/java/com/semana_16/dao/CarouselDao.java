package com.semana_16.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.semana_16.DBconnection.CarouselDBConnection;
import com.semana_16.entity.Carousel;

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
		
	}

}
