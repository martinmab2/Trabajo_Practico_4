package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.services.IMateriaService;



@Controller
@RequestMapping("/alumno")
public class ConsultaAlumnoMateriaController {
	
	@Autowired
	private IMateriaService materiaService;
	
	@Autowired
	private AlumnoMapper alumnoMapper;
	

	@GetMapping("/filtrar")
	public String mostrarFiltro(Model model) {
	    List<MateriaDTO> materias = materiaService.getAllMaterias();
	    model.addAttribute("titulo", "Filtrado de Alumnos");
	    model.addAttribute("materias", materias);
	    return "consulta/filtrarAlumno";
	}

	@PostMapping("/filtrar")
	public String filtrarAlumnos(@RequestParam("materiaId") Integer materiaId, Model model) {
	    MateriaDTO materia = materiaService.buscarMateria(materiaId);
	    List<AlumnoDTO> alumnos = null;
	    if (materia != null) {
	        alumnos = alumnoMapper.toAlumnoDTOList(materia.getAlumnos());
	    }
	    List<MateriaDTO> materias = materiaService.getAllMaterias();
	    model.addAttribute("materias", materias);
	    model.addAttribute("alumnos", alumnos);
	    return "consulta/filtrarAlumno";
	}
}
