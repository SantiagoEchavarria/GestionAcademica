package com.example.GestionAcademica.service.grupo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.GestionAcademica.modelos.Grupo;
import com.example.GestionAcademica.repository.GrupoDAO;
@Service
public class GrupoServicio implements GrupoInterface {
    
    private final GrupoDAO grupoDAO;

    public GrupoServicio(GrupoDAO grupoDAO) {
        this.grupoDAO = grupoDAO;
    }

    @Override
    public List<Grupo> obtenerTodosLosGrupos() {
        return grupoDAO.findAll();
    }

    @Override
    public Grupo obtenerGrupoPorId(int id) {
        return grupoDAO.findById(id).orElse(null);
    }

    @Override
    public void guardarGrupo(Grupo grupo) {
        grupoDAO.save(grupo);
    }

    @Override
    public void eliminarGrupo(int id) {
        grupoDAO.deleteById(id);
    }

    
}
