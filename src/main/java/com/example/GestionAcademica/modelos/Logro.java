package com.example.GestionAcademica.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "logros")
public class Logro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "descripcion", nullable = false, length = 255)
    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(max = 255, message = "La descripción no puede tener más de 255 caracteres")
    @Pattern(regexp = "^[A-Za-z0-9áéíóúÁÉÍÓÚñÑ ,.-]+$", message = "La descripción solo puede contener letras, números y algunos caracteres especiales")
    String descripcion;

    public Logro() {
    }

    public Logro(int id,
            @NotBlank(message = "La descripción no puede estar vacía") @Size(max = 255, message = "La descripción no puede tener más de 255 caracteres") @Pattern(regexp = "^[A-Za-z0-9áéíóúÁÉÍÓÚñÑ ,.-]+$", message = "La descripción solo puede contener letras, números y algunos caracteres especiales") String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Logro [id=" + id + ", descripcion=" + descripcion + "]";
    }

}
