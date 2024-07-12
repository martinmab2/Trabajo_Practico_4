package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.AlumnoMapper;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.services.IAlumnoService;
import ar.edu.unju.fi.services.IMateriaService;

@Controller
@RequestMapping("/form")
public class InscribirController {
	@Autowired
	private MateriaMapper materiaMapper;

	@Autowired
	private IMateriaService materiaService;

	@Autowired
	private AlumnoMapper alumnoMapper;

	@Autowired
	private IAlumnoService alumnoService;

	@GetMapping("/inscribir")
	public String getFormularioInscripcionAlumno(Model model) {
		List<MateriaDTO> materias = materiaService.getAllMaterias();
		List<AlumnoDTO> alumnos = alumnoService.getAllALumnos();
		model.addAttribute("titulo", "Inscripcion Alumno");
		model.addAttribute("alumnos", alumnos);
		model.addAttribute("materias", materias);
		return "consulta/inscripcionMateria";
	}

	@PostMapping("/inscribir")
	public String getInscribirAlumno(@RequestParam(value = "alumnoId", required = false) Long alumnoId,
	        @RequestParam(value = "materiaId", required = false) Integer materiaId,
	        RedirectAttributes redirectAttributes) {
	    if (alumnoId == null || materiaId == null) {
	        redirectAttributes.addFlashAttribute("errorMessage", "No se seleccionó alumno y/o materia.");
	        return "redirect:/form/inscribir";
	    }

	    Alumno alumno = alumnoMapper.toAlumno(alumnoService.buscarAlumno(alumnoId));
	    Materia materia = materiaMapper.toMateria(materiaService.buscarMateria(materiaId));

	    if (alumno != null && materia != null) {
	        alumno.getMaterias().add(materia);
	        materia.getAlumnos().add(alumno);
	        alumnoService.modificarAlumno(alumnoMapper.toAlumnoDTO(alumno));
	        materiaService.modificarMateria(materiaMapper.toMateriaDTO(materia));
	        redirectAttributes.addFlashAttribute("successMessage", "¡Se inscribió al alumno correctamente!");
	    } else {
	        redirectAttributes.addFlashAttribute("errorMessage", "Error al inscribir el alumno en la materia.");
	    }

	    return "redirect:/form/inscribir";
	}

}