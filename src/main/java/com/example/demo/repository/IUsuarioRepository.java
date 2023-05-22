package com.example.demo.repository;

import java.sql.SQLException;
import java.util.List;

public interface IUsuarioRepository {

    Usuario addUsuario(Usuario usuario) throws SQLException;
    Usuario updateUsuario(Usuario usuario) throws SQLException;
    Usuario deleteUsuario(int id) throws  SQLException;
    List<Usuario> getUsuarios()throws  SQLException;

}
