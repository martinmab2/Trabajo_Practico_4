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

	@Override
	public void añadirCarrera(Carrera carrera) {
		carreraRepository.save(carrera);
	}

	@Override
	public List<Carrera> getAllCarreras() {
		return (List<Carrera>) carreraRepository.findAll();
	}

	@Override
	public Carrera buscarCarreraConCodigo(Long codigo) {
		return carreraRepository.findByCodigo(codigo);
	}
}