package services;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Curso;
import security.Conexion;

public class CursoService {
    
    public CursoService() {
        
    }
    
    public List<Curso> mostrarTodos() {
            List<Curso> cursos = new ArrayList<>();

            try {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "SELECT * FROM cursos";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    int idCurso = resultSet.getInt("id_curso");
                    String nombre = resultSet.getString("nombre");
                    Curso curso = new Curso(nombre);
                    curso.setIdCurso(idCurso);
                    cursos.add(curso);
                }

                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
            }

            return cursos;
    }
    
    public List<Curso> mostrarPorProfesor(int idProfesor) {
        List<Curso> cursos = new ArrayList<>();

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT c.* FROM profesores p " +
                        "JOIN profesores_has_materias pm ON p.id_profesor = pm.id_profesor " +
                        "JOIN materias m ON pm.id_materia = m.id_materia " +
                        "JOIN cursos c ON m.id_curso = c.id_curso " +
                        "WHERE p.id_profesor = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProfesor);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idCurso = resultSet.getInt("id_curso");
                String nombreCurso = resultSet.getString("nombre");
                Curso curso = new Curso(nombreCurso);
                curso.setIdCurso(idCurso);
                cursos.add(curso);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cursos;
    }


    public Curso mostrarPorNombre(String nombre) {
        Curso cursoEncontrado = null;

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM cursos WHERE nombre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombre.toLowerCase());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idCurso = resultSet.getInt("id_curso");
                String nombreCurso = resultSet.getString("nombre");

                cursoEncontrado = new Curso(nombreCurso);
                cursoEncontrado.setIdCurso(idCurso);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cursoEncontrado;
    }

    public Curso mostrarPorID(int id) {
        Curso cursoEncontrado = null;

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM cursos WHERE id_curso = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idCurso = resultSet.getInt("id_curso");
                String nombreCurso = resultSet.getString("nombre");

                cursoEncontrado = new Curso(nombreCurso);
                cursoEncontrado.setIdCurso(idCurso);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cursoEncontrado;
    }
    
    public Curso crearCurso(Curso curso) {
        try {
            if(this.mostrarPorNombre(curso.getNombre()) == null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "INSERT INTO cursos (nombre) VALUES (?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, curso.getNombre().toLowerCase());

                preparedStatement.executeUpdate();
                //System.out.println("Curso creado");
                preparedStatement.close();
                connection.close();
                
                return curso;
            } 
            else {
                System.out.println("El curso ya existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void actualizarCurso(String nombre,Curso curso) {
        try {
            if(this.mostrarPorNombre(nombre) != null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "UPDATE cursos SET nombre = ? WHERE nombre = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, curso.getNombre().toLowerCase());
                preparedStatement.setString(2, nombre.toLowerCase());

                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
            }
            else {
                System.out.println("El curso no existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarCurso(int idCurso) {
        try {
            if(this.mostrarPorID(idCurso) != null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "DELETE FROM cursos WHERE id_curso = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, idCurso);

                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
            }
            else {
                System.out.println("El id del curso no es valido");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
