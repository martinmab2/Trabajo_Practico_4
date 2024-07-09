package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.model.Docente;

public interface IDocenteRepository extends JpaRepository<Docente, Integer> {
    List<Docente> findByEstado(boolean estado);
}
