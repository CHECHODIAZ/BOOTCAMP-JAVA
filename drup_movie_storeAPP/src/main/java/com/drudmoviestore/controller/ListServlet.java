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

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MovieService service = new MovieService();
		Map<Long, List<Object>> dataList;
		try {
			dataList = (Map<Long, List<Object>>) service.FindList();
			req.setAttribute("SEARCHLIST", dataList);
			getServletContext().getRequestDispatcher("/tablalista.jsp").forward(req, resp);
		} catch (Throwable e) {
			req.setAttribute("ERROR", "No se generaron registros");
		    req.getRequestDispatcher("/home.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}

}
