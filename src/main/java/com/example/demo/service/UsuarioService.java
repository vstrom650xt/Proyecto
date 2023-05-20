package com.example.demo.service;

import com.example.demo.repository.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    public UsuarioRepository repository;


    public boolean addUsuario(Usuario usuario) throws SQLException {
        return repository.addUsuario(usuario);
    }


    public Usuario updateUsuario(Usuario usuario) {
        return null;

    }

    public boolean deleteUsuario(int id) {
        return true;

    }

    public List<Usuario> getUsuarios() throws SQLException { //si no se pone aqui la excepcion da error en el controler
        return repository.getUsuarios();

    }
}
