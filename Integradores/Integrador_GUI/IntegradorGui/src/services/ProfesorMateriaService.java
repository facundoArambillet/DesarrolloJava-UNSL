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
import models.ProfesorMateria;
import security.Conexion;

public class ProfesorMateriaService {
    
    
    public ProfesorMateriaService() {
        
    }
    
    public List<ProfesorMateria> mostrarTodos() {
        List<ProfesorMateria> profesoresMaterias = new ArrayList<>();

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM profesores_has_materias";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int idProfesor = resultSet.getInt("id_profesor");
                int idMateria = resultSet.getInt("id_materia");
                ProfesorMateria profesorMateria = new ProfesorMateria(idProfesor,idMateria);

                profesoresMaterias.add(profesorMateria);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
           Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return profesoresMaterias;
    }
    
    public List<ProfesorMateria> mostrarPorIdProfesor(int id) {
        List<ProfesorMateria> profesoresMaterias = new ArrayList<>();

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM profesores_has_materias WHERE id_profesor = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idProfesor = resultSet.getInt("id_profesor");
                int idMateria = resultSet.getInt("id_materia");

                ProfesorMateria profesorMateria = new ProfesorMateria(idProfesor,idMateria);
                profesoresMaterias.add(profesorMateria);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return profesoresMaterias;
    }
    
    public List<ProfesorMateria> mostrarPorIdMateria(int id) {
        List<ProfesorMateria> profesoresMaterias = new ArrayList<>();

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM profesores_has_materias WHERE id_materia = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idProfesor = resultSet.getInt("id_profesor");
                int idMateria = resultSet.getInt("id_materia");

                ProfesorMateria profesorMateria = new ProfesorMateria(idProfesor,idMateria);
                profesoresMaterias.add(profesorMateria);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return profesoresMaterias;
    }
    
    public ProfesorMateria mostrarPorID(int idProfesor,int idMateria) {
        ProfesorMateria profesorMateriaEncontrado = null;

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM profesores_has_materias WHERE id_profesor = ? AND id_materia = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProfesor);
            preparedStatement.setInt(2, idMateria);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idprofesorBase = resultSet.getInt("idProfesor");
                int idMateriaBase = resultSet.getInt("id_materia");

                profesorMateriaEncontrado = new ProfesorMateria(idprofesorBase,idMateriaBase);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return profesorMateriaEncontrado;
    }
    
    
    public ProfesorMateria crearProfesorMateria(ProfesorMateria profesorMateria) {
        try {
            if(this.mostrarPorID(profesorMateria.getIdProfesor(), profesorMateria.getIdMateria()) == null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "INSERT INTO profesores_has_materias (id_profesor, id_materia) VALUES (?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, profesorMateria.getIdProfesor());
                preparedStatement.setInt(2, profesorMateria.getIdMateria());
                
                preparedStatement.executeUpdate();
                //System.out.println("Profesor materia creado");
                preparedStatement.close();
                connection.close();
                
                return profesorMateria;
            } 
            else {
                System.out.println("El profesor materia ya existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void actualizarProfesorMateria(int idProfesor,int idMateria, ProfesorMateria profesorMateria) {
        try {
            if(this.mostrarPorID(idProfesor, idMateria) != null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "UPDATE profesores_has_materias SET id_profesor = ?, id_materia = ? WHERE id_profesor = ? AND id_materia = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, profesorMateria.getIdProfesor());
                preparedStatement.setInt(2, profesorMateria.getIdMateria());
                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
            }
            else {
                System.out.println("El profesor materia no existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarProfesorMateria(int idProfesor, int idMateria) {
        try {
            if(this.mostrarPorID(idProfesor,idMateria) != null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "DELETE FROM profesores_has_materias WHERE id_profesor = ? AND id_materia = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, idProfesor);
                preparedStatement.setInt(2, idMateria);
                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
            }
            else {
                System.out.println("El id del profesor materia no es valido");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
