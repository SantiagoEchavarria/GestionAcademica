package com.example.GestionAcademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.GestionAcademica.modelos.Grupo;

@Repository
public interface GrupoDAO extends JpaRepository<Grupo, Integer> {    
}
