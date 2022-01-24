package practicasemana9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Aplicacion {

	public static void main(String[] args) {
	
		
		DatosDBMemoria Alumns = new DatosDBMemoria();
        Scanner Teclado = new Scanner(System.in);
		System.out.println("Ingrese el numero de alumnos a Matricular: ");
		try {
			Integer NAlumns = Teclado.nextInt();
			for(int j=0;j<NAlumns;j++) {
		        try {
					Menu.get_DoMatricula();
				} catch (DuplicadoExcepcion e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("ERROR: NUMERO DE D.I REPETIDO");
				} catch (GenericExcepcion e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("ERROR: SIN CONEXION");
				}
				try {
					Alumns.getArray_Alumno();
				} catch (DuplicadoExcepcion e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				DatosDBMemoria Ofertas = new DatosDBMemoria();
				Ofertas.getOferta();
				DatosDBMemoria Inscritos = new DatosDBMemoria();
				Scanner teclado = new Scanner(System.in);
				System.out.println("Digite el numero de ESTUDIANTES a inscribir: ");
				Integer AlumnoMtc = teclado.nextInt();
			for (int i=0;i<AlumnoMtc;i++) {
				try {
					try {
						Inscritos.getArray_Inscritos();
					} catch (DuplicadoExcepcion e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				} catch (GenericExcepcion e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("ERROR: SIN CONEXION"+e);
				}
			}
			    Menu Buscar = new Menu();
			    try {
					Buscar.set_BuscarInscripcion();
				} catch (GenericExcepcion e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("ERROR: SIN CONEXION"+e);
				}
			
				Menu Eliminar = new Menu();
				try {
					Eliminar.set_EliminarInscripcion();
					teclado.close();
				} catch (GenericExcepcion e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("ERROR: SIN CONEXION"+e);
				}
				
		}catch(InputMismatchException x){
			System.out.println("DATO INGRESADO NO ES EL ESPERADO, REINICIE EL SISTEMA E INGRESE UN DATO ADECUADO "+x);
		}
		
		
		
	
		

	}

}
