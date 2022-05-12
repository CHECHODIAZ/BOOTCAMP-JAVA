package com.drudmoviestore.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drudmoviestore.DTO.api.MovieDTO;
import com.drudmoviestore.service.MovieService;

@WebServlet("/peliculasinfantiles")
public class ChildMovieServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MovieService service = new MovieService();
		List<MovieDTO> dataList;
		try {
			dataList = service.findList();
			req.setAttribute("CHILDMOVIE", dataList);
			getServletContext().getRequestDispatcher("/peliculas_infantiles.jsp").forward(req, resp);
		} catch (Throwable e) {
			req.setAttribute("ERROR", "No se generaron registros");
		    req.getRequestDispatcher("/home.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}
    
}
