package ar.edu.unju.fi.services.imp;

import java.util.List;
import java.util.Optional;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.ICarreraRepository;
import ar.edu.unju.fi.repository.IDocenteRepository;
import ar.edu.unju.fi.repository.IMateriaRepository;
import ar.edu.unju.fi.services.IMateriaService;

@Service("materiaServiceImp")
public class MateriaServiceImp implements IMateriaService {
	
	@Autowired
	private ICarreraRepository carreraRepository;
	
	@Autowired
	private IDocenteRepository docenteRepository;

	@Autowired
	private IMateriaRepository materiaRepository; 
	
	@Autowired
	private MateriaMapper materiaMapper; 
	
    private static final Log LOGGER = LogFactory.getLog(AlumnoServiceImp.class);
	@Override
	public void crearMateria(MateriaDTO materiaDTO) {
		Materia materia = materiaMapper.toMateria(materiaDTO);
		Carrera carrera = carreraRepository.findById(materia.getCarrera().getId()).get();
		Docente docente = docenteRepository.findById(materia.getDocente().getId()).get();
		materia.setCarrera(carrera);
		materia.setDocente(docente);
		materia.setEstado(true);
		materiaRepository.save(materia);
		LOGGER.info("Materia creada con exito");
	}

	@Override
	public List<MateriaDTO> listaMateria() {
		List<MateriaDTO> materiasDTO = materiaMapper.toMateriaDTOList(materiaRepository.findByEstado(true));
		LOGGER.info("Lista de materias");
		return materiasDTO;
	}

	@Override
	public void eliminarMateria(MateriaDTO materiaDTO) {
		Materia materia =  materiaMapper.toMateria(materiaDTO);
		materia.setEstado(false);
		materia.setDocente(null);
		materia.setCarrera(null);
		materiaRepository.save(materia);
		LOGGER.info("Materia eliminada con exito");
	}

	@Override
	public void modificarMateria(MateriaDTO materiaDTO) {
	    Materia materia = materiaMapper.toMateria(materiaDTO);
	    
	    
	    Optional<Docente> optionalDocente = docenteRepository.findById(materia.getDocente().getId());
	    if (optionalDocente.isPresent()) {
	        materia.setDocente(optionalDocente.get());
	    } else {
	        
	        LOGGER.error("Docente no encontrado con ID: " + materia.getDocente().getId());
	        return; 
	    }
	    
	    
	    Optional<Carrera> optionalCarrera = carreraRepository.findById(materia.getCarrera().getId());
	    if (optionalCarrera.isPresent()) {
	        materia.setCarrera(optionalCarrera.get());
	    } else {
	    
	        LOGGER.error("Carrera no encontrada con ID: " + materia.getCarrera().getId());
	        return;
	    }
	    
	    materia.setEstado(true);
	    materiaRepository.save(materia);
	    LOGGER.info("Materia modificada con éxito");
	}

	@Override
	public MateriaDTO buscarMateria(Integer id) {
		Optional<Materia> OpMateria = materiaRepository.findById(id);
		LOGGER.info("Busqueda en proceso");
		if(OpMateria.isPresent()) {
			Materia materia = OpMateria.get();
			MateriaDTO materiadto = materiaMapper.toMateriaDTO(materia);
			LOGGER.info("Busqueda con exito");
			return materiadto;
		}else{
			return null;
		}
	}
}