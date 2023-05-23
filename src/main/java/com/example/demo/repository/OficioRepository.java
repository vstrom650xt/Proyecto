package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class OficioRepository implements IOficioRepository {
    @Override
    public List<Oficio> getOficios() throws SQLException {
        DataSource ds = MyDataSource.getMySQLDataSource();
        String query = "{call obtener_oficios(?)}";
        ArrayList<Oficio> oficios = new ArrayList<>();


        try (Connection connection = ds.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)
        ) {
            // esto es para en la api poder pasarle null y que lo interprete bien
            callableStatement.setNull(1,0);
            // callableStatement.setInt(1 ,id);
            ResultSet rs = callableStatement.executeQuery();
            Oficio oficio;
            while (rs.next()) {
                oficio = new Oficio(rs.getInt(1), rs.getString(2));
                oficios.add(oficio);
            }


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return oficios;
    }
}
