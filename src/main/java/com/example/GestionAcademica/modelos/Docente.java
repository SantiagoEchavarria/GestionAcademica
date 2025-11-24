package com.example.GestionAcademica.modelos;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "docentes")
public class Docente {

      @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "{docente.nombre.notblank}")
    @Size(min = 2, max = 50, message = "{docente.nombre.size}")
    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$", message = "{docente.nombre.pattern}")
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @NotBlank(message = "{docente.apellido.notblank}")
    @Size(min = 2, max = 50, message = "{docente.apellido.size}")
    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$", message = "{docente.apellido.pattern}")
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @NotBlank(message = "{docente.email.notblank}")
    @Email(message = "{docente.email.email}")
    @Size(max = 100, message = "{docente.email.size}")
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @OneToMany(mappedBy = "docente", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<DocenteMateria> docenteMateria;

    public List<DocenteMateria> getDocenteMateria() {
        return docenteMateria;
    }

    public void setDocenteMateria(List<DocenteMateria> docenteMateria) {
        this.docenteMateria = docenteMateria;
    }

    public Docente() {}


    public Docente(int id,
            @NotBlank(message = "{docente.nombre.notblank}") @Size(min = 2, max = 50, message = "{docente.nombre.size}") @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$", message = "{docente.nombre.pattern}") String nombre,
            @NotBlank(message = "{docente.apellido.notblank}") @Size(min = 2, max = 50, message = "{docente.apellido.size}") @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$", message = "{docente.apellido.pattern}") String apellido,
            @NotBlank(message = "{docente.email.notblank}") @Email(message = "{docente.email.email}") @Size(max = 100, message = "{docente.email.size}") String email,
            List<DocenteMateria> docenteMateria) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.docenteMateria = docenteMateria;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método toString
    @Override
    public String toString() {
        return "Docente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

