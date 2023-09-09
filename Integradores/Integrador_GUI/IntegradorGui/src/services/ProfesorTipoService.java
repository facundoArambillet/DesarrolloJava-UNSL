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
import models.ProfesorTipo;
import security.Conexion;

public class ProfesorTipoService {
    
    public ProfesorTipoService() {
        
    }
    
    public List<ProfesorTipo> mostrarTodos() {
            List<ProfesorTipo> profesorTipos = new ArrayList<>();

            try {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "SELECT * FROM profesor_tipos";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    int idProfesorTipo = resultSet.getInt("id_tipo");
                    String nombreTipo = resultSet.getString("tipo");
                    ProfesorTipo profesorTipo = new ProfesorTipo(nombreTipo);
                    profesorTipo.setIdTipo(idProfesorTipo);
                    profesorTipos.add(profesorTipo);
                }

                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
            }

            return profesorTipos;
    }

    public ProfesorTipo mostrarPorTipo(String tipo) {
        ProfesorTipo profesorTipoEncontrado = null;

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM profesor_tipos WHERE tipo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tipo.toLowerCase());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idProfesorTipo = resultSet.getInt("id_tipo");
                String nombreProfesorTipo = resultSet.getString("tipo");

                profesorTipoEncontrado = new ProfesorTipo(nombreProfesorTipo);
                profesorTipoEncontrado.setIdTipo(idProfesorTipo);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return profesorTipoEncontrado;
    }

    public ProfesorTipo mostrarPorID(int id) {
        ProfesorTipo profesorTipoEncontrado = null;

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM profesor_tipos WHERE id_tipo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idProfesorTipo = resultSet.getInt("id_tipo");
                String nombreProfesorTipo = resultSet.getString("tipo");

                profesorTipoEncontrado = new ProfesorTipo(nombreProfesorTipo);
                profesorTipoEncontrado.setIdTipo(idProfesorTipo);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return profesorTipoEncontrado;
    }
    
    public ProfesorTipo crearProfesorTipo(ProfesorTipo profesorTipo) {
        try {
            if(this.mostrarPorTipo(profesorTipo.getTipo()) == null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "INSERT INTO profesor_tipos (tipo) VALUES (?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, profesorTipo.getTipo().toLowerCase());

                preparedStatement.executeUpdate();
                //System.out.println("Profesor tipo creado");
                preparedStatement.close();
                connection.close();
                
                return profesorTipo;
            } 
            else {
                System.out.println("El profesor tipo ya existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void actualizarProfesorTipo(String tipo,ProfesorTipo profesorTipo) {
        try {
            if(this.mostrarPorTipo(tipo) != null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "UPDATE profesor_tipos SET tipo = ? WHERE = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, profesorTipo.getTipo().toLowerCase());
                preparedStatement.setString(2, tipo.toLowerCase());
                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
            }
            else {
                System.out.println("El Profesor tipo no existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarCurso(int idProfesorTipo) {
        try {
            if(this.mostrarPorID(idProfesorTipo) != null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "DELETE FROM profesor_tipos WHERE id_tipo = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, idProfesorTipo);

                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
            }
            else {
                System.out.println("El id del profesor tipo no es valido");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
