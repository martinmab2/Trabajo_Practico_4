package ar.edu.unju.fi.model;

import java.util.List;

import org.springframework.stereotype.Component;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Table(name = "carreras")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carrera_id")
	private Long id;
	
	@Column(name = "carrera_codigo")
	private String codigo;

	@Column(name = "carrera_nombre")
	private String nombre;

	@Column(name = "carrera_duracion")
	private int cantidadAnios;

	@Column(name = "carrera_estado")
	private boolean estado;
	
	@OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
	private List<Materia> materias;
	
	@OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
	private List<Alumno> alumnos;

	
	
	public Carrera(String codigo, String nombre, short cantidadAnios, boolean estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidadAnios = cantidadAnios;
		this.estado = estado;
	}
}