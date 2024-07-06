package ar.edu.unju.fi.services;

import java.util.List;
import ar.edu.unju.fi.model.Carrera;

public interface ICarreraService {
	public void añadirCarrera(Carrera carrera);
	
	public List<Carrera> getAllCarreras();
	
	public Carrera buscarCarreraConCodigo(String codigo);
}
