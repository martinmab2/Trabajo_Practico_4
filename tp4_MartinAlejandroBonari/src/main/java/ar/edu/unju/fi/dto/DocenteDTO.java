package ar.edu.unju.fi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDTO {
	private Integer id;
	private String legajo;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private boolean estado;
}