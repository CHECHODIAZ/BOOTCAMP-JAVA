package practicasemana11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Memoria {
	
	private static Map<String,EnumIdiomas> persona;
	private static Collection<EnumIdiomas> idioma;
	
	
	
	public static void save_persona() {
		Map<String,EnumIdiomas> personas =new HashMap<String,EnumIdiomas>();
		personas.put(PERSONA.getNombre()+" NATIVO ",PERSONA.getNativo());
		personas.put(PERSONA.getNombre()+ " APRENDE ",PERSONA.getAprendiendo());
		personas.put(PERSONA.getNombre()+ " HABLA ",PERSONA.getHablante());
		
		persona=personas;
	}

	public  static void save_idioma() {
 
		Collection<EnumIdiomas> idiomas = new HashSet<EnumIdiomas>();
		idiomas.add(PERSONA.getAprendiendo());
		idiomas.add(PERSONA.getHablante());
		idiomas.add(PERSONA.getNativo());
		idioma=idiomas;
		cruzar();
	}

	public static Map<String,EnumIdiomas> getPersona() {
		return persona;
	}

	public static Collection<EnumIdiomas> getIdioma() {
		return idioma;
	}
	private static Collection<EnumIdiomas> cruzar(){
		Collection<String> cruz = new LinkedList<String>();
		cruz.add(PERSONA.getNombre()+" NATIVO >>>> "+PERSONA.getNativo());
		cruz.add(PERSONA.getNombre()+" FLUYENTE EN >>>> "+PERSONA.getHablante());
		cruz.add(PERSONA.getNombre()+" APRENDIENDO >>>> "+PERSONA.getAprendiendo());
		
		return null;
		
	}
	public void EliminarRegisto(String E) {
      
		try {
		Set<Map.Entry<String,EnumIdiomas>> person = persona.entrySet();
		
		for(Map.Entry<String,EnumIdiomas> perso:person) {
			if(perso.getKey().startsWith(E)) {
				persona.remove(perso.getKey(),perso.getValue());
				break;
			}
		}
		}catch(RuntimeException u ) {
			System.out.println("Reinicie programa e Ingrese dato valido");
		}
		
        
    
}
	
	
	
}
