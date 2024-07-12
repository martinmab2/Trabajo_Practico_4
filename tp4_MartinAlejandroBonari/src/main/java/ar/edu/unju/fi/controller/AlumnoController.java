package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.services.IAlumnoService;
import ar.edu.unju.fi.services.ICarreraService;
import ar.edu.unju.fi.services.IMateriaService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;
    
    @Autowired
    private AlumnoDTO alumnoDTO;

    @Autowired
    private IMateriaService materiaService;
    
    @Autowired
    private ICarreraService carreraService;
    

    @GetMapping("/listado")
    
    public String getListaAlumnosPage(Model model) {
        model.addAttribute("alumnos", alumnoService.getAllALumnos());
        model.addAttribute("titulo", "Alumnos");
        return "eAlumno/alumnos";
    }

    @GetMapping("/nuevo")
    public String getNuevoAlumnoPage(Model model) {
    	model.addAttribute("titulo", "Nuevo Alumno");
        model.addAttribute("alumno",  alumnoDTO);
        model.addAttribute("edicion", false);
        model.addAttribute("carreras", carreraService.getAllCarreras());
        return "eAlumno/alumno";
    }

    @PostMapping("/guardar")
    public ModelAndView crearAlumno(@Valid @ModelAttribute("alumno") AlumnoDTO alumnoDTO, BindingResult result) {
        ModelAndView modelView;
        if (result.hasErrors()) {
            modelView = new ModelAndView("eAlumno/alumno");
            
            modelView.addObject("carreras", carreraService.getAllCarreras());
            modelView.addObject("alumno", alumnoDTO);
            modelView.addObject("edicion", false);
            modelView.addObject("titulo", "Nuevo Alumno");
        } else {
            modelView = new ModelAndView("redirect:/alumno/listado");
            alumnoService.crearAlumno(alumnoDTO);
        }
        return modelView;
    }

    @GetMapping("/modificar/{id}")
    public String getModificarAlumnoPage(Model model, @PathVariable("id") Long id) {
        AlumnoDTO alumno = alumnoService.buscarAlumno(id);
        if (alumno != null) {
            model.addAttribute("edicion", true);
            model.addAttribute("alumno", alumno);
            model.addAttribute("titulo", "Modificar Alumno");
            model.addAttribute("carreras", carreraService.getAllCarreras());
            return "eAlumno/alumno";
        } else {
            return "redirect:/alumno/listado";
        }
    }

    @PostMapping("/modificar")
    public String modificarAlumno(@Valid @ModelAttribute("alumno") AlumnoDTO alumnoDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "eAlumno/alumno";
        } else {
            alumnoService.modificarAlumno(alumnoDTO);
            return "redirect:/alumno/listado";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable("id") Long id) {

        alumnoService.eliminarAlumno(id);
        return "redirect:/alumno/listado";
    }
    
    @GetMapping("/alumno/filtrar")
    public String getFormularioFiltrarPage(Model model) {
    	List<MateriaDTO> materias = materiaService.getAllMaterias();
    	model.addAttribute("titulo", "Filtrar Alumnos por Materia");
    	model.addAttribute("materias", materias);
        return "/consulta/filtrarAlumno"; 
    }
    
    @PostMapping("/alumno/filtrar")
    public String filtrarAlumnosPorMateria(@RequestParam(value = "materiaId", required = false) Integer materiaId,
                                           Model model, RedirectAttributes redirectAttributes) {
        if (materiaId == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "No se seleccionó ninguna materia.");
            return "redirect:/alumno/filtrar";
        }

        MateriaDTO materia = materiaService.buscarMateria(materiaId);

        if (materia != null) {
            List<AlumnoDTO> alumnos = alumnoService.getAlumnosByMateria (materia);
            model.addAttribute("alumnos", alumnos);
            model.addAttribute("materia", materia);
            return "consulta/filtrarAlumno"; // Nombre de la plantilla Thymeleaf para mostrar los alumnos
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "No se encontró la materia.");
            return "redirect:/form/inscribir";
        }
    }

}
