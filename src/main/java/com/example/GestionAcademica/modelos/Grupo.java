package com.example.GestionAcademica.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "grupos")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "El nombre del grupo no puede estar vacío")
    @Size(max = 50, message = "El nombre del grupo no puede tener más de 50 caracteres")
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @NotBlank(message = "El grado no puede estar vacío")
    @Size(max = 20, message = "El grado no puede tener más de 20 caracteres")
    @Column(name = "grado", nullable = false, length = 20)
    private String grado;

    @NotNull(message = "El año no puede ser nulo")
    @Column(name = "año", nullable = false)
    private int año;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alumno> alumnos;

    // Constructor vacío requerido por JPA
    public Grupo() {
    }

    // Constructor con argumentos
    public Grupo(String nombre, String grado, int año) {
        this.nombre = nombre;
        this.grado = grado;
        this.año = año;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
