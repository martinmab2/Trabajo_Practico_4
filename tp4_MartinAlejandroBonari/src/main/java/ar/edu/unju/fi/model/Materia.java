package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;
import ar.edu.unju.fi.enumerados.Modalidad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Integer codigo;

    @Column(name = "Mat_nom")
    private String nombre;

    @Column(name = "Mat_cur")
    private String curso;

    @Column(name = "Mat_hor")
    private int cantidadHoras;

    @Column(name = "Mat_mod")
    private Modalidad modalidad;

    @ManyToOne
    @JoinColumn(name = "docente_id") 
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "carrera_id") 
    private Carrera carrera;
}