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
public class Docente {
    @Id
    @Column(name = "Docente_leg")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer legajo;

    @Column(name = "Docente_name")
    private String nombre;

    @Column(name = "Docente_surn")
    private String apellido;

    @Column(name = "Docente_email")
    private String email;

    @Column(name = "Docente_telef")
    private String telefono;
}