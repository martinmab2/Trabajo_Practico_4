package ar.edu.unju.fi.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.IDocenteRepository;
import ar.edu.unju.fi.services.IDocenteService;

@Service("docenteServiceImp")
public class DocenteServiceImp implements IDocenteService {
	
	@Autowired
	private IDocenteRepository docenteRepository;
	@Autowired
	private Docente docente;
	
	@Override
	public void añadirDocente(Docente docente) {
		docenteRepository.save(docente);
	}
	@Override
	public List<Docente> getAllDocentes(){
		List<Docente> docentes = (List<Docente>) docenteRepository.findAll();
		return docentes;
	}
	@Override
	public Docente buscarDocenteConLegajo(String legajo) {
		docente = docenteRepository.findById(legajo).get();
		return docente;
	}
}