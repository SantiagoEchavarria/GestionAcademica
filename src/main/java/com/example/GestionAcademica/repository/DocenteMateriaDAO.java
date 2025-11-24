package com.example.GestionAcademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GestionAcademica.modelos.DocenteMateria;
@Repository
public interface DocenteMateriaDAO extends JpaRepository<DocenteMateria, Long>{
    
}
