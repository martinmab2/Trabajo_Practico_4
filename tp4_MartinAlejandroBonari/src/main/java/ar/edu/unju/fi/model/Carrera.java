package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

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
public class Carrera {
	@Id
    @Column(name="carrera_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String codigo;
	@Column(name="carrera_nombre")
    private String nombre;
	@Column(name="carrera_duracion")
    private int cantidadAnios;
	@Column(name="carrera_estado")
    private String estado;
}
