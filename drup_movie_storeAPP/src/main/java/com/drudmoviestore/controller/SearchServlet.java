package com.drudmoviestore.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drudmoviestore.service.MovieService;

@WebServlet("/MovieSearchServlet")
public class SearchServlet extends HttpServlet {


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MovieService service = new MovieService();
		if(!req.getParameter("SEARCH").trim().isEmpty()) {
			try {
				@SuppressWarnings("unchecked")
				List<Object> dataWord = (List<Object>) service.findByWord(req.getParameter("SEARCH"));
				req.setAttribute("SEARCH", dataWord);
				getServletContext().getRequestDispatcher("/tablageneral.jsp").forward(req, resp);

			} catch (Throwable e) {
				req.setAttribute("ERROR", "Datos no validos");
				req.getRequestDispatcher("/home.jsp").forward(req, resp);
				e.printStackTrace();
			}

		}else {
			req.setAttribute("ERROR", "Dato no valido");
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
		
	}
}

