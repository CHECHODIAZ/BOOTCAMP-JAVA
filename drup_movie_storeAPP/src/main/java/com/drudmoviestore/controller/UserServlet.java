package com.drudmoviestore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.drudmoviestore.service.UserService;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String usernameFromHtml = req.getParameter("USER");
			String passwordFromHtml = req.getParameter("PASSWORD");
			
			if(isValid(usernameFromHtml, passwordFromHtml)) {
			
				UserService ls = new UserService();
				Object user = null;
				
				try {
					try {
						user = ls.getUserByUserNameAndPassword(usernameFromHtml,passwordFromHtml);
					} catch (Throwable e) {
						req.setAttribute("ERROR", "No fue posible validar informacion, intente nuevamente");
						req.getRequestDispatcher("/error.jsp").forward(req, resp);	
						e.printStackTrace();
					}
				
					if(user == null) {
						req.setAttribute("ERROR", "Usiario no encontrado, verifique sus datos");
						req.getRequestDispatcher("/error.jsp").forward(req, resp);				
					}else {
						//session
						req.setAttribute("OKSESSION", user);
						req.getRequestDispatcher("/home.jsp").forward(req, resp);
						req.getSession().setAttribute("OKSESSION", user);
						
					}
				} catch (Exception e) {			
					req.setAttribute("ERROR", e.getMessage());
					req.getRequestDispatcher("/error.jsp").forward(req, resp);
					
				}
			}else {
				req.setAttribute("ERROR", "Datos invalidos");
				req.getRequestDispatcher("/error.jsp").forward(req, resp);
			}
			
		}

		protected boolean isValid(String usernameFromHtml, String passwordFromHtml) {
			return (usernameFromHtml !=null && !usernameFromHtml.isBlank()) 
					&&
					(passwordFromHtml !=null && !passwordFromHtml.isBlank());
		}

}
