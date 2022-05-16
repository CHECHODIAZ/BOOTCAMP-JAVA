package com.semana_17.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semana_17.service.CarouselService;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  CarouselService service = new CarouselService();
		  try {
			//req.setAttribute("CAROUSEL", service.carouselUP());
			req.getSession().setAttribute("CAROUSEL", service.carouselUP());;
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		  //getServletContext().getRequestDispatcher("index.jsp").forward(req, resp);
		  req.getRequestDispatcher("/list_img.jsp").forward(req, resp);
		  
	}

	public static void main(String[] args) throws Throwable {
		
		CarouselService service = new CarouselService();
		System.out.println(service.carouselUP());
		
		
	}

}
