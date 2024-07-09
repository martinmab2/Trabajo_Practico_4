package ar.edu.unju.fi.services;

import java.util.List;

import ar.edu.unju.fi.model.Materia;

public interface IMateriaService {
	public void añadirMateria(Materia materia);

	public List<Materia> getAllMateria();

	public Materia buscarMateriaPorCodigo(int codigo);
	
}