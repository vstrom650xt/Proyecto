package com.example.demo.repository;

import java.sql.SQLException;
import java.util.List;

public interface IUsuarioRepository {

    boolean addUsuario(Usuario usuario) throws SQLException;
    Usuario updateUsuario(Usuario usuario) throws SQLException;
    boolean deleteUsuario(int id) throws  SQLException;
    List<Usuario> getUsuarios();

}
