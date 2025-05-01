package com.example.GestionAcademica.service.Asistencia;

import java.util.List;

import com.example.GestionAcademica.modelos.Asistencia;

public interface AsistenciaInterface {
    List<Asistencia> obtenerTodasLasAsistencias();
    Asistencia obtenerAsistenciaPorId(int id);
    void guardarAsistencia(Asistencia asistencia);
    void eliminarAsistencia(int id);
}
