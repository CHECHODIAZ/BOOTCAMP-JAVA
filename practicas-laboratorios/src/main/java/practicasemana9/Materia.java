package practicasemana9;

public class Materia {
	
	private Long Id;
	private Object[] Curso;
	private Integer []Turno = new Integer [] {1,2,3,4};
	
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Object[] getCurso() {
		DatosDBMemoria curso = new DatosDBMemoria();
		Curso = curso.getArray_Cursos();
		return Curso;
	}

	public void setCurso(Object[] curso) {
		this.Curso = curso;
	}

	public Integer[] getTurno() {
		return Turno;
	}

	public void setTurno(Integer[] turno) {
		
	}
	
	
	

}
