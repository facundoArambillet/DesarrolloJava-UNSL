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
import models.Estudiante;
import models.TutorEstudiante;
import models.Usuario;
import security.Conexion;

public class EstudianteService {
    private UsuarioService usuarioService;
    private TutorEstudianteService tutorEstudianteService;
    private CursoService cursoService;
    
    public EstudianteService() {
        this.usuarioService  = new UsuarioService();
        this.tutorEstudianteService  = new TutorEstudianteService();
        this.cursoService = new CursoService();
    }
    
    public List<Estudiante> mostrarTodos() {
            List<Estudiante> estudiantes = new ArrayList<>();

            try {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "SELECT * FROM estudiantes";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    int idEstudiante = resultSet.getInt("id_estudiante");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    long dni = resultSet.getLong("dni");
                    long telefono = resultSet.getLong("telefono");
                    String email = resultSet.getString("email");
                    byte[] foto = resultSet.getBytes("foto");
                    String idUsuario = resultSet.getString("id_usuario");
                    int idTutor = resultSet.getInt("id_Tutor");
                    int idCurso = resultSet.getInt("id_curso");
                    Usuario usuario = this.usuarioService.mostrarPorID(idUsuario);
                    TutorEstudiante tutorEstudiante = this.tutorEstudianteService.mostrarPorID(idTutor);
                    Curso curso = this.cursoService.mostrarPorID(idCurso);
                    Estudiante estudiante = new Estudiante(nombre,apellido,dni,telefono,email,usuario,tutorEstudiante,curso);
                    estudiante.setIdEstudiante(idEstudiante);
                    estudiantes.add(estudiante);
                }

                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
            }

            return estudiantes;
    }
    
    public List<Estudiante> mostrarPorCurso(int idCurso) {
            List<Estudiante> estudiantes = new ArrayList<>();

            try {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "SELECT * FROM estudiantes WHERE id_curso = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, idCurso);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int idEstudiante = resultSet.getInt("id_estudiante");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    long dni = resultSet.getLong("dni");
                    long telefono = resultSet.getLong("telefono");
                    String email = resultSet.getString("email");
                    byte[] foto = resultSet.getBytes("foto");
                    String idUsuario = resultSet.getString("id_usuario");
                    int idTutor = resultSet.getInt("id_Tutor");
                    int idCursoBase = resultSet.getInt("id_curso");
                    Usuario usuario = this.usuarioService.mostrarPorID(idUsuario);
                    TutorEstudiante tutorEstudiante = this.tutorEstudianteService.mostrarPorID(idTutor);
                    Curso curso = this.cursoService.mostrarPorID(idCursoBase);
                    Estudiante estudiante = new Estudiante(nombre,apellido,dni,telefono,email,usuario,tutorEstudiante,curso);
                    estudiante.setIdEstudiante(idEstudiante);
                    estudiantes.add(estudiante);
                }

                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
            }

            return estudiantes;
    }

    public List<Estudiante> mostrarPorMateria(int idMateria) {
            List<Estudiante> estudiantes = new ArrayList<>();

            try {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "SELECT e.* " +
                            "FROM institucion.estudiantes e " +
                            "INNER JOIN institucion.materias m ON e.id_curso = m.id_curso " +
                            "WHERE m.id_materia = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, idMateria);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int idEstudiante = resultSet.getInt("id_estudiante");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    long dni = resultSet.getLong("dni");
                    long telefono = resultSet.getLong("telefono");
                    String email = resultSet.getString("email");
                    byte[] foto = resultSet.getBytes("foto");
                    String idUsuario = resultSet.getString("id_usuario");
                    int idTutor = resultSet.getInt("id_Tutor");
                    int idCursoBase = resultSet.getInt("id_curso");
                    Usuario usuario = this.usuarioService.mostrarPorID(idUsuario);
                    TutorEstudiante tutorEstudiante = this.tutorEstudianteService.mostrarPorID(idTutor);
                    Curso curso = this.cursoService.mostrarPorID(idCursoBase);
                    Estudiante estudiante = new Estudiante(nombre,apellido,dni,telefono,email,usuario,tutorEstudiante,curso);
                    estudiante.setIdEstudiante(idEstudiante);
                    estudiantes.add(estudiante);
                }

                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
            }

            return estudiantes;
    }
    
    
    public Estudiante mostrarPorNombre(String nombre) {
        Estudiante estudianteEncontrado = null;

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM estudiantes WHERE nombre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombre.toLowerCase());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idEstudiante = resultSet.getInt("id_estudiante");
                String nombreEstudiante = resultSet.getString("nombre");
                String apellidoEstudiante = resultSet.getString("apellido");
                long dniEstudiante = resultSet.getLong("dni");
                long telefonoEstudiante = resultSet.getLong("telefono");
                String emailEstudiante = resultSet.getString("email");
                byte[] fotoEstudiante = resultSet.getBytes("foto");
                String idUsuario = resultSet.getString("id_usuario");
                int idTutor = resultSet.getInt("id_tutor");
                int idCurso = resultSet.getInt("id_curso");
                Usuario usuario = this.usuarioService.mostrarPorID(idUsuario);
                TutorEstudiante tutorEstudiante = this.tutorEstudianteService.mostrarPorID(idTutor);
                Curso curso = this.cursoService.mostrarPorID(idCurso);
                estudianteEncontrado = new Estudiante( nombreEstudiante,apellidoEstudiante,dniEstudiante,telefonoEstudiante,
                                                emailEstudiante,fotoEstudiante,usuario,tutorEstudiante,curso);
                estudianteEncontrado.setIdEstudiante(idEstudiante);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return estudianteEncontrado;
    }

    public Estudiante mostrarPorID(int id) {
        Estudiante estudianteEncontrado = null;

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM estudiantes WHERE id_estudiante = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idEstudiante = resultSet.getInt("id_estudiante");
                String nombreEstudiante = resultSet.getString("nombre");
                String apellidoEstudiante = resultSet.getString("apellido");
                long dniEstudiante = resultSet.getLong("dni");
                long telefonoEstudiante = resultSet.getLong("telefono");
                String emailEstudiante = resultSet.getString("email");
                byte[] fotoEstudiante = resultSet.getBytes("foto");
                String idUsuario = resultSet.getString("id_usuario");
                int idTutor = resultSet.getInt("id_tutor");
                int idCurso = resultSet.getInt("id_curso");
                Usuario usuario = this.usuarioService.mostrarPorID(idUsuario);
                TutorEstudiante tutorEstudiante = this.tutorEstudianteService.mostrarPorID(idTutor);
                Curso curso = this.cursoService.mostrarPorID(idCurso);
                estudianteEncontrado = new Estudiante(nombreEstudiante,apellidoEstudiante,dniEstudiante,telefonoEstudiante,
                                                emailEstudiante,fotoEstudiante,usuario,tutorEstudiante,curso);
                estudianteEncontrado.setIdEstudiante(idEstudiante);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return estudianteEncontrado;
    }
    
    public Estudiante mostrarPorIDUsuario(String id) {
        Estudiante estudianteEncontrado = null;

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM estudiantes WHERE id_usuario = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idEstudiante = resultSet.getInt("id_estudiante");
                String nombreEstudiante = resultSet.getString("nombre");
                String apellidoEstudiante = resultSet.getString("apellido");
                long dniEstudiante = resultSet.getLong("dni");
                long telefonoEstudiante = resultSet.getLong("telefono");
                String emailEstudiante = resultSet.getString("email");
                byte[] fotoEstudiante = resultSet.getBytes("foto");
                String idUsuario = resultSet.getString("id_usuario");
                int idTutor = resultSet.getInt("id_tutor");
                int idCurso = resultSet.getInt("id_curso");
                Usuario usuario = this.usuarioService.mostrarPorID(idUsuario);
                TutorEstudiante tutorEstudiante = this.tutorEstudianteService.mostrarPorID(idTutor);
                Curso curso = this.cursoService.mostrarPorID(idCurso);
                estudianteEncontrado = new Estudiante(nombreEstudiante,apellidoEstudiante,dniEstudiante,telefonoEstudiante,
                                                emailEstudiante,fotoEstudiante,usuario,tutorEstudiante,curso);
                estudianteEncontrado.setIdEstudiante(idEstudiante);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return estudianteEncontrado;
    }
    
    
    public Estudiante crearEstudiante(Estudiante estudiante) {
        try {
            if(this.mostrarPorNombre(estudiante.getNombre()) == null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "INSERT INTO estudiantes (nombre,apellido,dni,telefono,email,foto,id_usuario,id_tutor,id_curso) VALUES (?,?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, estudiante.getNombre().toLowerCase());
                preparedStatement.setString(2, estudiante.getApellido().toLowerCase());
                preparedStatement.setLong(3, estudiante.getDni());
                preparedStatement.setLong(4, estudiante.getTelefono());
                preparedStatement.setString(5, estudiante.getEmail().toLowerCase());
                preparedStatement.setBytes(6, estudiante.getFoto());
                preparedStatement.setString(7, estudiante.getUsuario().getIdUsuario());
                preparedStatement.setInt(8, estudiante.getTutor().getIdTutor());
                preparedStatement.setInt(9, estudiante.getCurso().getIdCurso());
                
                preparedStatement.executeUpdate();
                //System.out.println("Estudiante creado");
                preparedStatement.close();
                connection.close();
                
                return estudiante;
            } 
            else {
                System.out.println("El estudiante ya existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void actualizarEstudiante(int idEstudiante,Estudiante estudiante) {
        try {
            if(this.mostrarPorID(idEstudiante) != null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "UPDATE estudiantes SET nombre = ?, apellido = ?, dni = ?, telefono = ?, email = ?, foto = ?, id_usuario = ?, id_tutor = ? WHERE id_estudiante = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, estudiante.getNombre().toLowerCase());
                preparedStatement.setString(2, estudiante.getApellido().toLowerCase());
                preparedStatement.setLong(3, estudiante.getDni());
                preparedStatement.setLong(4, estudiante.getTelefono());
                preparedStatement.setString(5, estudiante.getEmail().toLowerCase());
                preparedStatement.setBytes(6, estudiante.getFoto());
                preparedStatement.setString(7, estudiante.getUsuario().getIdUsuario());
                preparedStatement.setInt(8, estudiante.getTutor().getIdTutor());
                preparedStatement.setInt(9, idEstudiante);

                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
            }
            else {
                System.out.println("El estudiante no existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarEstudiante(int idEstudiante) {
        try {
            if(this.mostrarPorID(idEstudiante) != null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "DELETE FROM estudiantes WHERE id_estudiante = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, idEstudiante);

                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
            }
            else {
                System.out.println("El id del estudiante no es valido");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
