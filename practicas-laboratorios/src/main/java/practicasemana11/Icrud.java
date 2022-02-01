package practicasemana11;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Icrud {
	
	
	Scanner teclado=new Scanner(System.in);
	EnumIdiomas mienumNAT = null;
	EnumIdiomas mienumAPR = null;
	EnumIdiomas mienumHAB = null;
	String Eliminar = " ";
	String TipoRegistro = " ";
	String nombreIngresado = " ";
	String idiomaNAT =" ";
	String idiomaAPR =" ";
	String idiomaHAB =" ";
	
	
public void Ingresar_inf() {
	System.out.println("Ingrese su nombre: ");
	nombreIngresado = teclado.next();
	System.out.println("Ingrese su idioma nativo: (ES,ENG,PORT,FRAN,OTRO,NINGUNO)");
	 idiomaNAT = teclado.next();
	System.out.println("Ingrese idioma que quiere aprender: (ES,ENG,PORT,FRAN,OTRO,NINGUNO) ");
	idiomaAPR = teclado.next();
	System.out.println("Ingrese su segundo idioma aprendido: (ES,ENG,PORT,FRAN,OTRO,NINGUNO) ");
    idiomaHAB = teclado.next();
	
	if(idiomaNAT != null || idiomaAPR !=null  || idiomaHAB != null) {
	    mienumNAT = EnumIdiomas.valueOf(idiomaNAT);
		mienumAPR = EnumIdiomas.valueOf(idiomaAPR);
		mienumHAB = EnumIdiomas.valueOf(idiomaHAB);
	} else {
		throw new RuntimeException("Ingrese dato valido");
	}
	PERSONA persona = new PERSONA(nombreIngresado,mienumNAT,mienumHAB,mienumAPR );
	save_registro();
}	
	
	
	
	//GUARDAR UN REGISTRO
private void save_registro() {
		
	      if(Memoria.getPersona()==null) {
			Memoria.save_persona();
			Memoria.save_idioma();	
			
		 }else if(Memoria.getPersona().containsKey(nombreIngresado+" NATIVO ")&& Memoria.getPersona().containsValue(idiomaNAT)) {
			System.out.println("REGISTRO YA EXISTE");
			if(Memoria.getPersona().containsKey(nombreIngresado+" APRENDE ")&& Memoria.getPersona().containsValue(idiomaAPR)) {
				System.out.println("LA PERSONA YA ESTA APRENDIENDO ESTE IDIOMA");
				if(Memoria.getPersona().containsKey(nombreIngresado+ " HABLA ")&& Memoria.getPersona().containsValue(idiomaHAB)) {
					System.out.println("LA PERSONA ES FLUYENTE EN ESTE IDIOMA");
				}
			}
			
		}else {
			throw new RuntimeException("Reinicie programa e Ingrese dato valido");
		}
	}		
	
	
	
	
	//ELIMINAR UN REGISTRO
public void Eliminar_registro() {
		System.out.println("Ingrese nombre de la persona en el registro que desea eliminar");
		Eliminar = teclado.next();
		System.out.println("Ingrese tipo de registro (NATIVO,APRENDE,HABLA)");
		TipoRegistro = teclado.next();
	   try {
		switch(TipoRegistro) 
	    {
	    case "NATIVO" : Eliminar = Eliminar+" NATIVO ";
	           break;
	    case "APRENDE" : Eliminar = Eliminar+" APRENDE ";
	           break;
	    case "HABLA" : Eliminar = Eliminar+" HABLA ";
	          break;
	    default :
	    	System.out.println("Ingrese dato valido");
	    }
	    Memoria rsult = new Memoria();
	    rsult.EliminarRegisto(Eliminar);
	   }catch(RuntimeException r) {
		   System.out.println("Reinicie programa e Ingrese dato valido");
	   }
    System.out.println(Memoria.getPersona());
    
}  
    
	
	
	//DECIR ALGO EN UN IDIOMA
public void Decir_algo() {
    System.out.println("Digite el idioma en el que desea SALUDAR: (ES,ENG,PORT,FRAN,OTRO,NINGUNO)");
    String hablarEn = teclado.next();
    mienumNAT = EnumIdiomas.valueOf(hablarEn);
    PERSONA alguien = new PERSONA("TU DICES:",mienumNAT , mienumHAB, mienumAPR);
    
    System.out.println(PERSONA.getNombre());
    alguien.pruebaIdioma(mienumNAT);
    
    
	}


public void consultar_registro() {
	
	
	if(Memoria.getPersona()==null) {
		System.out.println("NO HAY REGISTRO AUN, SELECCIONA LA OP.1 EN EL MENU PRINCIPAL PARA REGISTARTE");
	}
	
	if(Memoria.getPersona().containsKey(nombreIngresado+" NATIVO ")&& Memoria.getPersona().containsValue(idiomaNAT)) {
		System.out.println("REGISTRO YA EXISTE");
		if(Memoria.getPersona().containsKey(nombreIngresado+" APRENDE ")&& Memoria.getPersona().containsValue(idiomaAPR)) {
			System.out.println("LA PERSONA YA ESTA APRENDIENDO ESTE IDIOMA");
			if(Memoria.getPersona().containsKey(nombreIngresado+ " HABLA ")&& Memoria.getPersona().containsValue(idiomaHAB)) {
				System.out.println("LA PERSONA ES FLUYENTE EN ESTE IDIOMA");
			}
		}
		
	}else {
		throw new RuntimeException("Reinicie programa e Ingrese dato valido");
	}
}
   
}



