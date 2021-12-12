package practicasemana4;

public class Superman extends VOLADORES implements aterrizables {
	int id;
	String colorcapa;
	String Origen;
	public Superman(int id, String nombre, String marca, boolean alas, String clasificacion, int id2, String colorcapa,
			String origen) {
		super(id, nombre, marca, alas, clasificacion);
		id = id2;
		this.colorcapa = colorcapa;
		Origen = origen;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColorcapa() {
		return colorcapa;
	}
	public void setColorcapa(String colorcapa) {
		this.colorcapa = colorcapa;
	}
	public String getOrigen() {
		return Origen;
	}
	public void setOrigen(String origen) {
		Origen = origen;
	}
	
	public String toString() {
		return "Superman [id=" + id + ", colorcapa=" + colorcapa + ", Origen=" + Origen + "]";
	}
	
	public void aterrizar() {
		System.out.println("SUPERMAN ATERRIZA");
	}
		
	
	

}
