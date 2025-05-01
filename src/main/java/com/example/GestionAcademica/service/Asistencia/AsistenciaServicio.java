package com.example.GestionAcademica.service.Asistencia;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.GestionAcademica.modelos.Asistencia;
import com.example.GestionAcademica.repository.AsistenciaDAO;

@Service
public class AsistenciaServicio implements AsistenciaInterface {

   private final AsistenciaDAO asistenciaDAO;

   public AsistenciaServicio(AsistenciaDAO asistenciaDAO) {
    this.asistenciaDAO = asistenciaDAO;
   }

   @Override
   public List<Asistencia> obtenerTodasLasAsistencias() {
      return asistenciaDAO.findAll();
   }

   @Override
   public Asistencia obtenerAsistenciaPorId(int id) {
    return asistenciaDAO.findById(id).orElse(null);
   }

   @Override
   public void guardarAsistencia(Asistencia asistencia) {
     asistenciaDAO.save(asistencia);
   }

   @Override
   public void eliminarAsistencia(int id) {
      asistenciaDAO.deleteById(id);
   }

   
    
}
