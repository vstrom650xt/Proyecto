package com.example.demo.repository;

import java.sql.SQLException;
import java.util.List;

public interface IOficioRepository {
    List<Oficio> getOficios()throws SQLException;
    //FALTA FOTO

}
