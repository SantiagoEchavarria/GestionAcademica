package com.example.GestionAcademica.service.Alumno;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.GestionAcademica.modelos.Alumno;
import com.example.GestionAcademica.repository.AlumnoDAO;

@Service
public class AlumnoServicio implements AlumnoInterface {
    private final AlumnoDAO alumnoDAO;

    public AlumnoServicio(AlumnoDAO alumnoDAO) {
        this.alumnoDAO = alumnoDAO;
    }

    @Override
    public List<Alumno> obtenerTodosLosAlumnos() {
        return alumnoDAO.findAll();
    }

    @Override
    public Alumno obtenerAlumnoPorId(int id) {
        return alumnoDAO.findById(id).orElse(null);
    }

    @Override
    public void guardarAlumno(Alumno alumno) {
        alumnoDAO.save(alumno);
    }

    @Override
    public void eliminarAlumno(int id) {
        alumnoDAO.deleteById(id);
    }  
}
