package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Table (name = "docente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Docente {
    @Id
    @Column(name = "Docente_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Docente_leg")
    private String legajo;

    @Column(name = "Docente_name")
    private String nombre;

    @Column(name = "Docente_surn")
    private String apellido;

    @Column(name = "Docente_email")
    private String email;

    @Column(name = "Docente_telef")
    private String telefono;
    
    @Column (name = "Docente_estado")
    private boolean estado;
    
    @OneToOne (mappedBy  = "docente")
    private Materia materia;
}