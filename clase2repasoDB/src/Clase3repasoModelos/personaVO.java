package Clase3repasoModelos;

public class personaVO {
   private static Integer idPersona;
   private static  String nombrePersona;
   private static Integer edadPersona;
   private static String profesionPersona;
   private static Integer telefonoPersona;
   
   
   public personaVO() {
   }
   
public personaVO(String nombrePersona, Integer edadPersona, String profesionPersona,
		Integer telefonoPersona) {
	personaVO.nombrePersona = nombrePersona;
	personaVO.edadPersona = edadPersona;
	personaVO.profesionPersona = profesionPersona;
	personaVO.telefonoPersona = telefonoPersona;
	
}

public Integer getIdPersona() {
	return idPersona;
}
public String getNombrePersona() {
	return nombrePersona;
}
public Integer getEdadPersona() {
	return edadPersona;
}
public String getProfesionPersona() {
	return profesionPersona;
}
public Integer getTelefonoPersona() {
	return telefonoPersona;
}
public static void setIdPersona(Integer idPersona) {
	personaVO.idPersona = idPersona;
}
public void setNombrePersona(String nombrePersona) {
	this.nombrePersona = nombrePersona;
}
public void setEdadPersona(Integer edadPersona) {
	this.edadPersona = edadPersona;
}
public void setProfesionPersona(String profesionPersona) {
	this.profesionPersona = profesionPersona;
}
public void setTelefonoPersona(Integer telefonoPersona) {
	this.telefonoPersona = telefonoPersona;
}

@Override
public String toString() {
	return "::  " + nombrePersona + ", identificacion: "+idPersona+" ___, "+ edadPersona+" años de adad"
			+ ", ocupacion: "+ profesionPersona + ", telefono= " + telefonoPersona;
}
   
   
   
}
