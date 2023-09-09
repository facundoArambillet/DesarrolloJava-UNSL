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
import models.Curso;
import models.Materia;
import security.Conexion;

public class MateriaService {
    private CursoService cursoService;
    
    public MateriaService() {
        this.cursoService = new CursoService();
    }
    
    public List<Materia> mostrarTodos() {
        List<Materia> materias = new ArrayList<>();
            
        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM materias";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int idMateria = resultSet.getInt("id_materia");
                String nombre = resultSet.getString("nombre");
                int idCurso = resultSet.getInt("id_curso");
                Curso curso = this.cursoService.mostrarPorID(idCurso);
                Materia materia = new Materia(nombre,curso);
                materia.setIdMateria(idMateria);
                materias.add(materia);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

            return materias;
    }
    
    public List<Materia> mostrarPorProfesor(int idProfesor) {
            List<Materia> materias = new ArrayList<>();

            try {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "SELECT m.* FROM materias m INNER JOIN profesores_has_materias pm ON m.id_materia = pm.id_materia "
                            + "INNER JOIN profesores p ON pm.id_profesor = p.id_profesor WHERE p.id_profesor = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, idProfesor);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int idMateria = resultSet.getInt("id_materia");
                    String nombre = resultSet.getString("nombre");
                    int idCurso = resultSet.getInt("id_curso");
                    Curso curso = this.cursoService.mostrarPorID(idCurso);
                    Materia materia = new Materia(nombre,curso);
                    materia.setIdMateria(idMateria);
                    materias.add(materia);
                }

                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return materias;
    }

    
    public List<Materia> mostrarPorCurso(int idCurso) {
        List<Materia> materias = new ArrayList<>();
            
        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM materias WHERE id_curso = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCurso);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idMateria = resultSet.getInt("id_materia");
                String nombre = resultSet.getString("nombre");
                int idCursoBase = resultSet.getInt("id_curso");
                Curso curso = this.cursoService.mostrarPorID(idCursoBase);
                Materia materia = new Materia(nombre,curso);
                materia.setIdMateria(idMateria);
                materias.add(materia);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

            return materias;
    }

    public Materia mostrarPorNombre(String nombre) {
        Materia materiaEncontrado = null;

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM materias WHERE nombre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombre.toLowerCase());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idMateria = resultSet.getInt("id_materia");
                String nombreMateria = resultSet.getString("nombre");
                int idCurso = resultSet.getInt("id_curso");
                Curso curso = this.cursoService.mostrarPorID(idCurso);
                materiaEncontrado = new Materia(nombreMateria,curso);
                materiaEncontrado.setIdMateria(idMateria);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return materiaEncontrado;
    }

    public Materia mostrarPorID(int id) {
        Materia materiaEncontrado = null;

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM materias WHERE id_materia = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idMateria = resultSet.getInt("id_materia");
                String nombreMateria = resultSet.getString("nombre");
                int idCurso = resultSet.getInt("id_curso");
                Curso curso = this.cursoService.mostrarPorID(idCurso);
                materiaEncontrado = new Materia(nombreMateria,curso);
                materiaEncontrado.setIdMateria(idMateria);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return materiaEncontrado;
    }
    
    public Materia crearMateria(Materia materia) {
        try {
            if(this.mostrarPorNombre(materia.getNombre()) == null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();
                String sql = "INSERT INTO materias (nombre,id_curso) VALUES (?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, materia.getNombre().toLowerCase());
                preparedStatement.setInt(2, materia.getCurso().getIdCurso());
                
                preparedStatement.executeUpdate();
                //System.out.println("Materia creada");
                preparedStatement.close();
                connection.close();
                
                return materia;
            } 
            else {
                System.out.println("La materia ya existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void actualizarMateria(String nombre,Materia materia) {
        try {
            if(this.mostrarPorNombre(nombre) != null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "UPDATE materias SET nombre = ?, id_curso = ? WHERE nombre = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, materia.getNombre().toLowerCase());
                preparedStatement.setInt(2, materia.getCurso().getIdCurso());
                preparedStatement.setString(3, nombre.toLowerCase());
                preparedStatement.executeUpdate();
                
                /*
                String eliminarRelacionSQL = "DELETE FROM cursos_has_materias WHERE materias_id_materia = ?";
                PreparedStatement eliminarRelacionStatement = connection.prepareStatement(eliminarRelacionSQL);
                eliminarRelacionStatement.setInt(1, materia.getIdMateria());
                eliminarRelacionStatement.executeUpdate();

                String insertarRelacionSQL = "INSERT INTO cursos_has_materias (cursos_id_curso, materias_id_materia) VALUES (?, ?)";
                PreparedStatement insertarRelacionStatement = connection.prepareStatement(insertarRelacionSQL);

                for (Curso curso : cursos) {
                    insertarRelacionStatement.setInt(1, curso.getIdCurso());
                    insertarRelacionStatement.setInt(2, materia.getIdMateria());
                    insertarRelacionStatement.executeUpdate();
                }

                insertarRelacionStatement.close();
                eliminarRelacionStatement.close();
                */
                preparedStatement.close();
                connection.close();
            }
            else {
                System.out.println("La materia no existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarMateria(int idMateria) {
        try {
            if(this.mostrarPorID(idMateria) != null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "DELETE FROM materias WHERE id_materia = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, idMateria);

                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
            }
            else {
                System.out.println("El id de la materia no es valido");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
