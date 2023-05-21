package com.example.demo.service;

import com.example.demo.repository.IOficioRepository;
import com.example.demo.repository.Oficio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service

public class OficioService {
    @Autowired
    public IOficioRepository repository;


    public List<Oficio> getOficios(int id) throws SQLException {

        return  repository.getOficios(id);
    }
}
