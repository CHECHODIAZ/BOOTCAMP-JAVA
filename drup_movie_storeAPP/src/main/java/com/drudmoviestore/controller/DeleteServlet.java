package com.drudmoviestore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drudmoviestore.service.MovieService;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MovieService service = new MovieService();
		if(!req.getParameter("DELETESEARCH").trim().isEmpty()) {

			try {
				service.delete(Long.parseLong(req.getParameter("DELETESEARCH")));
			} catch (NumberFormatException e) {
				req.setAttribute("ERROR", "Datos no validos");
				e.printStackTrace();
			} catch (Throwable e) {
				req.setAttribute("ERROR", "No se pudo eliminar la película");
				e.printStackTrace();
			}

		}else {
			req.setAttribute("ERROR", "Dato no valido");
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
	}

}
