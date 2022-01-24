package practicasemana9;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu extends DatosDBMemoria {
	
	private static String Inscrito;
	private static String MATRICULADO;
	 String get_Inscripcion() throws DuplicadoExcepcion,GenericExcepcion,InputMismatchException {
		Scanner teclado = new Scanner(System.in);
	
		System.out.println("Ingrese NOMBRE DEL ALUMNO: ");
		String Nombre = teclado.next();
		
		System.out.println("Ingrese APELLIDO DEL ALUMNO: ");
		String Apellido = teclado.next();
		
		System.out.println("Ingrese codigo de matricula: ");
		String Matricula = teclado.next();
		DatosDBMemoria Check = new DatosDBMemoria();
		Object []check = (Object[]) Check.setArray_Alumno();
		String dato5 = " ";
		for (int g=0;g<check.length;g++) {
			if(dato5.indexOf(Matricula)>=0) {
				System.out.println("Codigo correcto");
				break;
			}
			dato5 = (String) check[g];
			if(dato5.indexOf(Matricula)>=0) {
				System.out.println("Codigo correcto");
				break;
			}else {
				while (dato5.indexOf(Matricula)<0) {
					System.out.println("Debe ingresar un codigo de matricula VALIDO."
						+ "o debe realizar su matricula e ingresar el codigo arrojado por el sistema ");
					System.out.println("Ingrese codigo o Presione '0' para salir");
					Scanner mteclado = new Scanner(System.in);
					Integer TMatricula = mteclado.nextInt();
					Matricula = TMatricula.toString();
					if(TMatricula == 0 ) {
						System.exit(0);
					}	
				}
			}
		}
		System.out.println("Escoja el NUMERO del curso:    1-PROGRAMACION,2-IDIOMAS,3-MATEMATICAS ");
		Integer CursO = teclado.nextInt();
		String Curso = CursO.toString();
		DatosDBMemoria Oferta = new DatosDBMemoria();
		String []oferta = (String[]) Oferta.getOferta();
		DatosDBMemoria materia = new DatosDBMemoria();
		Object []materiaFnl = (Object[])materia.getArray_Materia();
		String dato2 = " ";
		String dato = " ";
		for(int k=0;k < oferta.length;k++) {
				dato = oferta[k];			
			if ((dato.indexOf(Curso)>=0)) {
					System.out.println(oferta[k]);  
				}
		}System.out.println("Escoja una materia : ");
		String Materia = teclado.next();
		for(int r=0;r<materiaFnl.length;r++) {
			     dato2 = (String) materiaFnl[r];
			     for(int k=0;k < oferta.length;k++) {
			    	 dato = oferta[k];
			    	 if((dato2.indexOf(Materia)==0)&&(dato.indexOf(Curso)==0)) {
							System.out.println(dato2);
							break;
						}	
			     }
			     if((dato2.indexOf(Materia)==0)&&(dato.indexOf(Curso)==0)) {
						break;
					}						
		}
		Materia turno = new Materia();
		Integer []turnos = turno.getTurno();
		System.out.println("Escoja un turno: "+Arrays.asList(turnos));
		Integer Turno = teclado.nextInt();
		Integer fturno = 0;
		try {
			for(int j=0;j<turnos.length;j++) {
				if(turnos[j]==Turno) {
				     fturno = Turno;
				}
			}
		}
		catch(Exception e) {
			System.out.println("error: no es un turno valido");
		}
		Inscrito = "Matricula:"+ Matricula+" Curso: "+Curso+" "+Nombre+" "+Apellido+" inscrito en: "
				+dato2+" Turno: "+fturno;
		System.out.println("Inscripcion exitosa");
	    return Inscrito;
	}
	
	public void set_EliminarInscripcion()throws GenericExcepcion,InputMismatchException {
		Scanner Teclado = new Scanner(System.in);
		System.out.println("Ingrese codigo de matricula del estudiante a eliminar: ");
		String Matric = Teclado.next();
		Object []eliminar = DatosDBMemoria.toString(Array_Inscritos);
		for (int t=0;t < eliminar.length;t++) {
			String dato3 = (String) eliminar[t];
			 if(dato3 == null) {
					while(dato3==null) {
						System.out.println("CODIGO DE MATRICULA NO EXISTE");
						System.out.println("Presione '0' para salir");
						Matric = Teclado.next();
						Integer Tmatric = Integer.parseInt(Matric);
						Matric = Tmatric.toString();
						if(Tmatric == 0) {
							System.exit(0);
						}	
					}
				}
			if((dato3.indexOf(Matric)>=0)) {
				System.out.println(eliminar[t]);
				System.out.println("Verifique datos de la inscripcion a eliminar. "
						+"Presione '1' para Eliminar el dato o cualquier otro numero para salir: ");
				int Veliminar = Teclado.nextInt();
				if (Veliminar == 1) {
					eliminar[t]=null;
					System.out.println("Eliminado.");
					break;	
				}else 
					System.exit(0);
				}
				
			}
			
		}
	
	public void set_BuscarInscripcion() throws GenericExcepcion,InputMismatchException {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese codigo de matricula del estudiante a buscar: ");
		String Matricula = teclado.next();
		DatosDBMemoria Buscar = new DatosDBMemoria();
		Object []buscar = Buscar.toString(Array_Inscritos);
		for (int t=0;t < buscar.length;t++) {
			String dato4 = (String) buscar[t];
			if(dato4 == null) {
				while(dato4==null) {
					System.out.println("CODIGO DE MATRICULA NO EXISTE");
					System.out.println("Presione '0' para salir");
					Matricula = teclado.next();
					Integer Rmatricula = Integer.parseInt(Matricula);
					if(Rmatricula == 0) {
						System.exit(0);
					}
				}
			}
			if((dato4.indexOf(Matricula)>=0)) {
				System.out.println(buscar[t]);
				break;
			}
	}		
}
	public static String get_DoMatricula()throws DuplicadoExcepcion,GenericExcepcion,InputMismatchException{
		Alumno Alumno = new Alumno();
		MATRICULADO = Alumno.getMatricula()+" "+Alumno.getNombre()+" "+Alumno.getApellido();
		System.out.println("Matriculado...");
	 
		return MATRICULADO;
	}
}