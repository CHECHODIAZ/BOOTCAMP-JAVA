package practicasemana11;

public class Portugues implements IDIOMA {

	public void Habla(EnumIdiomas idioma) {
		if(idioma.equals(EnumIdiomas.PORT)) {
			System.out.println("Oi, como vai?");
		}
		
	}

	public void Aprende(EnumIdiomas idioma) {
		System.out.println("aprende portugues");
		
	}

	

}
