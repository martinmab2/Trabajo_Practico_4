package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.enumerados.Modalidad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Materia {
	@Id
	@Column(name = "Mat_cod")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(name = "Mat_nom")
	private String nombre;
	@Column(name = "Mat_cur")
	private String curso;
	@Column(name = "Mat_hor")
	private int cantidadHoras;
	@Column(name = "Mat_mod")
	private Modalidad modalidad;
	@Column(name = "Mat_doc")
	private Docente docente;
	@Column(name = "Mat_car")
	private Carrera carrera;
}