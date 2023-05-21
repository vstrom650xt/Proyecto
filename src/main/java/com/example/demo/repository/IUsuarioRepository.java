package com.example.demo.repository;

import java.sql.SQLException;
import java.util.List;

public interface IUsuarioRepository {

    boolean addUsuario(Usuario usuario) throws SQLException;
    int updateUsuario(Usuario usuario) throws SQLException;
    int deleteUsuario(int id) throws  SQLException;
    List<Usuario> getUsuarios()throws  SQLException;

}
