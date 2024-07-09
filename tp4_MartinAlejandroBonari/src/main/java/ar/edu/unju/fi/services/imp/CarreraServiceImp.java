package ar.edu.unju.fi.services.imp;

import java.util.List;
import java.util.Optional;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.mapper.CarreraMapper;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.ICarreraRepository;
import ar.edu.unju.fi.services.ICarreraService;

@Service("carreraServiceImp")
public class CarreraServiceImp implements ICarreraService {
	
	@Autowired
	private ICarreraRepository carreraRepository;
	
	@Autowired
	private CarreraMapper carreraMapper; 
	
	private static final Log LOGGER = LogFactory.getLog(DocenteServiceImp.class);
	
	@Override
	public void añadirCarrera(CarreraDTO carreraDTO) {
		Carrera carrera = carreraMapper.toCarrera(carreraDTO);
		carrera.setEstado(true);
		carreraRepository.save(carrera);
		LOGGER.info("Carrera creada con exito");
	}

	@Override
	public List<CarreraDTO> getAllCarreras() {
		List<CarreraDTO> carrerasDTO = carreraMapper.toCarreraDTOList(carreraRepository.findByEstado(true));
		LOGGER.info("Lista de carreras");
		return carrerasDTO;
	}
	
	@Override
	public void deleteCarrera(Long id) {
	    Carrera carrera = carreraRepository.findById(id).get();
		carrera.setEstado(false);
		carreraRepository.save(carrera);
		LOGGER.info("Carrera eliminada con exito");
	}

	@Override
	public void modificarCarrera(CarreraDTO carreraDTO) {
		Carrera carrera = carreraMapper.toCarrera(carreraDTO);
		carrera.setEstado(true);
        carreraRepository.save(carrera);
        LOGGER.info("Carrera modificada con exito");
	}

	@Override
	public CarreraDTO buscarCarrera(Long id) {
		Optional<Carrera> OpCarrera = carreraRepository.findById(id);
		LOGGER.info("Busqueda en proceso");
		if(OpCarrera.isPresent()) {
			Carrera carrera = OpCarrera.get();
			CarreraDTO carreradto = carreraMapper.toCarreraDTO(carrera);
			LOGGER.info("Busqueda exitosa");
			return carreradto;
		}else {
			return null;
		}
		
	}
}