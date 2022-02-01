package practicasemana11;

public class Espanol implements IDIOMA{

	
	public void Habla(EnumIdiomas idioma) {
		if(idioma.equals(EnumIdiomas.ES)) {
			System.out.println("Hola, como estas?");
		}
		
	}

	public void Aprende(EnumIdiomas idioma) {
		System.out.println("aprende español");
		
	}
	

}
