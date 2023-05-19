package com.example.demo.repository;

import java.sql.SQLException;

public interface IUsuarioRepository {

    Usuario addUsuario(Usuario usuario) throws SQLException;
    Usuario updateUsuario(Usuario usuario) throws SQLException;
    boolean deleteUsuario(int id) throws  SQLException;

}
