package com.semana15.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semana15.service.ServiceImpl;
import com.semana15.service.Servicepersona;


@WebServlet("/DatosServlet")
public class DatosServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Servicepersona consul = new ServiceImpl();
		try {
			Map<Long,List<Object>> respuesta = consul.mostrarregistros();
			req.setAttribute("MAPA", respuesta);
			getServletContext().getRequestDispatcher("/datos.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
