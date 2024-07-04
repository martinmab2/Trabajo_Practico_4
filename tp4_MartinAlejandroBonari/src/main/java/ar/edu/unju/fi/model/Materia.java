package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.enumerados.Modalidad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Materia {
	private int codigo;
	private String nombre;
	private String curso;
	private int cantidadHoras;
	private Modalidad modalidad;
	private Docente docente;
	private Carrera carrera;
}