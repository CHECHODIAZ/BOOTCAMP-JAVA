package practicasemana11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PERSONA {
	
	private static String Nombre;
	private static EnumIdiomas Nativo;
	private static EnumIdiomas Hablante;
	private static EnumIdiomas Aprendiendo;
	private static EnumIdiomas PruebaIdioma;
	
	public PERSONA(String nombre, EnumIdiomas nativo,EnumIdiomas hablante,EnumIdiomas aprendiendo) {
	
		Nombre = nombre;
		Nativo = nativo;
		Hablante = hablante;
		Aprendiendo = aprendiendo;
		
	}
	public static String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public static EnumIdiomas getNativo() {
		return Nativo;
	}
	public void setNativo(EnumIdiomas nativo) {
		Nativo = nativo;
	}
	public static EnumIdiomas getHablante() {
		return Hablante;
	}
	public void setHablante(EnumIdiomas hablante) {
		Hablante = hablante;
	}
	public static EnumIdiomas getAprendiendo() {
		return Aprendiendo;
	}
	public void setAprendiendo(EnumIdiomas aprendiendo) {
		Aprendiendo = aprendiendo;
	}

	public void pruebaIdioma (EnumIdiomas T)  {
		    try {
		    IDIOMA Espanol; 
	        IDIOMA Portugues;
	        IDIOMA Frances;
	        IDIOMA Ingles;
	        IDIOMA Otro;
	        Map<EnumIdiomas,IDIOMA> idiomas = new HashMap<EnumIdiomas,IDIOMA>();
	        
	        idiomas.put(EnumIdiomas.ES,Espanol= new Espanol());
	        idiomas.put(EnumIdiomas.PORT,Portugues = new Portugues());
	        idiomas.put(EnumIdiomas.FRAN,Frances = new Frances());
	        idiomas.put(EnumIdiomas.ENG,Ingles = new Ingles());
	        idiomas.put(EnumIdiomas.OTRO,Otro = new Otro());
	        
	        Set<Map.Entry<EnumIdiomas,IDIOMA>> idioms= idiomas.entrySet();
	        
	        
	        for(Map.Entry<EnumIdiomas,IDIOMA> idiom : idioms) {
	        	if(idiom.getKey().equals(T)) {
	                idiom.getValue().Habla(T);
	        	}
	        }
	}catch(RuntimeException e) {
		System.out.println("Reinicie programa e Ingrese dato valido");
	}
	
	}
}
