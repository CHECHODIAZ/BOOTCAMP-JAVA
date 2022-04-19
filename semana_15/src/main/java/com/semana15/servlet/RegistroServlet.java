package com.semana15.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semana15.service.ServiceImpl;
import com.semana15.service.Servicepersona;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		List<Object> listareq = new ArrayList<Object>();
		
		Long doc = Long.parseLong(req.getParameter("documento"));
		String nom = req.getParameter("nombre");
		String ape = req.getParameter("apellido");
		Long edad = Long.parseLong(req.getParameter("edad"));
		Date fn = null;
		java.time.LocalDate nDate = null;
		
		try {
			fn = formato.parse(req.getParameter("fechaNacimiento"));
			 java.util.Date nfn = fn;
			    nDate = new java.sql.Date(nfn.getTime()).toLocalDate();
		} catch (ParseException e1) {
			req.setAttribute("ERROR", "PROBLEMAS AL INGRESAR LOS DATOS");
		    req.getRequestDispatcher("/error.jsp").forward(req, resp);
			e1.printStackTrace();
		}
		String ocup = req.getParameter("ocupacion");
		Servicepersona persona = new ServiceImpl();
		
		listareq.add(doc);
		listareq.add(nom);
		listareq.add(ape);
		listareq.add(edad);
		listareq.add(fn);
		listareq.add(ocup);
		Iterator<Object> dats = listareq.iterator();
		
		if(dats.next().equals(null)) {
			req.setAttribute("ERROR", "PROBLEMAS AL INGRESAR LOS DATOS");
		    req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
		if(dats.next() != null) {
		try {
			persona.agregarregistro(doc, nom, ape, edad, nDate, ocup);
			resp.getWriter().print("Usuario insertado exitosamente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	    
	}

}
