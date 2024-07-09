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
import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.services.ICarreraService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/carrera")
public class CarreraController {

	@Autowired
	private ICarreraService carreraService;
	
	@Autowired
	private CarreraDTO carreradto;

	@GetMapping("/listado")
	public String getListaCarrerasPage(Model model) {
		model.addAttribute("carreras", carreraService.getAllCarreras());
		model.addAttribute("titulo", "Carreras");
		return "/eCarrera/carreras";
	}

	@GetMapping("/nuevo")
	public String getNuevaCarreraPage(Model model) {
		model.addAttribute("carrera", carreradto);
		model.addAttribute("edicion", false);
		model.addAttribute("titulo", "Nueva Carrera");
		return "/eCarrera/carrera";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarCarrerasPage(@Valid @ModelAttribute("carrera") CarreraDTO carreraDTO, BindingResult result) {
		ModelAndView modelView;
		if(result.hasErrors()) {
			modelView = new ModelAndView("/eCarrera/carrera");
		}else {
			modelView = new ModelAndView("/carrera/listado");
			carreraDTO.setEstado(true);
			carreraService.añadirCarrera(carreraDTO);
			modelView.addObject("carreras", carreraService.getAllCarreras());
		}
		return modelView;
	}
	
	@GetMapping("/modificar/{id}")
	public String getModificarCarreraPage(Model model, @PathVariable(value="id") Long id) {
		CarreraDTO carrera = carreraService.buscarCarrera(id);
		model.addAttribute("carrera", carrera);
		model.addAttribute("edicion", true);
		model.addAttribute("titulo", "Modificar Carrera");
		return "/eCarrera/carrera";
	}
	
	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("carrera") CarreraDTO carreradto) {
		carreraService.modificarCarrera(carreradto);
		return "redirect:/carrera/listado";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarCarrera(@PathVariable("codigo") Long id) {
		carreraService.deleteCarrera(id);
		return "redirect:/carrera/listado";
	}
	 @GetMapping("/consultar")
	    public String getConsultarAlumnoPage(Model model) {
	        model.addAttribute("titulo", "Consultar Alumnos Inscriptos");
	        return "consulta/consultarAlumno";
	    }
}