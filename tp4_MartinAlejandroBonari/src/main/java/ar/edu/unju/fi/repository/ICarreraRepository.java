package ar.edu.unju.fi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unju.fi.model.Carrera;

public interface ICarreraRepository extends JpaRepository<Carrera, Long> {
	Carrera findByCodigo(Long codigo);
}