package com.semana_17.Servlet;

import java.io.IOException;
import java.sql.SQLException;
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

@WebServlet("/ActualizarServlet")
public class ActualizarServlet extends HttpServlet {
   
	 private CarouselService service = new CarouselService();
	 private Carousel carousel = new Carousel();
	
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
		
		//datos a actualizar
		String imagen = req.getParameter("url");
		String descripcion = req.getParameter("descripcion");
		
		Collection<List<Object>> carouselInSession = (Collection<List<Object>>)req.getSession().getAttribute("CAROUSEL");
		try {
			//Carousel carousel = null;
			try {
				carousel = this.service.getOne(Integer.parseInt(id));
			} catch (NumberFormatException e1) {
				
				e1.printStackTrace();
			} catch (SQLException e1) {
			
				e1.printStackTrace();
			}
			carousel.setImagen(imagen);
			carousel.setDescripcion(descripcion);
			try {
				this.service.update(carousel,Integer.parseInt(id));
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			} catch (Throwable e) {
				
				e.printStackTrace();
			}
			
			//viejo articulo en sesion
			carouselInSession = carouselInSession.stream()
					.filter(x -> !x.get(3).equals(carousel.getId()))
					.collect(Collectors.toList());
			carouselInSession.add((List<Object>) carousel);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			req.getSession().setAttribute("CAROUSEL", carouselInSession);
			req.getRequestDispatcher("/list_img.jsp").forward(req, resp);
		}
    }		
    	
}
    
