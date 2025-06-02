package com.example.GestionAcademica.service.logro;

import java.util.List;

import com.example.GestionAcademica.modelos.Logro;
import com.example.GestionAcademica.repository.LogroDAO;

public class LogroServicio implements LogroInterface {

    private final LogroDAO logroDAO;

    public LogroServicio(LogroDAO logroDAO) {
        this.logroDAO = logroDAO;
    }

    @Override
    public void crearLogro(Logro logro) {
        logroDAO.save(logro);
    }

    @Override
    public void actualizarLogro(int id, String descripcion) {
        Logro logroExistente = logroDAO.findById(id).orElseThrow(() -> new RuntimeException("Logro no encontrado"));
        logroExistente.setDescripcion(descripcion);
        logroDAO.save(logroExistente);
    }

    @Override
    public void eliminarLogro(int id) {
        logroDAO.deleteById(id);
    }

    @Override
    public List<String> listarLogros() {
        return logroDAO.findAll().stream()
                .map(Logro::getDescripcion)
                .toList();
    }

    @Override
    public Logro obtenerLogroPorId(int id) {
        return logroDAO.findById(id).orElseThrow(() -> new RuntimeException("Logro no encontrado"));
    }
    
}
