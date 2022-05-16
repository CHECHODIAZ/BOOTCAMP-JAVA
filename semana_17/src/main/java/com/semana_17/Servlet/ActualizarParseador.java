package com.semana_17.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.ServiceException;
import com.semana_17.entity.Carousel;
import com.semana_17.service.CarouselService;

@WebServlet("/ActualizarParseado")
public class ActualizarParseador extends HttpServlet{
	
	
	private CarouselService service = new CarouselService();
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//tomar id que viene por req
		String id = req.getParameter("id");
		
		Carousel carousel = null;
		try {
			carousel = this.service.getOne(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//String json = objectMapper.writeValueAsString(articulo);
		

		/*
		{
			articulo: {
				id: ,
				etc: 
			},
			marcas: [
		         {
		        	 id,
		        	 descripcion
		         }
			],
			categorias:[
		        {
		        	 id,
		        	 descripcion
		        }
		    ]
		}
		*/
		Map<String,Object> jsonObject = new HashMap<>();
		jsonObject.put("carousel", carousel);
		
		String json = objectMapper.writeValueAsString(jsonObject);
		
		//escribo en el response el objeto
		resp.getWriter().print(json);
	}

}
