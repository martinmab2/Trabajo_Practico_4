package ar.edu.unju.fi.services;

import java.util.List;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.model.Materia;

public interface IMateriaService {
	public void crearMateria(MateriaDTO materiaDTO);
	
	public List<MateriaDTO> getAllMaterias();
	
	public void eliminarMateria(MateriaDTO materiaDTO);
	
	public void modificarMateria(MateriaDTO materiaDTO);

	public MateriaDTO buscarMateria(Integer materiaId);

	public List<Materia> listarTodasLasMaterias();
	
}