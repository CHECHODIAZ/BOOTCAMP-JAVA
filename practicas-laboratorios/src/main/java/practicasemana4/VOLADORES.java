package practicasemana4;

public abstract class VOLADORES {
	private int id;
	protected String nombre;
	public String marca;
	private boolean alas;
	private String clasificacion;
	public VOLADORES(int id, String nombre, String marca, boolean alas, String clasificacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.alas = alas;
		this.clasificacion = clasificacion;
	}
	public VOLADORES(String nombre, String marca, boolean alas, String clasificacion) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.alas = alas;
		this.clasificacion = clasificacion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public boolean isAlas() {
		return alas;
	}
	public void setAlas(boolean alas) {
		this.alas = alas;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	@Override
	public String toString() {
		return "VOLADORES [id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", alas=" + alas + ", clasificacion="
				+ clasificacion + "]";
	}
	
	

}
