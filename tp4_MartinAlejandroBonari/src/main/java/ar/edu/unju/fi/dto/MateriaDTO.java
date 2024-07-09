package ar.edu.unju.fi.dto;

import java.util.List;

import ar.edu.unju.fi.enumerados.Modalidad;
import ar.edu.unju.fi.model.Alumno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MateriaDTO {
	private Integer id;
	@NotNull(message="El codigo no debe estar vacio")
	private int codigo;
	@NotBlank(message = "El nombre no debe ser nulo")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
	private String nombre;
	@NotBlank(message = "El curso no debe ser nulo")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
	private String curso;
	@NotNull(message = "La cantidad de horas no debe ser nula")
    @Min(value = 0, message = "La cantidad mínima de horas es 20")
    @Max(value = 24, message = "La cantidad máxima de horas es 70")
	private int cantidadHoras;
	@NotBlank(message="La modalidad no tiene que ser nula")
	private Modalidad modalidad;
	@NotNull(message="El campo docente no tiene que ser nulos")
	private DocenteDTO docente;
	@NotNull(message="El campo carrera no tiene que ser nula")
	private CarreraDTO carrera;
	private boolean estado;
	private List<Alumno> alumnos;
}
