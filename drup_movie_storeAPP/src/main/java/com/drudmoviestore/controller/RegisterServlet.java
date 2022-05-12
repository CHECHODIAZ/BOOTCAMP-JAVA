package com.drudmoviestore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drudmoviestore.entity.User;
import com.drudmoviestore.service.UserService;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
    
	
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserService service = new UserService();
		User user = null;

		String name = req.getParameter("NAME");
		String usr = req.getParameter("USER");
		String pass = req.getParameter("PASS");
		String country = req.getParameter("COUNTRY");
		String ocupation = req.getParameter("OCUPATION");

		user = new User(name,usr,pass,country,ocupation);
		if(!name.isEmpty() || !usr.isEmpty() || !pass.isEmpty()) {
			try {
				service.createUser(user);
				req.setAttribute("OK", "Usuario Registrado con exito!");
				req.getRequestDispatcher("/ok.jsp").forward(req,resp);
			} catch (Throwable e) {
				req.setAttribute("ERROR", "No fue posible registrar Usuario");
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
				e.printStackTrace();
			}

		}else {
			req.setAttribute("ERROR", "Datos no validos");
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
	}
}
