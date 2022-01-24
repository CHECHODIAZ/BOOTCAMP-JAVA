package practicasemana9;

import java.util.Arrays;
import java.util.Scanner;

public class DatosDBMemoria {
	private static Object []Array_Alumno = new Object[1000000];
	private final Object []Array_Materia = new Object [] {"1.PHP","2.PYTHON","3.RUBY","4.INGLES","5.FRANCES",
			"6.ANALISIS MATEMATICO","7.ALGEBRA"};
	private Object []Array_Cursos = new Object [] {"1-PROGRAMACION","2-IDIOMAS","3-MATEMATICAS"};
	public static Object []Array_Inscritos = new Object [50000];
	
	
	public Object getArray_Inscritos() throws DuplicadoExcepcion,GenericExcepcion {
	
		for (int i=0;i<Array_Inscritos.length;i++) {
			Menu Inscrito= new Menu();
			if (Array_Inscritos[i] == null) {
				Array_Inscritos[i] = Inscrito.get_Inscripcion();
				break;
			}
		}
		return Array_Inscritos;
	}
	
	public Object getOferta() {
		String []Oferta=new String[7];
		for (int i=0;i<Array_Cursos.length;i++) {
			for (int j=0;j<Array_Materia.length;j++) {
				if ((Array_Cursos[i] == "1-PROGRAMACION")&&(Array_Materia[j]=="1.PHP"||Array_Materia[j]=="2.PYTHON"||Array_Materia[j]=="3.RUBY")) {
				    Oferta[6-j] = Array_Cursos[i]+" , oferta de materias: "+Array_Materia[j];
		    }
				if ((Array_Cursos[i] == "2-IDIOMAS")&&(Array_Materia[j]=="4.INGLES"||Array_Materia[j]=="5.FRANCES")) {
					Oferta[6-j] = Array_Cursos[i]+" , oferta de materias: "+Array_Materia[j];
			}	
				if ((Array_Cursos[i] == "3-MATEMATICAS")&&(Array_Materia[j]=="6.ANALISIS MATEMATICO"||Array_Materia[j]=="7.ALGEBRA")) {
					Oferta[6-j] = Array_Cursos[i]+" , oferta de materias: "+Array_Materia[j];
			}	
	}
	
}return Oferta;
}

	public Object getArray_Alumno() throws DuplicadoExcepcion {
		
		for (int i=0;i<Array_Alumno.length;i++) {
			Alumno alumnos = new Alumno();
			if (Array_Alumno[i] == null) {
				Array_Alumno[i] = alumnos.toString();
				break;
			}
			
		}
		return Array_Alumno;
	}

	public Object setArray_Alumno() {
		
		return Array_Alumno;
	}
	
	public Object[] getArray_Materia() {
		return Array_Materia;
	}

	public Object[] getArray_Cursos() {
		return Array_Cursos;
	}

	public void setArray_Cursos(Object[] array_Cursos) {
		Array_Cursos = array_Cursos;
	}

	public void setArray_Inscritos(Object[] array_Inscritos) {
		Array_Inscritos = array_Inscritos;
	}

		

	public static Object[] toString(Object[] array_Inscritos) {
		
		return array_Inscritos;
	}
	
	
	
	
}