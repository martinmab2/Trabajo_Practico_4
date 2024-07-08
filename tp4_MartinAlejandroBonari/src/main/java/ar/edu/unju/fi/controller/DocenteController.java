package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.repository.IDocenteRepository;

@Controller
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private IDocenteRepository docenteRepository;

    @GetMapping("/listado")
    public String getListaDocentesPage(Model model) {
        model.addAttribute("docentes", docenteRepository.findAll());
        model.addAttribute("titulo", "Docentes");
        return "docentes";
    }

    @GetMapping("/nuevo")
    public String getNuevoDocentePage(Model model) {
        model.addAttribute("docente", new Docente());
        model.addAttribute("edicion", false);
        model.addAttribute("titulo", "Nuevo Docente");
        return "docente";
    }

    @PostMapping("/guardar")
    public String guardarDocente(@ModelAttribute("docente") Docente docente) {
        docenteRepository.save(docente);
        return "redirect:/docente/listado";
    }

    @GetMapping("/modificar/{legajo}")
    public String getModificarDocentePage(Model model, @PathVariable("legajo") Integer legajo) {
        Docente docente = docenteRepository.findById(legajo).orElse(null);
        model.addAttribute("docente", docente);
        model.addAttribute("edicion", true);
        model.addAttribute("titulo", "Modificar Docente");
        return "docente";
    }

    @PostMapping("/modificar")
    public String modificarDocente(@ModelAttribute("docente") Docente docente) {
        docenteRepository.save(docente);
        return "redirect:/docente/listado";
    }

    @GetMapping("/eliminar/{legajo}")
    public String eliminarDocente(@PathVariable("legajo") Integer legajo) {
        docenteRepository.deleteById(legajo);
        return "redirect:/docente/listado";
    }
}