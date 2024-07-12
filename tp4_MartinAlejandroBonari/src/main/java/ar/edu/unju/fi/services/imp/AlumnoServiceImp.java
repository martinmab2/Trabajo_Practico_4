package ar.edu.unju.fi.services.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.IAlumnoRepository;
import ar.edu.unju.fi.repository.ICarreraRepository;
import ar.edu.unju.fi.services.IAlumnoService;

@Service("alumnoServiceImp")
public class AlumnoServiceImp implements IAlumnoService {
	
	
	@Autowired
	private ICarreraRepository carreraRepository;
	
	@Autowired
    private IAlumnoRepository alumnoRepository;
	
    @Autowired
    private AlumnoMapper alumnoMap;
    
    
    private static final Log LOGGER = LogFactory.getLog(AlumnoServiceImp.class);
    
	@Override
	public void crearAlumno(AlumnoDTO alumnodto) {
		Alumno alumno = alumnoMap.toAlumno(alumnodto);
		Carrera carrera = carreraRepository.findById(alumno.getCarrera().getId()).get();
		alumno.setCarrera(carrera);
		alumno.setEstado(true);
		alumnoRepository.save(alumno);
		LOGGER.info("Alumno creado con exito");
	}

	@Override
	public List<AlumnoDTO> getAllALumnos() {
		List<AlumnoDTO> alumnosdto = new ArrayList<AlumnoDTO>();
		alumnosdto = alumnoMap.toAlumnoDTOList(alumnoRepository.findByEstado(true));
    LOGGER.info("Lista de alumnos");
    return alumnosdto;
	} 

	@Override
	public void eliminarAlumno(Long id) {
		Alumno alumno = alumnoRepository.findById(id).get();
		alumno.setEstado(false);
		alumno.setCarrera(null);
		alumnoRepository.save(alumno);
		LOGGER.info("Alumno eliminado con exito");
	}

	@Override
	public void modificarAlumno(AlumnoDTO alumnodto) {
		Alumno alumno = alumnoMap.toAlumno(alumnodto);
		
		 Optional<Carrera> optionalCarrera = carreraRepository.findById(alumno.getCarrera().getId());
		    if (optionalCarrera.isPresent()) {
		        alumno.setCarrera(optionalCarrera.get());
		    } else {
		    
		        LOGGER.error("Carrera no encontrada con ID: " + alumno.getCarrera().getId());
		        return;
		    }
		alumno.setEstado(true);
		alumnoRepository.save(alumno);
		LOGGER.info("Alumno modificado con exito");
		
	}

	@Override
	public AlumnoDTO buscarAlumno(Long id) {
		Optional<Alumno> OpALumno = alumnoRepository.findById(id);
		LOGGER.info("Busqueda en proceso");
		if(OpALumno.isPresent()) {
			Alumno encontrado = OpALumno.get();
			AlumnoDTO alumnodto = alumnoMap.toAlumnoDTO(encontrado);
			LOGGER.info("Busqueda exitosa");
		return alumnodto;
		}else {
		return null;
		}
	}
	
	@Override
    public List<AlumnoDTO> getAlumnosByMateria(MateriaDTO materiaDTO) {
        List<Alumno> alumnos = alumnoRepository.findByMaterias_Id(materiaDTO.getId());

        List<AlumnoDTO> alumnosDTO = alumnos.stream()
                .map(alumno -> alumnoMap.toAlumnoDTO(alumno))
                .collect(Collectors.toList());

        LOGGER.info("Lista de alumnos por materia obtenida correctamente");
        return alumnosDTO;
    }
}