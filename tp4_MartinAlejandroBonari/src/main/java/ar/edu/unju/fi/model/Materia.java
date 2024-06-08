package ar.edu.unju.fi.model;

public class Materia {
	private int codigo;
	private String nombre;
	private String curso;
	private int cantidadHoras;
	private boolean modalidad;
	private Docente docente;
	private Carrera carreara;
	
	public Materia(int codigo, String nombre, String curso, int cantidadHoras, boolean modalidad, Docente docente,
			Carrera carreara) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.cantidadHoras = cantidadHoras;
		this.modalidad = modalidad;
		this.docente = docente;
		this.carreara = carreara;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public boolean isModalidad() {
		return modalidad;
	}

	public void setModalidad(boolean modalidad) {
		this.modalidad = modalidad;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Carrera getCarreara() {
		return carreara;
	}
	
	public void setCarreara(Carrera carreara) {
		this.carreara = carreara;
	}	
}