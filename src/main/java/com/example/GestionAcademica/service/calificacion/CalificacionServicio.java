package com.example.GestionAcademica.service.calificacion;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.GestionAcademica.modelos.Calificacion;
import com.example.GestionAcademica.repository.CalificacionDAO;

@Service
public class CalificacionServicio implements CalificacionInterface {
    private final CalificacionDAO calificacionDAO;

    public CalificacionServicio(CalificacionDAO calificacionDAO) {
        this.calificacionDAO = calificacionDAO;
    }
    @Override
    public List<Calificacion> obtenerTodasLasCalificaciones() {
        return calificacionDAO.findAll();
    }

    @Override
    public Calificacion obtenerCalificacionPorId(int id) {
        return calificacionDAO.findById(id).orElse(null);
    }

    @Override
    public void guardarCalificacion(Calificacion calificacion) {
        calificacionDAO.save(calificacion);
    }

    @Override
    public void eliminarCalificacion(int id) {
        calificacionDAO.deleteById(id);
    }
    
}
