package practicasemana11;

public class Ingles implements IDIOMA {

	public void Habla(EnumIdiomas idioma) {
		if(idioma.equals(EnumIdiomas.ENG)) {
			System.out.println("hey there, what is up?");
		}
		
		
		
	}

	public void Aprende(EnumIdiomas idioma) {
		System.out.println("aprende ingles");
		
	}

	

}
