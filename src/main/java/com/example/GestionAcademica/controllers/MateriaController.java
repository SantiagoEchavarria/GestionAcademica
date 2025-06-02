package com.example.GestionAcademica.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.GestionAcademica.modelos.Materia;
import com.example.GestionAcademica.service.Docente.DocenteInterface;
import com.example.GestionAcademica.service.Materia.MateriaInterface;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/materia")
@SessionAttributes("materia")
public class MateriaController {
    private final MateriaInterface materiaServicio;
    private final DocenteInterface docenteServicio;
    public MateriaController(MateriaInterface materiaServicio, DocenteInterface docenteServicio) {
        this.docenteServicio = docenteServicio;
        this.materiaServicio = materiaServicio;
    }

    // Mostrar formulario nuevo gateria
    @GetMapping("/nuevo")
    public String nuevoMateria(Model model) {
        model.addAttribute("materia", new Materia());
        model.addAttribute("docentes", docenteServicio.obtenerTodosLosDocentes());
        return "materia/nuevo-materia";
    }

    // Guardar gateria
    @PostMapping("/guardar")
    public String guardarMateria(@Valid @ModelAttribute Materia materia,
                               BindingResult errors,
                               Model model,
                               RedirectAttributes flash,
                               SessionStatus status) {

        if (errors.hasErrors()) {
            model.addAttribute("errors", "Corrige los errores del formulario.");
            return "materia/nuevo-materia";
        }

        materiaServicio.guardarMateria(materia);
        status.setComplete();
        flash.addFlashAttribute("success", "Materia guardado exitosamente.");
        return "redirect:/materia/lista";
    }

    // Lista de gaterias
    @GetMapping("/lista")
    public String listaMaterias(Model model) {
        List<Materia> gaterias = materiaServicio.listarMaterias();
        model.addAttribute("materias", gaterias);
        return "materia/lista-materias";
    }

    // Consultar gateria
    @GetMapping("/consultar/{id}")
    public String consultarGateria(@PathVariable int id, Model model) {
        Materia materia = materiaServicio.obtenerMateriaPorId(id);
        if (materia != null) {
            model.addAttribute("materia", materia);
            return "materia/consultar-gateria";
        }
        return "redirect:/materia/lista";
    }

    // Editar gateria
    @GetMapping("/editar/{id}")
    public String editarGateria(@PathVariable int id, Model model) {
        Materia materia = materiaServicio.obtenerMateriaPorId(id);
        if (materia != null) {
            model.addAttribute("materia", materia);
            return "materia/nuevo-materia";
        }
        return "redirect:/materia/lista";
    }

    // Eliminar gateria
    @GetMapping("/eliminar/{id}")
    public String eliminarGateria(@PathVariable int id) {
        materiaServicio.eliminarMateria(id);
        return "redirect:/materia/lista";
    }
}
