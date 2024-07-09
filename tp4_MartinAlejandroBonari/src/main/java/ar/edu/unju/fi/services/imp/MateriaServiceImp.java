package ar.edu.unju.fi.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.IMateriaRepository;
import ar.edu.unju.fi.services.IMateriaService;

@Service("materiaServiceImp")
public class MateriaServiceImp implements IMateriaService {
	
	@Autowired
	private IMateriaRepository materiaRepository;
	@Autowired
	private Materia materia;
	
	@Override
	public void añadirMateria(Materia materia) {
		materiaRepository.save(materia);
	}
	@Override
	public List<Materia> getAllMateria(){
		List<Materia> materias = (List <Materia>) materiaRepository.findAll();
		return materias;
	}
	@Override
	public Materia buscarMateriaPorCodigo(int codigo) {
		materia = materiaRepository.findById(codigo).get();
		return materia;
	}
}