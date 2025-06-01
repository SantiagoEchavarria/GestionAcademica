package com.example.GestionAcademica.service.Materia;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.GestionAcademica.modelos.Materia;
import com.example.GestionAcademica.repository.MateriaDAO;
@Service
public class MateriaServicio implements MateriaInterface {

    private final MateriaDAO materiaDAO;

    public MateriaServicio(MateriaDAO materiaDAO) {
        this.materiaDAO = materiaDAO;
    }
    
    @Override
    public List<Materia> listarMaterias() {
        return materiaDAO.findAll();
    }

    @Override
    public Materia obtenerMateriaPorId(int id) {
     
        return materiaDAO.findById(id).orElse(null);
    }

    @Override
    public void guardarMateria(Materia materia) {
        materiaDAO.save(materia);
    }

   @Override
    public void actualizarMateria(int id, Materia materia) {
    if (materiaDAO.existsById(id)) {
        materia.setId(id); 
        materiaDAO.save(materia);
    }
}


    @Override
    public void eliminarMateria(int id) {
        materiaDAO.deleteById(id);
    }

}
