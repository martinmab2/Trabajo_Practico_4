package ar.edu.unju.fi.services;

import java.util.List;

import ar.edu.unju.fi.model.Alumno;

public interface IAlumnoService {
	public void añadirAlumno(Alumno almuno);

	public List<Alumno> getAllAlumnos();

	public Alumno buscarAlumnoPorDni(int dni);
}