package Clase3repasodaos;



import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Clase3repasoModelos.personaVO;
import clase2repasoDB.ConexxionDB; 

public class personaDAO {
	
	private static Boolean interruptor = false;
	
	
	public void guardarPersona(personaVO miPersona) throws NullPointerException,RuntimeException{
	ConexxionDB con = new ConexxionDB();
	Statement estatuto = null;
	try {
			estatuto = con.getconexion().createStatement();
			estatuto.execute("INSERT INTO persona(Nombre,Edad,Profesion,Telefono) VALUES ('" + miPersona.getNombrePersona() + "','" + miPersona.getEdadPersona() 
			+ "','" + miPersona.getProfesionPersona() + "','" + miPersona.getTelefonoPersona() + "')");
			JOptionPane.showMessageDialog(null, "Creado con exito");	
	}catch(SQLException e){
		e.printStackTrace();
		System.out.println(e.getMessage());
		JOptionPane.showMessageDialog(null,"No se ha registrado a: " +miPersona.getNombrePersona(),"Informacion",JOptionPane.INFORMATION_MESSAGE);
	}catch(NullPointerException f) {
		JOptionPane.showMessageDialog(null, "No se ha creado una persona");
	}
	 finally {
		 try {
			 estatuto.close();
			con.getconexion().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
}
	public personaVO registrarPersona() throws SQLException, Exception,NullPointerException {
		personaVO personaRgtda = null;
		if(buscarPersona() == true) {
			String N = JOptionPane.showInputDialog("Ingrese datos de la persona a registar:\n Nombre: ");
			Integer E = Integer.parseInt ( JOptionPane.showInputDialog("Edad: "));
			String P = JOptionPane.showInputDialog("Profesion: ");
			Integer T =  Integer.parseInt (JOptionPane.showInputDialog("Telefono: "));
			personaRgtda = new personaVO(N,E,P,T);	
		}else {
			JOptionPane.showMessageDialog(null,"Id ya existe");
		}
		return personaRgtda;
	}
	public Boolean buscarPersona() throws SQLException,Exception {
		Integer id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Id: "));
		ConexxionDB con = new ConexxionDB();
		PreparedStatement aBuscar = con.getconexion().prepareStatement("SELECT * FROM persona WHERE id = ?");
		aBuscar.setInt(1, id);
		ResultSet buscado = aBuscar.executeQuery();
		if(buscado.next()) {
			personaVO pepitoperez = new personaVO(buscado.getString("nombre"),buscado.getInt("edad"),buscado.getString("profesion"),buscado.getInt("telefono"));
			personaVO.setIdPersona(id);
			JOptionPane.showMessageDialog(null, "El siguiente resultado encontrado: \n "+ pepitoperez.toString());
		}else{
			JOptionPane.showMessageDialog(null,"Id no existe");
			interruptor = true;
		}
				aBuscar.close();
		con.getconexion().close();	
	return interruptor;	
	}
	public void actualizarPersona() throws SQLException, Exception,RuntimeException {
		if(buscarPersona()==false) {
			
			String Nnombre = JOptionPane.showInputDialog("Ingrese datos de la persona a modificar:\n Nombre: ");
			Integer Nedad = Integer.parseInt ( JOptionPane.showInputDialog("Edad: "));
			String Nprofesion = JOptionPane.showInputDialog("Profesion: ");
			Integer Ntelefono =  Integer.parseInt (JOptionPane.showInputDialog("Telefono: "));
			personaVO persona = new personaVO();
			ConexxionDB con = new ConexxionDB();
			Statement aActualizar = con.getconexion().createStatement();
					aActualizar.execute("UPDATE persona "
					+ "\n SET  nombre ='"+Nnombre+"'"+" , "
					+ "\n edad = '"+Nedad+"'"+" , "
					+ "\n profesion = '"+Nprofesion+"'"+" , "
					+ "\n telefono = '"+Ntelefono+"' "+ " WHERE id ='"+persona.getIdPersona()+"'");
					aActualizar.close();
					con.getconexion().close();
					JOptionPane.showMessageDialog(null,"Registro actualizado");	
		}else {
			JOptionPane.showMessageDialog(null,"Persona no existe");
		}
	}
	public void borrarPersona() throws HeadlessException, SQLException, Exception {
		if(buscarPersona() == false) {
			personaVO persona = new personaVO();
			ConexxionDB con = new ConexxionDB();
			Statement borrar = con.getconexion().createStatement();
			borrar.execute("DELETE FROM persona WHERE id ='"+persona.getIdPersona()+"'");
			borrar.close();
			con.getconexion().close();
			JOptionPane.showMessageDialog(null,"Se elimino el registro: "+persona.getIdPersona()+
					" "+persona.getNombrePersona()+
					" "+ persona.getEdadPersona()+
					" "+ persona.getProfesionPersona()+
					" "+persona.getTelefonoPersona());
			
			
		}else {
			JOptionPane.showMessageDialog(null,"Persona no existe");
		}
	}
	
	
	
	
}