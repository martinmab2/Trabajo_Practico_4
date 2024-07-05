package ar.edu.unju.fi.services.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.ICarreraRepository;
import ar.edu.unju.fi.services.ICarreraService;

@Service("carreraServiceImp")
public class CarreraServiceImp implements ICarreraService {
	
	@Autowired
	private ICarreraRepository carreraRepository;
	@Autowired
	private Carrera carrera;
	
	@Override
	public void añadirCarrera(Carrera carrera) {
		carreraRepository.save(carrera);
	}
	@Override
	public List<Carrera> getAllCarreras(){
		List<Carrera> carreras = (List<Carrera>) carreraRepository.findAll();
		return carreras;
	}
	@Override
	public Carrera buscarCarreraConCodigo(String codigo) {
		carrera = carreraRepository.findById(codigo).get();
		return carrera;
	}
}
