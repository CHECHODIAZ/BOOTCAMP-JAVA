package com.semana_16.entity;

public class Carousel {
	
	private static Integer id;
	private static Integer active;
	private static String descripcion;
	private static String imagen;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		Carousel.id = id;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		Carousel.active = active;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		Carousel.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		Carousel.imagen = imagen;
	}

}
