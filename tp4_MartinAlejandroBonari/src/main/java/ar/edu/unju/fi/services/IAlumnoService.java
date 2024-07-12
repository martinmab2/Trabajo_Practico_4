package ar.edu.unju.fi.services;

import java.util.List;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.model.Alumno;


public interface IAlumnoService {
	public void crearAlumno(AlumnoDTO alumnodto);
	
    public List<AlumnoDTO> getAllALumnos();
    
    public void eliminarAlumno(Long id);
    
    public void modificarAlumno(AlumnoDTO alumnodto);
    
    public AlumnoDTO buscarAlumno(Long id);

    List<AlumnoDTO> getAlumnosByMateria(MateriaDTO materiaDTO);
    
    List<Alumno> obtenerAlumnosPorCarrera(Long carreraId);
    
}