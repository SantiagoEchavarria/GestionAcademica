package com.example.GestionAcademica.controllers;

import com.example.GestionAcademica.modelos.Asistencia;
import com.example.GestionAcademica.service.Asistencia.AsistenciaInterface;
import com.example.GestionAcademica.service.Alumno.AlumnoInterface;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/asistencia")
@SessionAttributes("asistencia")
public class AsistenciaController {

    private final AsistenciaInterface asistenciaServicio;
    private final AlumnoInterface alumnoServicio;

    public AsistenciaController(AsistenciaInterface asistenciaServicio, AlumnoInterface alumnoServicio) {
        this.asistenciaServicio = asistenciaServicio;
        this.alumnoServicio = alumnoServicio;
    }

    // Mostrar formulario para nueva asistencia
    @GetMapping("/nueva")
    public String nuevaAsistencia(Model model) {
        model.addAttribute("asistencia", new Asistencia());
        model.addAttribute("alumnos", alumnoServicio.obtenerTodosLosAlumnos());
        return "asistencia/nueva-asistencia";
    }

    // Guardar asistencia
    @PostMapping("/guardar")
    public String guardarAsistencia(@Valid @ModelAttribute Asistencia asistencia, BindingResult errors,
                                    Model model, RedirectAttributes flash, SessionStatus status) {
        if (errors.hasErrors()) {
            model.addAttribute("alumnos", alumnoServicio.obtenerTodosLosAlumnos());
            model.addAttribute("errors", "Corrige los errores en el formulario.");
            return "asistencia/nueva-asistencia";
        }
        asistenciaServicio.guardarAsistencia(asistencia);
        status.setComplete();
        flash.addFlashAttribute("success", "Asistencia registrada correctamente.");
        return "redirect:/asistencia/lista";
    }

    // Lista de asistencias
    @GetMapping("/lista")
    public String listaAsistencias(Model model) {
        List<Asistencia> asistencias = asistenciaServicio.obtenerTodasLasAsistencias();
        model.addAttribute("asistencias", asistencias);
        return "asistencia/lista-asistencias";
    }

    // Consultar asistencia
    @GetMapping("/consultar/{id}")
    public String consultarAsistencia(@PathVariable int id, Model model) {
        Asistencia asistencia = asistenciaServicio.obtenerAsistenciaPorId(id);
        if (asistencia != null) {
            model.addAttribute("asistencia", asistencia);
        } else {
            return "redirect:/asistencia/lista";
        }
        return "asistencia/consultar-asistencia";
    }

    // Eliminar asistencia
    @GetMapping("/eliminar/{id}")
    public String eliminarAsistencia(@PathVariable int id) {
        asistenciaServicio.eliminarAsistencia(id);
        return "redirect:/asistencia/lista";
    }

    // Editar asistencia
    @GetMapping("/editar/{id}")
    public String editarAsistencia(@PathVariable int id, Model model) {
        Asistencia asistencia = asistenciaServicio.obtenerAsistenciaPorId(id);
        if (asistencia != null) {
            model.addAttribute("asistencia", asistencia);
            model.addAttribute("alumnos", alumnoServicio.obtenerTodosLosAlumnos());
            return "asistencia/editar-asistencia";
        }
        return "redirect:/asistencia/lista";
    }
}
