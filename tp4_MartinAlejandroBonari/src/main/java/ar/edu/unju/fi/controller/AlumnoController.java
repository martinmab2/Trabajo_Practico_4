package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.services.IAlumnoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoDTO alumnoDTO;
	
	@Autowired
	private IAlumnoService alumnoService;

    @GetMapping("/listado")
    public String getListaAlumnosPage(Model model) {
        model.addAttribute("alumnos", alumnoService.getAllALumnos());
        model.addAttribute("titulo", "Alumnos");
        return "/eAlumno/alumnos";
    }

    @GetMapping("/nuevo")
    public String getNuevoAlumnoPage(Model model) {
        model.addAttribute("alumno", alumnoDTO);
        model.addAttribute("edicion", false);
        model.addAttribute("titulo", "Nuevo Alumno");
        return "/eAlumno/alumno";
    }

    @PostMapping("/guardar")
	public ModelAndView crearAlumno(@Valid @ModelAttribute("alumno") AlumnoDTO alumnoDTO, BindingResult result) {
		ModelAndView modelView;
		if(result.hasErrors()) {
			modelView = new ModelAndView("redirect:/alumno/listado");
		}else {
		modelView = new ModelAndView("redirect:/alumno/listado");
		alumnoService.crearAlumno(alumnoDTO);
		modelView.addObject("alumnos", alumnoService.getAllALumnos());
		}
		return modelView;
		}

    @GetMapping("/modificar/{id}")
	public String getModificarAlumnoPage(Model model, @PathVariable(value="id") Long id) {
		AlumnoDTO alumno = new AlumnoDTO();
		alumno=alumnoService.buscarAlumno(id);
		model.addAttribute("edicion", false);
		model.addAttribute("alumno",alumno);
        return "/eAlumno/alumno";
    }

    @PostMapping("/modificar")
	public String modificarAlumno(@ModelAttribute("alumno") AlumnoDTO alumnodto) {
		alumnoService.modificarAlumno(alumnodto);
		return "redirect:/alumno/listado";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCarrera(@PathVariable(value="id") Long id) {
		alumnoService.eliminarAlumno(id);
		return "redirect:/alumno/listado";
	}

    @GetMapping("/filtrar")
    public String getFiltrarAlumnoPage(Model model) {
        model.addAttribute("titulo", "Filtrar Alumno");
        return "consulta/filtrarAlumno";
    }
}
