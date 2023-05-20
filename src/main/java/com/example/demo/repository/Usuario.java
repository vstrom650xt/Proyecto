package com.example.demo.repository;


import lombok.*;

import java.util.Objects;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Usuario {
    private int idUsuario; //autoincrement
    private String nombre;
    private String apellidos;
    private int idOficio;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idUsuario == usuario.idUsuario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario);
    }
}
