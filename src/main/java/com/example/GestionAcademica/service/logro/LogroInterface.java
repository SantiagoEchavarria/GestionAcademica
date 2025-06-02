package com.example.GestionAcademica.service.logro;

import java.util.List;

import com.example.GestionAcademica.modelos.Logro;

public interface LogroInterface {
    void crearLogro(Logro logro);
    void actualizarLogro(int id, String descripcion);
    void eliminarLogro(int id);
    List<String> listarLogros();
    Logro obtenerLogroPorId(int id);
}
