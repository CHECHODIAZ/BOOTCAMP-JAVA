package Clase3repasoprograma;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import Clase3repasoModelos.personaVO;
import Clase3repasodaos.personaDAO;

public class AppPrincipal {

	public static void main(String[] args) throws Exception,NumberFormatException {
			personaDAO pdao = new personaDAO();
			
			
			int opcionIngresada;
			do {
			opcionIngresada = Integer.parseInt(
			JOptionPane.showInputDialog(" Ingrese una opcion:\n 1)Crear persona\n 2)Buscar persona \n 3)Actualizar persona\n 4)Borrar persona"));
			
			switch (opcionIngresada) {
			case 1:
				JOptionPane.showMessageDialog(null,"opcion 1 ingresada");
				pdao.guardarPersona(pdao.registrarPersona());
				break;
			case 2:
				JOptionPane.showMessageDialog(null,"opcion 2 ingresada");
				pdao.buscarPersona();
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"opcion 3 ingresada");
				pdao.actualizarPersona();
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"opcion 4 ingresada");
				pdao.borrarPersona();
				break;
			}

	}while(opcionIngresada != 1 && opcionIngresada !=2  && opcionIngresada !=3  && opcionIngresada !=4);
			

}
}