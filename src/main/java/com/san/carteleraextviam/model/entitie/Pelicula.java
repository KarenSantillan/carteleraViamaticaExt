package com.san.carteleraextviam.model.entitie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_pelicula", nullable = false)
    private Integer idPelicula;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "duracion", nullable = false)
    private Integer duracion;
    @Basic
    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(idPelicula, pelicula.idPelicula) && Objects.equals(nombre, pelicula.nombre) && Objects.equals(duracion, pelicula.duracion) && Objects.equals(deleted, pelicula.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPelicula, nombre, duracion, deleted);
    }
}
