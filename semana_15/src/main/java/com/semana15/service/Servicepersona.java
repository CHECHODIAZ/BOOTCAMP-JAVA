package com.semana15.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.semana15.entity.Persona;

public interface Servicepersona {
    
	public Map<Long,List<Object>>mostrarregistros() throws SQLException, Exception;
	
	public void agregarregistro(Long doc, String nom, String ape, Long edad, LocalDate nDate, String ocup) throws SQLException;
}
