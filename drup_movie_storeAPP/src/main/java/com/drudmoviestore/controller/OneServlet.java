package com.drudmoviestore.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drudmoviestore.service.MovieService;

@WebServlet("/OneServlet")
public class OneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MovieService service = new MovieService();
		List<Object> dataId;

		if(!req.getParameter("SPECIALSEARCH").trim().isEmpty()) {
			try {
				dataId = (List<Object>) service.findById(Long.parseLong(req.getParameter("SPECIALSEARCH")));
				req.setAttribute("SPECIALSEARCH", dataId);
				getServletContext().getRequestDispatcher("/tablaeliminar.jsp").forward(req, resp);
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
