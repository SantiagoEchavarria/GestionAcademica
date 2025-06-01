package com.example.GestionAcademica.service.Docente;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.GestionAcademica.modelos.Docente;
import com.example.GestionAcademica.repository.DocenteDAO;
@Service
public class DocenteServicio implements DocenteInterface {

    private final DocenteDAO docenteDAO;
  
    public DocenteServicio(DocenteDAO docenteDAO) {
        this.docenteDAO = docenteDAO;
    }
    
    @Override
    public List<Docente> obtenerTodosLosDocentes() {
       return docenteDAO.findAll();
    }

    @Override
    public Docente obtenerDocentePorId(int id) {
        return docenteDAO.findById(id).orElse(null);
    }

    @Override
    public void guardarDocente(Docente docente) {
        docenteDAO.save(docente);
    }

    @Override
    public void eliminarDocente(int id) {
        docenteDAO.deleteById(id);
    }

}
