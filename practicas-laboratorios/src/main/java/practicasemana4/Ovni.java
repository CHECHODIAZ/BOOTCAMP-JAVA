package practicasemana4;

public class Ovni extends VOLADORES implements aterrizables {
	String color;
	Integer ctripulantes;
	String Origen;
	public Ovni(int id, String nombre, String marca, boolean alas, String clasificacion, String color,
			Integer ctripulantes, String origen) {
		super(id, nombre, marca, alas, clasificacion);
		this.color = color;
		this.ctripulantes = ctripulantes;
		Origen = origen;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getCtripulantes() {
		return ctripulantes;
	}
	public void setCtripulantes(Integer ctripulantes) {
		this.ctripulantes = ctripulantes;
	}
	public String getOrigen() {
		return Origen;
	}
	public void setOrigen(String origen) {
		Origen = origen;
	}
	
	public String toString() {
		return "Ovni [color=" + color + ", ctripulantes=" + ctripulantes + ", Origen=" + Origen + "]";
	}
	
	public void aterrizar() {
		System.out.println("OVNI ATERRIZA");
	}

	
}
