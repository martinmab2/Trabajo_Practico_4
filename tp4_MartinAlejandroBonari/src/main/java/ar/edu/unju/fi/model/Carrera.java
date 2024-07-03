package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrera {
    private String codigo;
    private String nombre;
    private int cantidadAnios;
    private String estado;
}
