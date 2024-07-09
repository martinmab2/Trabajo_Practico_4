package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.model.Materia;

public interface IMateriaRepository extends JpaRepository<Materia, Integer> {
	List<Materia> findByEstado(boolean estado);
}