package com.example.GestionAcademica.controllers;

import com.example.GestionAcademica.modelos.Comportamiento;
import com.example.GestionAcademica.service.comportamiento.ComportamientoInterface;
import com.example.GestionAcademica.service.Alumno.AlumnoInterface;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@RequestMapping("/comportamiento")
@SessionAttributes("comportamiento")
public class ComportamientoController {

    private final ComportamientoInterface comportamientoServicio;
    private final AlumnoInterface alumnoServicio;

    public ComportamientoController(ComportamientoInterface comportamientoServicio,
                                    AlumnoInterface alumnoServicio) {
        this.comportamientoServicio = comportamientoServicio;
        this.alumnoServicio = alumnoServicio;
    }

    // Mostrar formulario nuevo comportamiento
    @GetMapping("/nuevo")
    public String nuevoComportamiento(Model model) {
        model.addAttribute("comportamiento", new Comportamiento());
        model.addAttribute("alumnos", alumnoServicio.obtenerTodosLosAlumnos());
        return "comportamiento/nuevo-comportamiento";
    }

    // Guardar comportamiento
    @PostMapping("/guardar")
    public String guardarComportamiento(@Valid @ModelAttribute Comportamiento comportamiento,
                                        BindingResult errors,
                                        Model model,
                                        RedirectAttributes flash,
                                        SessionStatus status) {
        if (errors.hasErrors()) {
            model.addAttribute("alumnos", alumnoServicio.obtenerTodosLosAlumnos());
            model.addAttribute("errors", "Corrige los errores del formulario.");
            return "comportamiento/nuevo-comportamiento";
        }

        comportamientoServicio.guardarComportamiento(comportamiento);
        status.setComplete();
        flash.addFlashAttribute("success", "Comportamiento registrado correctamente.");
        return "redirect:/comportamiento/lista";
    }

    // Lista de comportamientos
    @GetMapping("/lista")
    public String listaComportamientos(Model model) {
        List<Comportamiento> comportamientos = comportamientoServicio.obtenerTodosLosComportamientos();
        model.addAttribute("comportamientos", comportamientos);
        return "comportamiento/lista-comportamientos";
    }

    // Consultar comportamiento
    @GetMapping("/consultar/{id}")
    public String consultarComportamiento(@PathVariable int id, Model model) {
        Comportamiento comportamiento = comportamientoServicio.obtenerComportamientoPorId(id);
        if (comportamiento != null) {
            model.addAttribute("comportamiento", comportamiento);
            return "comportamiento/consultar-comportamiento";
        }
        return "redirect:/comportamiento/lista";
    }

    // Editar comportamiento
    @GetMapping("/editar/{id}")
    public String editarComportamiento(@PathVariable int id, Model model) {
        Comportamiento comportamiento = comportamientoServicio.obtenerComportamientoPorId(id);
        if (comportamiento != null) {
            model.addAttribute("comportamiento", comportamiento);
            model.addAttribute("alumnos", alumnoServicio.obtenerTodosLosAlumnos());
            return "comportamiento/editar-comportamiento";
        }
        return "redirect:/comportamiento/lista";
    }

    // Eliminar comportamiento
    @GetMapping("/eliminar/{id}")
    public String eliminarComportamiento(@PathVariable int id) {
        comportamientoServicio.eliminarComportamiento(id);
        return "redirect:/comportamiento/lista";
    }
}
