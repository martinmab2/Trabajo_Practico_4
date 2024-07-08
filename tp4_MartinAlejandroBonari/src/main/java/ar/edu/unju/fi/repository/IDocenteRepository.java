package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.model.Docente;

public interface IDocenteRepository extends JpaRepository<Docente, Integer> {
    Docente findByLegajo(Integer legajo);
}