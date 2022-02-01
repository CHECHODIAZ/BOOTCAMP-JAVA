package practicasemana11;

import java.util.Scanner;

public class MainGestor {

	public static void main(String[] args) {
		Scanner Teclado = new Scanner(System.in);
		Icrud icrud = new Icrud();
		try {
			System.out.println("1-IGRESAR UN REGISTRO");
			System.out.println("2-ELIMINAR UN REGISTO");
			System.out.println("3-CONSULTAR UN REGISTRO");
			System.out.println("4-DECIR ALGO EN UN IDIOMA");
			Integer elegir = Teclado.nextInt();
			switch(elegir) {
			case 1 : icrud.Ingresar_inf();
			        break;
			case 2 : icrud.Eliminar_registro();
			        break;
			case 3 : icrud.consultar_registro();
	                break;
			case 4 : icrud.Decir_algo();
	                break;
			}
			
	}catch(RuntimeException w) {
		System.out.println("Reinicie el sistema e Ingrese una Opcion CORRECTA "+w);
	}
		Teclado.close();	
}
}