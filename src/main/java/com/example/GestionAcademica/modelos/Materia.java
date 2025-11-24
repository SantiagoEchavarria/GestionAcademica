package com.example.GestionAcademica.modelos;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "materias")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{materia.nombre.notblank}")
    @Size(min = 2, max = 50, message = "{materia.nombre.size}")
    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$", message = "{materia.nombre.pattern}")
    @Column(name = "nombre", nullable = false, length = 50, unique = true)
    private String nombre;

    @NotBlank(message = "{materia.area.notblank}")
    @Size(min = 2, max = 50, message = "{materia.area.size}")
    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$", message = "{materia.area.pattern}")
    @Column(name = "area", nullable = false, length = 50)
    private String area;

    @OneToMany
    List<DocenteMateria> docenteMateria;    

    public Materia(Long id,
            @NotBlank(message = "{materia.nombre.notblank}") @Size(min = 2, max = 50, message = "{materia.nombre.size}") @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$", message = "{materia.nombre.pattern}") String nombre,
            @NotBlank(message = "{materia.area.notblank}") @Size(min = 2, max = 50, message = "{materia.area.size}") @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$", message = "{materia.area.pattern}") String area,
            List<DocenteMateria> docenteMateria) {
        this.id = id;
        this.nombre = nombre;
        this.area = area;
        this.docenteMateria = docenteMateria;
    }

    // Constructor vacío (obligatorio para JPA)
    public Materia() {}

    // Constructor con parámetros
    

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DocenteMateria> getDocenteMateria() {
        return docenteMateria;
    }

    public void setDocenteMateria(List<DocenteMateria> docenteMateria) {
        this.docenteMateria = docenteMateria;
    }

   

 
}

