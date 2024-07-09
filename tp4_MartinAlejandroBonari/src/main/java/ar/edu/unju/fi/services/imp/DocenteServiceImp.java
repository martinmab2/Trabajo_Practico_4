package ar.edu.unju.fi.services.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.mapper.DocenteMapper;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.IDocenteRepository;
import ar.edu.unju.fi.repository.IMateriaRepository;
import ar.edu.unju.fi.services.IDocenteService;

@Service("docenteServiceImp")
public class DocenteServiceImp implements IDocenteService {
	
	@Autowired
	private IDocenteRepository docenteRepository;
	@Autowired
	private DocenteMapper docenteMap;
	@Autowired
	private IMateriaRepository materiaRepository;
	
	private static final Log LOGGER = LogFactory.getLog(DocenteServiceImp.class);
	
	@Override
	public void guardarDocente(DocenteDTO docentedto) {
		Docente docente = docenteMap.ConvertirDocenteDTOAdocente(docentedto);
		docente.setEstado(true);
		docenteRepository.save(docente);
		LOGGER.info("Docente guardado con exito");
	}

	@Override
	public List<DocenteDTO> mostrarDocentes() {
		List<DocenteDTO> docentesDto = new ArrayList<DocenteDTO>();
		docentesDto = (List<DocenteDTO>) docenteMap.ConvertirListaDocenteAListaDocenteDTO(docenteRepository.findByEstado(true));
		LOGGER.info("Lista de docentes");
		return docentesDto;
	}
	@Override
	public List<DocenteDTO> mostrarDocentesNoAsignados() {
	    List<Docente> docentes = docenteRepository.findAll();

	
	    List<Integer> idsDocentesAsignados = new ArrayList<>();
	    List<Materia> materiasActivas = materiaRepository.findByEstado(true);
	    for (Materia materia : materiasActivas) {
	        idsDocentesAsignados.add(materia.getDocente().getId());
	    }
	    List<Docente> docentesNoAsignados = new ArrayList<>();
	    for (Docente docente : docentes) {
	        if (!idsDocentesAsignados.contains(docente.getId()) && docente.isEstado()) {
	            docentesNoAsignados.add(docente);
	        }
	    }

	    return docenteMap.ConvertirListaDocenteAListaDocenteDTO(docentesNoAsignados);
	}
	

	@Override
	public void EliminarDocente(Integer id) {
	    Docente docente = docenteRepository.findById(id).get();
	    docente.setEstado(false);
	    docenteRepository.save(docente);
		LOGGER.info("Docente eliminado con exito");
	}

	@Override
	public void modificarDocente(DocenteDTO docentedto) {
		Docente docente = docenteMap.ConvertirDocenteDTOAdocente(docentedto);
		docente.setEstado(true);
		docenteRepository.save(docente);
		LOGGER.info("Modificacion realizada con exito");
	}

	@Override
	public DocenteDTO buscarDocente(Integer id) {
		Optional<Docente> OpDocente = docenteRepository.findById(id);
		LOGGER.info("Busqueda en proceso");
		if(OpDocente.isPresent()) {
			Docente docente = OpDocente.get();
			DocenteDTO docentedto = docenteMap.ConvertirDocenteADocenteDTO(docente);
			LOGGER.info("Busqueda realizada con exito");
			return docentedto;
		}else {
			return null;
		}
	}
}