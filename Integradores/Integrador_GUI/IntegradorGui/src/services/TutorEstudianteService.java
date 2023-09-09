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
import models.TutorEstudiante;
import security.Conexion;

public class TutorEstudianteService {
    
    public TutorEstudianteService() {
        
    }
    
    public List<TutorEstudiante> mostrarTodos() {
            List<TutorEstudiante> tutoresEstudiante = new ArrayList<>();

            try {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "SELECT * FROM tutores_estudiante";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    int idTutor = resultSet.getInt("id_tutor");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    long telefono = resultSet.getLong("telefono");
                    String direccion = resultSet.getString("direccion");
                    TutorEstudiante tutorEstudiante = new TutorEstudiante(nombre,apellido,telefono,direccion);
                    tutorEstudiante.setIdTutor(idTutor);
                    tutoresEstudiante.add(tutorEstudiante);
                }

                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
            }

            return tutoresEstudiante;
    }

    public TutorEstudiante mostrarPorNombre(String nombre) {
        TutorEstudiante tutorEncontrado = null;

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM tutores_estudiante WHERE nombre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombre.toLowerCase());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idTutor = resultSet.getInt("id_tutor");
                String nombreTutor = resultSet.getString("nombre");
                String apellidoTutor = resultSet.getString("apellido");
                long telefonoTutor = resultSet.getLong("telefono");
                String direccionTutor = resultSet.getString("direccion");
                tutorEncontrado = new TutorEstudiante(nombreTutor,apellidoTutor,telefonoTutor,direccionTutor);
                tutorEncontrado.setIdTutor(idTutor);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tutorEncontrado;
    }

    public TutorEstudiante mostrarPorID(int id) {
        TutorEstudiante tutorEncontrado = null;

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM tutores_estudiante WHERE id_tutor = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idTutor = resultSet.getInt("id_tutor");
                String nombreTutor = resultSet.getString("nombre");
                String apellidoTutor = resultSet.getString("apellido");
                long telefonoTutor = resultSet.getLong("telefono");
                String direccionTutor = resultSet.getString("direccion");
                tutorEncontrado = new TutorEstudiante(nombreTutor,apellidoTutor,telefonoTutor,direccionTutor);
                tutorEncontrado.setIdTutor(idTutor);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tutorEncontrado;
    }
    
    public TutorEstudiante crearTutorEstudiante(TutorEstudiante tutorEstudiante) {
        try {
            if(this.mostrarPorNombre(tutorEstudiante.getNombre()) == null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "INSERT INTO tutores_estudiante (nombre,apellido,telefono,direccion) VALUES (?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, tutorEstudiante.getNombre().toLowerCase());
                preparedStatement.setString(2, tutorEstudiante.getApellido().toLowerCase());
                preparedStatement.setLong(3, tutorEstudiante.getTelefono());
                preparedStatement.setString(4, tutorEstudiante.getDireccion().toLowerCase());
                
                preparedStatement.executeUpdate();
                //System.out.println("Tutor creado");
                preparedStatement.close();
                connection.close();
                
                return tutorEstudiante;
            } 
            else {
                System.out.println("El tutor ya existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void actualizarTutorEstudiante(int idTutor, TutorEstudiante tutorEstudiante) {
        try {
            if(this.mostrarPorID(idTutor) != null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "UPDATE tutores_estudiante SET nombre = ?, apellido = ?, telefono = ?, direccion = ? WHERE id_tutor = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, tutorEstudiante.getNombre().toLowerCase());
                preparedStatement.setString(2, tutorEstudiante.getApellido().toLowerCase());
                preparedStatement.setLong(3, tutorEstudiante.getTelefono());
                preparedStatement.setString(4, tutorEstudiante.getDireccion().toLowerCase());
                preparedStatement.setInt(5, idTutor);

                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
            }
            else {
                System.out.println("El tutor no existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarTutorEstudiante(int idTutor) {
        try {
            if(this.mostrarPorID(idTutor) != null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "DELETE FROM tutores_estudiante WHERE id_tutor = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, idTutor);

                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
            }
            else {
                System.out.println("El id del tutor no es valido");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
