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
import models.Materia;
import models.Profesor;
import models.ProfesorTipo;
import models.Usuario;
import security.Conexion;

public class ProfesorService {
    private ProfesorTipoService profesorTipoService;
    private MateriaService materiaService;
    private UsuarioService usuarioService;
    
    public ProfesorService() {
        this.profesorTipoService = new ProfesorTipoService();
        this.materiaService = new MateriaService();
        this.usuarioService = new UsuarioService();
    }
    
    public List<Profesor> mostrarTodos() {
            List<Profesor> profesores = new ArrayList<>();

            try {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "SELECT * FROM profesores";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    int idProfesor = resultSet.getInt("id_profesor");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    long cuil = resultSet.getLong("cuil");
                    long telefono = resultSet.getLong("telefono");
                    String email = resultSet.getString("email");
                    int idTipo = resultSet.getInt("id_tipo");
                    String idUsuario = resultSet.getString("id_usuario");
                    ProfesorTipo profesorTipo = this.profesorTipoService.mostrarPorID(idTipo);
                    Usuario usuario = this.usuarioService.mostrarPorID(idUsuario);
                    
                    Profesor profesor = new Profesor(nombre,apellido,cuil,telefono,email,profesorTipo,usuario);
                    profesor.setId(idProfesor);
                    profesores.add(profesor);
                }

                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
            }

            return profesores;
    }
    
    public List<Profesor> mostrarPorMateria(int idMateria) {
            List<Profesor> profesores = new ArrayList<>();

            try {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "SELECT p.* FROM profesores p INNER JOIN profesores_has_materias pm ON p.id_profesor = pm.id_profesor "
                            + "INNER JOIN materias m ON pm.id_materia = m.id_materia WHERE m.id_materia = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, idMateria);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int idProfesor = resultSet.getInt("id_profesor");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    long cuil = resultSet.getLong("cuil");
                    long telefono = resultSet.getLong("telefono");
                    String email = resultSet.getString("email");
                    int idTipo = resultSet.getInt("id_tipo");
                    String idUsuario = resultSet.getString("id_usuario");
                    ProfesorTipo profesorTipo = this.profesorTipoService.mostrarPorID(idTipo);
                    Usuario usuario = this.usuarioService.mostrarPorID(idUsuario);
                    
                    Profesor profesor = new Profesor(nombre,apellido,cuil,telefono,email,profesorTipo,usuario);
                    profesor.setId(idProfesor);
                    profesores.add(profesor);
                }

                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return profesores;
    }

    public Profesor mostrarPorNombre(String nombre) {
        Profesor profesorEncontrado = null;

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM profesores WHERE nombre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombre.toLowerCase());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                    int idProfesor = resultSet.getInt("id_profesor");
                    String nombreProfesor = resultSet.getString("nombre");
                    String apellidoProfesor = resultSet.getString("apellido");
                    long cuilProfesor = resultSet.getLong("cuil");
                    long telefonoProfesor = resultSet.getLong("telefono");
                    String emailProfesor = resultSet.getString("email");
                    int idTipo = resultSet.getInt("id_tipo");
                    String idUsuario = resultSet.getString("id_usuario");
                    ProfesorTipo profesorTipo = this.profesorTipoService.mostrarPorID(idTipo);
                    Usuario usuario = this.usuarioService.mostrarPorID(idUsuario);
                    
                    profesorEncontrado = new Profesor(nombreProfesor,apellidoProfesor,cuilProfesor,
                            telefonoProfesor,emailProfesor,profesorTipo,usuario);
                    profesorEncontrado.setId(idProfesor);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return profesorEncontrado;
    }

    public Profesor mostrarPorID(int id) {
        Profesor profesorEncontrado = null;

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM profesores WHERE id_profesor = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                    int idProfesor = resultSet.getInt("id_profesor");
                    String nombreProfesor = resultSet.getString("nombre");
                    String apellidoProfesor = resultSet.getString("apellido");
                    long cuilProfesor = resultSet.getLong("cuil");
                    long telefonoProfesor = resultSet.getLong("telefono");
                    String emailProfesor = resultSet.getString("email");
                    int idTipo = resultSet.getInt("id_tipo");
                    String idUsuario = resultSet.getString("id_usuario");
                    ProfesorTipo profesorTipo = this.profesorTipoService.mostrarPorID(idTipo);
                    Usuario usuario = this.usuarioService.mostrarPorID(idUsuario);
                    
                    profesorEncontrado = new Profesor(nombreProfesor,apellidoProfesor,cuilProfesor,
                            telefonoProfesor,emailProfesor,profesorTipo,usuario);
                    profesorEncontrado.setId(idProfesor);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return profesorEncontrado;
    }
    
    public Profesor mostrarPorIDUsuario(String id) {
        Profesor profesorEncontrado = null;

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM profesores WHERE id_usuario = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                    int idProfesor = resultSet.getInt("id_profesor");
                    String nombreProfesor = resultSet.getString("nombre");
                    String apellidoProfesor = resultSet.getString("apellido");
                    long cuilProfesor = resultSet.getLong("cuil");
                    long telefonoProfesor = resultSet.getLong("telefono");
                    String emailProfesor = resultSet.getString("email");
                    int idTipo = resultSet.getInt("id_tipo");
                    String idUsuario = resultSet.getString("id_usuario");
                    ProfesorTipo profesorTipo = this.profesorTipoService.mostrarPorID(idTipo);
                    Usuario usuario = this.usuarioService.mostrarPorID(idUsuario);
                    
                    profesorEncontrado = new Profesor(nombreProfesor,apellidoProfesor,cuilProfesor,
                            telefonoProfesor,emailProfesor,profesorTipo,usuario);
                    profesorEncontrado.setId(idProfesor);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return profesorEncontrado;
    }
    
    public Profesor crearProfesor(Profesor profesor, List<Materia> materias) {
        try {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "INSERT INTO profesores (nombre,apellido,cuil,telefono,email,id_tipo,id_usuario) VALUES (?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, profesor.getNombre().toLowerCase());
                preparedStatement.setString(2, profesor.getApellido().toLowerCase());
                preparedStatement.setLong(3, profesor.getCuil());
                preparedStatement.setLong(4, profesor.getTelefono());
                preparedStatement.setString(5, profesor.getEmail().toLowerCase());
                preparedStatement.setInt(6, profesor.getTipoProfesor().getIdTipo());
                preparedStatement.setString(7, profesor.getUsuario().getIdUsuario());
                preparedStatement.executeUpdate();
                
                Profesor profesorCreado = this.mostrarPorNombre(profesor.getNombre());
                if(profesorCreado != null) {
                    int idProfesor = profesorCreado.getId();
                    sql = "INSERT INTO profesores_has_materias (id_profesor,id_materia) VALUES (?,?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    for(Materia materia : materias) {
                        statement.setInt(1,idProfesor);
                        statement.setInt(2, materia.getIdMateria());
                        statement.executeUpdate();
                    }
                    statement.close();
                }
                //System.out.println("Profesor creado");
                preparedStatement.close();
                connection.close();
                
                return profesor;
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void actualizarProfesor(int idProfesor, Profesor profesor, List<Materia> materias) {
        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            if (this.mostrarPorID(idProfesor) != null) {
                // Actualizar la información del profesor
                String sql = "UPDATE profesores SET nombre = ?, apellido = ?, cuil = ?, telefono = ?, email = ?, id_tipo = ?, id_usuario = ? WHERE id_profesor = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, profesor.getNombre().toLowerCase());
                preparedStatement.setString(2, profesor.getApellido().toLowerCase());
                preparedStatement.setLong(3, profesor.getCuil());
                preparedStatement.setLong(4, profesor.getTelefono());
                preparedStatement.setString(5, profesor.getEmail().toLowerCase());
                preparedStatement.setInt(6, profesor.getTipoProfesor().getIdTipo());
                preparedStatement.setString(7, profesor.getUsuario().getIdUsuario());
                preparedStatement.setInt(8, idProfesor);

                preparedStatement.executeUpdate();
                preparedStatement.close();

                // Eliminar todas las asignaciones de materias existentes para este profesor
                sql = "DELETE FROM profesores_has_materias WHERE id_profesor = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, idProfesor);
                preparedStatement.executeUpdate();
                preparedStatement.close();

                // Asignar las nuevas materias al profesor
                sql = "INSERT INTO profesores_has_materias (id_profesor, id_materia) VALUES (?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                for (Materia materia : materias) {
                    preparedStatement.setInt(1, idProfesor);
                    preparedStatement.setInt(2, materia.getIdMateria());
                    preparedStatement.executeUpdate();
                }
                preparedStatement.close();
            } else {
                System.out.println("El profesor no existe");
            }

            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    
    public void eliminarProfesor(int idProfesor) {
        try {
            if(this.mostrarPorID(idProfesor) != null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "DELETE FROM profesores WHERE id_profesor = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, idProfesor);

                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
            }
            else {
                System.out.println("El id del profesor no es valido");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
