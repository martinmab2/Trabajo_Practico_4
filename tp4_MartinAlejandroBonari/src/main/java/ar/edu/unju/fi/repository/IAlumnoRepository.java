package ar.edu.unju.fi.repository;

import ar.edu.unju.fi.model.Alumno;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {


    List<Alumno> findByMaterias_Id(Integer materiaId);

	List<Alumno> findByEstado(boolean estado);
	
	List<Alumno> findByCarreraId(Long carreraId);
}