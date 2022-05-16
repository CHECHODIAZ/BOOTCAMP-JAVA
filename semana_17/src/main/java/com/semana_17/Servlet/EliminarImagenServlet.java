package com.semana_17.Servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.protobuf.ServiceException;
import com.semana_17.entity.Carousel;
import com.semana_17.service.CarouselService;

@WebServlet("/EliminarImagenServlet")
public class EliminarImagenServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");

		Integer idInteger = Integer.parseInt(id);

		Collection<List<Object>> imgInSession = (Collection<List<Object>>)req.getSession().getAttribute("CAROUSEL");			

		//logica de este servlet?
		CarouselService service = new CarouselService ();
		try {
			service.delete(idInteger);
			//el mensaje
			req.setAttribute("ELIMINDADO","Se ha eliminado el articulo id= "+idInteger);

			imgInSession = imgInSession.stream().filter(x -> !x.get(3).equals(idInteger)).collect(Collectors.toList());
		} catch (Exception e) {
			req.setAttribute("ERROR","no se ha eliminado el articulo id= "+idInteger+" "+e.getMessage() );
		}finally {
			req.getSession().setAttribute("CAROUSEL", imgInSession);
			req.getRequestDispatcher("/list_img.jsp").forward(req, resp);
		}
	}

}
