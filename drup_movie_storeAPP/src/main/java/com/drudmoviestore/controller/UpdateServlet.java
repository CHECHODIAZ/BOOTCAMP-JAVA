package com.drudmoviestore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drudmoviestore.entity.Movie;
import com.drudmoviestore.service.MovieService;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MovieService service = new MovieService();
		Movie movie = null;

		String name = req.getParameter("NAMEUP");
		String gender = req.getParameter("GENDERUP");
		String director = req.getParameter("DIRECTORUP");
		String summary = req.getParameter("SUMMARYUP");
		Long id = Long.parseLong(req.getParameter("IDUP"));

		movie = new Movie(name,gender,director,summary);
		if(!name.isEmpty() || !gender.isEmpty() || !director.isEmpty()) {
			try {
				service.update(movie, id);
				req.setAttribute("OK", "Material actualizado con exito!");
				req.getRequestDispatcher("/ok.jsp").forward(req, resp);
			} catch (Throwable e) {
				req.setAttribute("ERROR", "No se actualizaron los datos");
				e.printStackTrace();
			}
		}else {
			req.setAttribute("ERROR", "Datos no validos");
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
	}   

}
