package ar.edu.unju.fi.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "alumnos")
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Alumno {
    @Id
    @Column(name="alumno_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "alumno_dni")
    private int dni;

    @Column(name="alumno_nombre")
    private String nombre;

    @Column(name="alumno_apellido")
    private String apellido;

    @Column(name="alumno_email")
    private String email;

    @Column(name="alumno_telef")
    private String telefono;

    @Column(name="alumno_fechnac")
    private LocalDate fechaNacimiento;

    @Column(name="alumno_dom")
    private String domicilio;

    @Column(name="alumno_LU")
    private String LU;
    
    @Column(name = "alumno_estado")
    private boolean estado;
    
    @ManyToMany(mappedBy = "alumnos")
    private List<Materia> materias = new ArrayList<Materia>();
}
