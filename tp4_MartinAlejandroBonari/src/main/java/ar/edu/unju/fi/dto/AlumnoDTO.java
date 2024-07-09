package ar.edu.unju.fi.dto;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Component;
import ar.edu.unju.fi.model.Materia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AlumnoDTO {
	private Long id;
	private int dni;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private LocalDate fechaNacimiento;
	private String domicilio;
	private String LU;
	private boolean estado;
	private List<Materia> materias;

}
