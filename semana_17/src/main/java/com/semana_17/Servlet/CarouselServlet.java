package com.semana_17.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semana_17.entity.Carousel;
import com.semana_17.service.CarouselService;

@WebServlet("/servlet")
public class CarouselServlet extends HttpServlet{
	
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  CarouselService service = new CarouselService();
	  try {
		req.setAttribute("CAROUSEL", service.carouselUP());
		
	} catch (Throwable e) {
		e.printStackTrace();
	}
	  //getServletContext().getRequestDispatcher("index.jsp").forward(req, resp);
	  req.getRequestDispatcher("/index.jsp").forward(req, resp);
}

public static void main(String[] args) throws Throwable {
	
	CarouselService service = new CarouselService();
	System.out.println(service.carouselUP());
	
	
}

}


