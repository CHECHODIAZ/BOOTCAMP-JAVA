package com.semana_16.service;

import java.util.Collection;
import java.util.List;

import com.semana_16.dao.CarouselDao;
import com.semana_16.entity.Carousel;

public class CarouselService {
	
	public Collection<List<Object>> carouselUP() throws Throwable {
		CarouselDao carouselUP = new CarouselDao();
		Collection<List<Object>> carousel = carouselUP.FindAll();
		return carousel;
	}
	
 public static void main(String args[]) throws Throwable {
		
		CarouselService re =new CarouselService();
		System.out.println(re.carouselUP());
		
	}

}
