package ar.edu.unju.fi.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import ar.edu.unju.fi.enumerados.Modalidad;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Table(name = "materias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Materia {
	
    @Id
    @Column(name = "Mat_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "Mat_cod", nullable = false)
    private int codigo;

    @Column(name = "Mat_nom", nullable = false)
    private String nombre;

    @Column(name = "Mat_cur", nullable = false)
    private String curso;

    @Column(name = "Mat_hor", nullable = false)
    private int cantidadHoras;

    @Enumerated(EnumType.STRING)
    @Column(name = "Mat_modal", nullable = false)
    private Modalidad modalidad;
    
    @Column(name = "Mat_estado", nullable = false)
	private boolean estado;

    @ManyToMany
	@JoinTable(name = "materias_alumnos",
	joinColumns = @JoinColumn(name = "Mat_id"),
	inverseJoinColumns = @JoinColumn(name = "alumno_id"))
    private List<Alumno> alumnos = new ArrayList<Alumno>();

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name = "Docente_id")
	private Docente docente;
     
    @ManyToOne
    @JoinColumn(name = "carrera_id") 
    private Carrera carrera;
    
    public Materia(int codigo, String nombre, String curso, int cantidadHoras, Modalidad modalidad, boolean estado,
			List<Alumno> alumnos, Docente docente, Carrera carrera) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.cantidadHoras = cantidadHoras;
		this.modalidad = modalidad;
		this.estado = estado;
		this.alumnos = alumnos;
		this.docente = docente;
		this.carrera = carrera;
	}
}