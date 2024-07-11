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

	@GetMapping("/listado")
	public String getListaCarrerasPage(Model model) {
		model.addAttribute("carreras", carreraService.getAllCarreras());
		model.addAttribute("titulo", "Carreras");
		return "eCarrera/carreras";
	}

	@GetMapping("/nuevo")
	public String getNuevaCarreraPage(Model model) {
		model.addAttribute("carrera", new CarreraDTO());
		model.addAttribute("edicion", false);
		model.addAttribute("titulo", "Nueva Carrera");
		return "eCarrera/carrera";
	}

	@PostMapping("/guardar")
	public ModelAndView guardarCarrera(@Valid @ModelAttribute("carrera") CarreraDTO carreraDTO, BindingResult result) {
		ModelAndView modelView;
		if (result.hasErrors()) {
			modelView = new ModelAndView("eCarrera/carrera");
			modelView.addObject("carrera", carreraDTO);
			modelView.addObject("edicion", false);
		} else {
			carreraDTO.setEstado(true); // Suponiendo que aquí se establece el estado
			carreraService.añadirCarrera(carreraDTO);
			modelView = new ModelAndView("redirect:/carrera/listado");
		}
		return modelView;
	}

	@GetMapping("/modificar/{id}")
	public String getModificarCarreraPage(Model model, @PathVariable("id") Long id) {
		CarreraDTO carrera = carreraService.buscarCarrera(id);
		if (carrera != null) {
			model.addAttribute("edicion", true);
			model.addAttribute("carrera", carrera);
			model.addAttribute("titulo", "Modificar Carrera");
			return "eCarrera/carrera";
		} else {
			return "redirect:/carrera/listado";
		}
	}

	@PostMapping("/modificar")
	public ModelAndView modificarCarrera(@Valid @ModelAttribute("carrera") CarreraDTO carreraDTO,
			BindingResult result) {
		ModelAndView modelView;
		if (result.hasErrors()) {
			modelView = new ModelAndView("eCarrera/carrera");
			modelView.addObject("carrera", carreraDTO);
			modelView.addObject("edicion", true);
		} else {
			carreraService.modificarCarrera(carreraDTO);
			modelView = new ModelAndView("redirect:/carrera/listado");
		}
		return modelView;
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarCarrera(@PathVariable("id") Long id) {
		carreraService.deleteCarrera(id);
		return "redirect:/carrera/listado";
	}
}