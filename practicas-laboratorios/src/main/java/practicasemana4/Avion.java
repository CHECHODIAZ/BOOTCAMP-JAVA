package practicasemana4;

public class Avion extends VOLADORES {
	private int id;
	String color;
	Integer csillas;
	String tipo;

		
	public Avion(int id, String nombre, String marca, boolean alas, String clasificacion, int id2, String color,
			Integer csillas, String tipo) {
		super(id, nombre, marca, alas, clasificacion);
		id = id2;
		this.color = color;
		this.csillas = csillas;
		this.tipo = tipo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public Integer getCsillas() {
		return csillas;
	}


	public void setCsillas(Integer csillas) {
		this.csillas = csillas;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String toString() {
		return "Avion [" + " color=" + color + ", cantida sillas=" + csillas + ", tipo=" + tipo + "]";
	}


	
	


}
