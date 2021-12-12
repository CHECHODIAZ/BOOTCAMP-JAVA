package practicasemana4;

public class mainaterrizable {

	public static void main(String[] args) {
		Avion A = new Avion(1, "EL CHACHO", "Airbus", true, "jet", 1, "blanco y azul", 60, "comercial");
		Helicoptero H = new Helicoptero(2, "EL PAJARO", "BELL", false, "GIROESCOPIO", 2, "ROSADO", 4, "GUERRA");
		Superman S = new Superman(3, "CLARK", "NO APLICA", false, "HOMBRE DE ACERO", 3, "ROJO", "CRIPTON");
		Ovni O = new Ovni(4, "EXTRATERRESTRE", "DESCONOCIDO", false, "DESCONOCIDA", "PLATA", 100, "MARTE");
		
		VOLADORES[] VOLADORS = new VOLADORES[] {A,H,S,O};
		for (VOLADORES V:VOLADORS) {
			if(V instanceof aterrizables) {
				aterrizables at = (aterrizables)V;
			    at.aterrizar();
			}else {
				System.out.println(V+" "+"no es aterrizable");
			}
		}
		
	



	}

}
