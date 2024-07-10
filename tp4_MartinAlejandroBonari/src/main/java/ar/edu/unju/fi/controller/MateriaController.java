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

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.services.ICarreraService;
import ar.edu.unju.fi.services.IDocenteService;
import ar.edu.unju.fi.services.IMateriaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    private MateriaDTO materiaDTO;

    @Autowired
    private IMateriaService materiaService;

    @Autowired
    private ICarreraService carreraService;

    @Autowired
    private IDocenteService docenteService;

    @GetMapping("/listado")
    public String getListaMateriasPage(Model model) {
        model.addAttribute("titulo", "Materias");
        model.addAttribute("materias", materiaService.listaMateria());
        return "/eMateria/materias";
    }

    @GetMapping("/nuevo")
    public String getNuevaMateriaPage(Model model) {
        model.addAttribute("titulo", "Nueva Materia");
        model.addAttribute("materia", materiaDTO);
        model.addAttribute("edicion", false);
        model.addAttribute("docentes", docenteService.mostrarDocentesNoAsignados());
        model.addAttribute("carreras", carreraService.getAllCarreras());
        return "/eMateria/materia";
    }

    @PostMapping("/guardar")
    public ModelAndView guardarMateria(@Valid @ModelAttribute("materia") MateriaDTO materiaDTO, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView modelView = new ModelAndView("/eMateria/materia");
            modelView.addObject("docentes", docenteService.mostrarDocentesNoAsignados());
            modelView.addObject("carreras", carreraService.getAllCarreras());
            return modelView;
        }
        materiaService.crearMateria(materiaDTO);
        ModelAndView modelView = new ModelAndView("redirect:/materia/listado");
        modelView.addObject("materias", materiaService.listaMateria());
        return modelView;
    }

    @GetMapping("/modificar/{id}")
    public String getModificarMateriaPage(Model model, @PathVariable("id") Integer id) {
        MateriaDTO materia = materiaService.buscarMateria(id);
        model.addAttribute("materia", materia);
        model.addAttribute("edicion", true);
        model.addAttribute("docentes", docenteService.mostrarDocentesNoAsignados());
        model.addAttribute("carreras", carreraService.getAllCarreras());
        return "/eMateria/materia";
    }

    @PostMapping("/modificar")
    public String modificarMateria(@ModelAttribute("materia") MateriaDTO materiaDTO) {
        materiaService.modificarMateria(materiaDTO);
        return "redirect:/materia/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMateria(@PathVariable("id") Integer id) {
        MateriaDTO materiafindDTO = materiaService.buscarMateria(id);
        materiaService.eliminarMateria(materiafindDTO);
        return "redirect:/materia/listado";
    }
}
