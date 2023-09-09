package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.UsuarioTipo;
import security.Conexion;

public class UsuarioTipoService {
    
    public UsuarioTipoService() {
        
    }
    
    public List<UsuarioTipo> mostrarTodos() {
            List<UsuarioTipo> usuarioTipos = new ArrayList<>();

            try {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "SELECT * FROM usuario_tipos";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    int idTipo = resultSet.getInt("id_tipo");
                    String tipo = resultSet.getString("tipo");
                    UsuarioTipo usuarioTipo = new UsuarioTipo(tipo);
                    usuarioTipo.setIdTipo(idTipo);
                    usuarioTipos.add(usuarioTipo);
                }

                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
            }

            return usuarioTipos;
    }

    public UsuarioTipo mostrarPorTipo(String tipo) {
        UsuarioTipo tipoEncontrado = null;

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM usuario_tipos WHERE tipo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tipo.toLowerCase());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idTipo = resultSet.getInt("id_tipo");
                String nombreTipo = resultSet.getString("tipo");

                tipoEncontrado = new UsuarioTipo(nombreTipo);
                tipoEncontrado.setIdTipo(idTipo);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tipoEncontrado;
    }

    public UsuarioTipo mostrarPorID(int id) {
        UsuarioTipo tipoEncontrado = null;

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM usuario_tipos WHERE id_tipo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idTipo = resultSet.getInt("id_tipo");
                String nombreTipo = resultSet.getString("tipo");

                tipoEncontrado = new UsuarioTipo(nombreTipo);
                tipoEncontrado.setIdTipo(idTipo);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tipoEncontrado;
    }
    
    public UsuarioTipo crearTipoUsuario(UsuarioTipo usuarioTipo) {
        try {
            if(this.mostrarPorTipo(usuarioTipo.getTipo()) == null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "INSERT INTO usuario_tipos (tipo) VALUES (?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, usuarioTipo.getTipo().toLowerCase());

                preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();
                
                return usuarioTipo;
            } 
            else {
                System.out.println("El Tipo de usuario ya existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void actualizarTipoUsuario(String tipo, UsuarioTipo usuarioTipo) {
        try {
            if(this.mostrarPorTipo(tipo) != null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "UPDATE usuario_tipos SET tipo = ? WHERE tipo = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, usuarioTipo.getTipo().toLowerCase());
                preparedStatement.setString(2, tipo.toLowerCase());
                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
            }
            else {
                System.out.println("El tipo de usuario no existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarTipoUsuario(int idTipoUsuario) {
        try {
            if(this.mostrarPorID(idTipoUsuario) != null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "DELETE FROM usuario_tipos WHERE id_tipo = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, idTipoUsuario);

                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
            }
            else {
                System.out.println("El id del tipo de usuario no es valido");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
