package com.example.GestionAcademica.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.GestionAcademica.modelos.Materia;

@Repository
public interface MateriaDAO extends JpaRepository<Materia, Integer> {
}
