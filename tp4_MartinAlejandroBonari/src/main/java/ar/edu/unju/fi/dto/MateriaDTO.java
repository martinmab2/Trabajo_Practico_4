package ar.edu.unju.fi.dto;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Modalidad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MateriaDTO {
	private int codigo;
	private String nombre;
	private String curso;
	private int cantidadHoras;
	private Modalidad modalidad;
	private Docente docente;
	private Carrera carrera;
}
