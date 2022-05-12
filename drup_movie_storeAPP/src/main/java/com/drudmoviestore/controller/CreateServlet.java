package com.drudmoviestore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drudmoviestore.entity.Movie;
import com.drudmoviestore.service.MovieService;

@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
     
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MovieService service = new MovieService();
		Movie movie = null;

		String name = req.getParameter("NAME");
		String gender = req.getParameter("GENDER");
		String director = req.getParameter("DIRECTOR");
		String summary = req.getParameter("SUMMARY");

		movie = new Movie(name,gender,director,summary);
		if(!name.isEmpty() || !gender.isEmpty() || !director.isEmpty()) {
			try {
				service.create(movie);
				req.setAttribute("OK", "Material creado con exito!");
				req.getRequestDispatcher("/ok.jsp").forward(req, resp);
			} catch (Throwable e) {
				req.setAttribute("ERROR", "No se creo película");
				req.getRequestDispatcher("/home.jsp").forward(req, resp);
				e.printStackTrace();
			}

		}else {
			req.setAttribute("ERROR", "Datos no validos");
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
	}

}
