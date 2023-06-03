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

        DataSource ds = MyDataSource.getMySQLDataSource();
        String query = "{call crear_usuario(?,?,?,?,?)}";
        Usuario usuario1;
        try (Connection connection = ds.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)
        ) {
// los de salida callablestatement (out ) si es (IN) usuarios.getLoqsea(); todo lo q sea out en bbdd  aqui es registerOutPARAMETRE
            callableStatement.registerOutParameter(1,Types.INTEGER);

            callableStatement.setInt(2, usuario.getIdUsuario());
            callableStatement.setString(3, usuario.getNombre());;
            callableStatement.setString(4, usuario.getApellidos());
            callableStatement.setInt(5, usuario.getIdOficio());
            callableStatement.executeUpdate();
            usuario1 = new Usuario(callableStatement.getInt(1), usuario.getNombre(),usuario.getApellidos(), usuario.getIdOficio());

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
        Usuario usuario1;
        try (Connection connection = ds.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)
        ) {
            callableStatement.registerOutParameter(1,Types.INTEGER);
            callableStatement.setInt(2, usuario.getIdUsuario());
            callableStatement.setString(3, usuario.getNombre());;
            callableStatement.setString(4, usuario.getApellidos());
            callableStatement.setInt(5, usuario.getIdOficio());
            callableStatement.executeUpdate();
            usuario1 = new Usuario((usuario.getIdUsuario()), usuario.getNombre(),usuario.getApellidos(), usuario.getIdOficio());

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
        try (Connection con = ds.getConnection();
             CallableStatement callableStatement = con.prepareCall(query)
        ) {
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.setInt(2, id);
            boolean hasResults = callableStatement.execute();
            if (hasResults) {
                ResultSet rs = callableStatement.getResultSet();
                if (rs.next()) {
                    usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                }
                rs.close();
            }
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
