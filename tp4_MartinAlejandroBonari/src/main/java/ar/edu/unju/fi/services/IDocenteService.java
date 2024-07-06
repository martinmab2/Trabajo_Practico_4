package ar.edu.unju.fi.services;

import java.util.List;

import ar.edu.unju.fi.model.Docente;

public interface IDocenteService {
	public void añadirDocente(Docente docente);
	
	public List<Docente> getAllDocentes();
	
	public Docente buscarDocenteConLegajo(String legajo);

}
