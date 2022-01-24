package practicasemana9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Alumno {
	private static Long Matricula;
	private static String Nombre;
	private static String Apellido;
	


	public static Long getMatricula() throws DuplicadoExcepcion,GenericExcepcion,InputMismatchException {
		Scanner teclado = new Scanner(System.in);
	    System.out.println("Ingrese su DOCUMENTO DE IDENTIDAD: ");
	    Long FMatricula = teclado.nextLong();
	    Matricula = FMatricula+1111; 
		System.out.println("Su numero de matricula es: "+Matricula);
		return Matricula;
	}


	
	public static String getNombre() throws GenericExcepcion,InputMismatchException {
		Scanner teclado = new Scanner(System.in);
	    System.out.println("Ingrese su NOMBRE: ");
	    Nombre = teclado.next();
	    return Nombre;
	  
	}
	public static String getApellido() throws GenericExcepcion,InputMismatchException {
		Scanner teclado = new Scanner(System.in);
	    System.out.println("Ingrese su APELLIDO: ");
	    Apellido = teclado.next();
	    return Apellido;
	}

    
	@Override
	public String toString() {
		return "Matricula= " + Matricula + ", Nombre= " + Nombre + ", Apellido= " + Apellido ;
	}
	public Long toStringMat() {
		return Matricula;
	}

}
