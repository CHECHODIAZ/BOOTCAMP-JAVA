package com.semana15.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import java.util.List;
import java.util.Map;

import com.semana15.dao.Daopersona;

public class ServiceImpl implements Servicepersona {

	
	@Override
	public Map<Long, List<Object>> mostrarregistros() throws SQLException, Exception {
		Daopersona mostrar = new Daopersona();

		return mostrar.findRegistros();
	}

	@Override
	public void agregarregistro(Long doc, String nom, String ape, Long edad, LocalDate nDate, String ocup) throws SQLException {
		Daopersona agregar = new Daopersona();
		agregar.insertar(doc, nom, ape, edad, nDate, ocup);
	}
	

}
