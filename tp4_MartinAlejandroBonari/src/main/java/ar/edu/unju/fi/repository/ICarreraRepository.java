package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.model.Carrera;

public interface ICarreraRepository extends JpaRepository<Carrera, Long> {
	List<Carrera> findByEstado(boolean estado);
}