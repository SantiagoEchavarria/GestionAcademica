package com.example.GestionAcademica.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "materias")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$", message = "El nombre solo puede contener letras y espacios")
    @Column(name = "nombre", nullable = false, length = 50, unique = true)
    private String nombre;

    @NotBlank(message = "El área no puede estar vacía")
    @Size(min = 2, max = 50, message = "El área debe tener entre 2 y 50 caracteres")
    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$", message = "El área solo puede contener letras y espacios")
    @Column(name = "area", nullable = false, length = 50)
    private String area;

    @ManyToOne(optional = false)
    @JoinColumn(name = "docente_id", nullable = false)
    private Docente docente;

    // Constructor vacío (obligatorio para JPA)
    public Materia() {}

    // Constructor con parámetros
    public Materia(String nombre, String area, Docente docente) {
        this.nombre = nombre;
        this.area = area;
        this.docente = docente;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    // Método toString
    @Override
    public String toString() {
        return "Materia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", area='" + area + '\'' +
                ", docente=" + docente +
                '}';
    }
}

