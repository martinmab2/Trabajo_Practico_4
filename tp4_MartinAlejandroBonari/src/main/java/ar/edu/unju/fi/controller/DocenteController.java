package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.services.IDocenteService;

@Controller
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private IDocenteService docenteService;
    
    @Autowired
    private DocenteDTO docenteDTO;

    @GetMapping("/listado")
    public String getListaDocentesPage(Model model) {
        model.addAttribute("docentes", docenteService.mostrarDocentes());
        model.addAttribute("titulo", "Docentes");
        return "/eDocente/docentes";
    }

    @GetMapping("/nuevo")
    public String getNuevoDocentePage(Model model) {
        model.addAttribute("docente", docenteDTO);
        model.addAttribute("edicion", false);
        model.addAttribute("titulo", "Nuevo Docente");
        return "/eDocente/docente";
    }

    @PostMapping("/guardar")
	public ModelAndView getGuadarDocentesPage(@ModelAttribute("docente") DocenteDTO docentedto) {
		ModelAndView modelView = new ModelAndView("/docente/listado");
		docenteService.guardarDocente(docentedto);
		modelView.addObject("docentes", docenteService.mostrarDocentes());
		return modelView;
	} 

    @GetMapping("/modificar/{id}")
    public String getModificarDocentePage(Model model, @PathVariable("id") Integer id) {
        DocenteDTO docente = docenteService.buscarDocente(id);
        model.addAttribute("docente", docente);
        model.addAttribute("edicion", true);
        model.addAttribute("titulo", "Modificar Docente");
        return "/eDocente/docente";
    }

    @PostMapping("/modificar")
    public String modificarDocente(@ModelAttribute("docente") DocenteDTO docentedto) {
        docenteService.modificarDocente(docentedto);
        return "redirect:/docente/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDocente(@PathVariable("id") Integer id) {
        docenteService.EliminarDocente(id);
        return "redirect:/docente/listado";
    }
}