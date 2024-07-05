package ar.edu.unju.fi.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.IAlumnoRepository;
import ar.edu.unju.fi.services.IAlumnoService;

@Service("alumnoServiceImp")
public class AlumnoServiceImp implements IAlumnoService {
	
	@Autowired
	private IAlumnoRepository alumnoRepository;
	@Autowired
	private Alumno alumno;
	
	@Override
	public void añadirAlumno(Alumno alumno) {
		alumnoRepository.save(alumno);
	}
	@Override
	public List<Alumno> getAllAlumnos(){
		List<Alumno> alumnos = (List<Alumno>) alumnoRepository.findAll();
		return alumnos;
	}
	@Override
	public Alumno buscarAlumnoPorDni(int dni) {
		alumno = alumnoRepository.findById(dni).get();
		return alumno;
	}
}