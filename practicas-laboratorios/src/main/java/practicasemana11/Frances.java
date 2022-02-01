package practicasemana11;

public class Frances implements IDIOMA {

	

	public void Habla(EnumIdiomas idioma) {
		if(idioma.equals(EnumIdiomas.FRAN)) {
			System.out.println("Bonjour, comment allez-vous?");
		}
		
	}

	public void Aprende(EnumIdiomas idioma) {
		System.out.println("aprende frances");
		
	}

}
