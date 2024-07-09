package ar.edu.unju.fi.dto;

import java.util.List;

import ar.edu.unju.fi.enumerados.Modalidad;
import ar.edu.unju.fi.model.Alumno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MateriaDTO {
	private Integer id;
	private int codigo;
	private String nombre;
	private String curso;
	private int cantidadHoras;
	private Modalidad modalidad;
	private DocenteDTO docente;
	private CarreraDTO carrera;
	private boolean estado;
	private List<Alumno> alumnos;
}
