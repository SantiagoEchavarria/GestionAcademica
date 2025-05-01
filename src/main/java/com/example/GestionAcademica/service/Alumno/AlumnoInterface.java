package com.example.GestionAcademica.service.Alumno;

import java.util.List;
import com.example.GestionAcademica.modelos.Alumno;


public interface AlumnoInterface {
   
    List<Alumno> obtenerTodosLosAlumnos();
    Alumno obtenerAlumnoPorId(int id);
    void guardarAlumno(Alumno alumno);
    void eliminarAlumno(int id);

}
