package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//quitado throws  exception
@Repository
public class UsuarioRepository implements IUsuarioRepository{
    @Override
    public Usuario addUsuario(Usuario usuario){
        boolean insertado;
        Usuario usuario1 = null;
        DataSource ds = MyDataSource.getMySQLDataSource();
        String query = "{call crear_usuario(?,?,?,?,?)}";
        try (Connection connection = ds.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)
        ) {

            callableStatement.setInt(2, usuario.getIdUsuario());
            callableStatement.setString(3, usuario.getNombre());;
            callableStatement.setString(4, usuario.getApellidos());
            callableStatement.setInt(5, usuario.getIdOficio());


            insertado = callableStatement.executeUpdate() == 1;
            usuario1 = new Usuario(callableStatement.getInt(1), callableStatement.getString(2),callableStatement.getString(3),callableStatement.getInt(4));

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return usuario1;

    }

    @Override
    public Usuario updateUsuario(Usuario usuario){
        DataSource ds = MyDataSource.getMySQLDataSource();
        String query = "{? = call actualizar_usuario(?,?,?,?)}";
        int i;
        Usuario usuario1;
        try (Connection connection = ds.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)
        ) {

            callableStatement.setInt(2, usuario.getIdUsuario());
            callableStatement.setString(3, usuario.getNombre());;
            callableStatement.setString(4, usuario.getApellidos());
            callableStatement.setInt(5, usuario.getIdOficio());
            i = callableStatement.executeUpdate();
            usuario1 = new Usuario(callableStatement.getInt(1), callableStatement.getString(2),callableStatement.getString(3),callableStatement.getInt(4));


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return usuario1;
    }

    @Override
    public Usuario deleteUsuario(int id) {

        DataSource ds = MyDataSource.getMySQLDataSource();
        String query = "{ ? = call eliminar_usuario(?)}";
        Usuario usuario = null;
        int i = 0;
        try (Connection con = ds.getConnection();
             CallableStatement callableStatement = con.prepareCall(query)
        ) {
            callableStatement.registerOutParameter(1,Types.INTEGER);
            callableStatement.setInt(2,id);
           callableStatement.executeUpdate();
            usuario = new Usuario(callableStatement.getInt(1), callableStatement.getString(2),callableStatement.getString(3),callableStatement.getInt(4));
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return usuario;
    }

    @Override
    public List<Usuario> getUsuarios() {
        DataSource ds = MyDataSource.getMySQLDataSource();
        ArrayList<Usuario> empleados = new ArrayList<>();
        //se crea el statement
        try (Connection connection = ds.getConnection();
             //el statement execute the query
             Statement statement = connection.createStatement();
             //conjunto de resultados
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Usuario")
        ) {
            Usuario usuario;
            while (resultSet.next()) {
                usuario = new Usuario(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4));
                empleados.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return empleados;
    }


}
