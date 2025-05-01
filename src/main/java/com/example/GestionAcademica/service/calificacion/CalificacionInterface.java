package com.example.GestionAcademica.service.calificacion;

import java.util.List;
import com.example.GestionAcademica.modelos.Calificacion;

public interface CalificacionInterface {
    List<Calificacion> obtenerTodasLasCalificaciones();
    Calificacion obtenerCalificacionPorId(int id);
    void guardarCalificacion(Calificacion calificacion);
    void eliminarCalificacion(int id);
}
