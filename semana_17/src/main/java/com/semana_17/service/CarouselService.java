package com.semana_17.service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import com.semana_17.dao.CarouselDao;
import com.semana_17.entity.Carousel;

public class CarouselService {
	
	public Collection<List<Object>> carouselUP() throws Throwable {
		CarouselDao carouselUP = new CarouselDao();
		Collection<List<Object>> carousel = carouselUP.FindAll();
		return carousel;
	}

public void delete(Integer idInteger) throws Exception {
	CarouselDao carrusel = new CarouselDao();
	carrusel.delete(idInteger);
	
}

public Carousel getOne(Integer id) throws SQLException {
	CarouselDao carrusel = new CarouselDao();
	Carousel c = new Carousel();
	c = carrusel.getOne(id);
	return c;
}

public void update(Carousel carousel, Integer id) throws Throwable {
	CarouselDao carrusel = new CarouselDao();
	carrusel.update(carousel, id);
	
}

public static void main(String args[]) throws Throwable {
	
	CarouselService re =new CarouselService();
	System.out.println(re.carouselUP());
	
}

}
