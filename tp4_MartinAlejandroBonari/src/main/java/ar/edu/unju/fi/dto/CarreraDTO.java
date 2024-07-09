package ar.edu.unju.fi.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Materia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CarreraDTO {
	private Long id;
    private String codigo;
    private String nombre;
    private int cantidadAnios;
    private boolean estado;
    
    private List<Materia> materias;
}