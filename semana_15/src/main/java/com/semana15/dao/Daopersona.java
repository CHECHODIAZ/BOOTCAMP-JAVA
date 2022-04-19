package com.semana15.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.semana15.dbconnection.DbConnection;
import com.semana15.entity.Persona;

public class Daopersona {
	
	
	public Map<Long,List<Object>> findRegistros() throws SQLException,Exception {
		//se traen de la db
		Connection conx = DbConnection.getConections();
		String query = "SELECT * FROM persona";
		Statement pre = conx.createStatement();
		ResultSet resp = pre.executeQuery(query);
		Persona persona = new Persona();
		Map<Long,List<Object>> mapapersona = new HashMap<Long,List<Object>>();
		while(resp.next()) {
			persona.setNombre(resp.getString("nombre"));
			persona.setApellido(resp.getString("apellido"));
			persona.setDocumento(resp.getLong("documento"));
			persona.setEdad(resp.getLong("edad"));
			persona.setFechaNacimiento(resp.getDate("fechaNacimiento"));
			persona.setOcupacion(resp.getString("ocupacion"));
			
			List<Object> give = new ArrayList();
			give.add(persona.getNombre());
			give.add(persona.getApellido());
			give.add(persona.getEdad());
			give.add(persona.getFechaNacimiento());
			give.add(persona.getOcupacion());
			
			mapapersona.put(persona.getDocumento(), give);
			
			System.out.println(persona.getNombre());
		}
		
		return mapapersona;
	}
	
	public Integer counter() throws SQLException{
		Integer cantidadreg = null;
		Connection con = DbConnection.getConections();
		PreparedStatement pre = con.prepareStatement("SELECT COUNT(*) FROM persona");
		ResultSet fn = pre.executeQuery();
		if(fn.next()) {
			cantidadreg = fn.getInt("COUNT(*)");	
		}
		return cantidadreg;
	}
	
	public void insertar(Long doc, String nom, String ape, Long edad, LocalDate fn, String ocup) throws SQLException {
		Connection con = DbConnection.getConections();
		String sql = "INSERT INTO persona (documento,nombre,apellido,edad,fechaNacimiento,ocupacion) values("+doc+",'"+nom+"','"+ape+"',"+edad+",'"+fn+"','"+ocup+"')";
		Statement pre = con.createStatement();
		pre.execute(sql);	
	}
	
	public static void main(String[] args) throws Exception {
		//Daopersona r = new Daopersona();
		//System.out.println(r.findRegistros());
		
		//Daopersona pr = new Daopersona();
		//System.out.println(pr.insertar(30652093L,"elizabeth","quintana",53L,"12/03/2016","negociante"));
		
		 
			    java.util.Date utilDate = new java.util.Date();
			    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			    System.out.println("utilDate:" + utilDate);
			    System.out.println("sqlDate:" + sqlDate);

			  
	}

}
