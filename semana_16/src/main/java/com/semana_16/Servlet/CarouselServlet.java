package com.semana_16.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semana_16.entity.Carousel;
import com.semana_16.service.CarouselService;

@WebServlet("/servlet")
public class CarouselServlet extends HttpServlet{
	
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  CarouselService service = new CarouselService();
	  try {
		req.setAttribute("CAROUSEL", service.carouselUP());
		
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  //getServletContext().getRequestDispatcher("index.jsp").forward(req, resp);
	  req.getRequestDispatcher("/index.jsp").forward(req, resp);
}

	

}