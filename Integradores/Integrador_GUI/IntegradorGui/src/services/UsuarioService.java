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
import models.Usuario;
import models.UsuarioTipo;
import security.Conexion;
//Es recomendable usar bcrypt o argon2
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UsuarioService {
    private UsuarioTipoService usuarioTipoService;
            
    public UsuarioService() {
        this.usuarioTipoService = new UsuarioTipoService();
    }
    
    public List<Usuario> mostrarTodos() {
            List<Usuario> usuarios = new ArrayList<>();

            try {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "SELECT * FROM usuarios";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    String idUsuario = resultSet.getString("id_usuario");
                    String contrasenia = resultSet.getString("contrasenia");
                    int idTipoUsuario = resultSet.getInt("id_tipo");
                    UsuarioTipo tipoUsuario = this.usuarioTipoService.mostrarPorID(idTipoUsuario);
                    
                    Usuario usuario = new Usuario(idUsuario,contrasenia,tipoUsuario);
                }

                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
            }

            return usuarios;
    }

    public Usuario mostrarPorID(String id) {
        Usuario usuarioEncontrado = null;

        try {
            Conexion conexion = new Conexion();
            Connection connection = conexion.Conectar();

            String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id.toLowerCase());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String idUsuario = resultSet.getString("id_usuario");
                String contraseniaUsuario = resultSet.getString("contrasenia");
                int idTipo = resultSet.getInt("id_tipo");
                UsuarioTipo usuarioTipo = this.usuarioTipoService.mostrarPorID(idTipo);
                usuarioEncontrado = new Usuario(idUsuario, contraseniaUsuario,usuarioTipo);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuarioEncontrado;
    }
    
    public Usuario crearUsuario(Usuario usuario) {
        try {
            if(this.mostrarPorID(usuario.getIdUsuario().toLowerCase()) == null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();
                
                MessageDigest digest;
                StringBuilder hashHex= new StringBuilder();
                try {
                    digest = MessageDigest.getInstance("SHA-256");
                    byte[] contraseniaBytes = usuario.getContrasenia().getBytes();
                    byte[] contraseniaHash = digest.digest(contraseniaBytes);
                    for (byte b : contraseniaHash) {
                        hashHex.append(String.format("%02x", b));
                    }
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
                }
    
                
                String sql = "INSERT INTO usuarios (id_usuario, contrasenia, id_tipo) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, usuario.getIdUsuario().toLowerCase());
                preparedStatement.setString(2, hashHex.toString());
                preparedStatement.setInt(3, usuario.getTipoUsuario().getIdTipo());

                preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();
                
                return usuario;
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void actualizarUsuario(String id, Usuario usuario) {
        try {
            if (this.mostrarPorID(id) != null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "UPDATE usuarios SET id_usuario = ?, contrasenia = ?, id_tipo = ? WHERE id_usuario = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, usuario.getIdUsuario().toLowerCase());
                preparedStatement.setString(2, usuario.getContrasenia());
                preparedStatement.setInt(3, usuario.getTipoUsuario().getIdTipo());
                preparedStatement.setString(4, id.toLowerCase());

                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
                System.out.println("Usuario actualizado");
            } else {
                System.out.println("El Usuario no existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void eliminarUsuario(String idUsuario) {
        try {
            if(this.mostrarPorID(idUsuario.toLowerCase()) != null) {
                Conexion conexion = new Conexion();
                Connection connection = conexion.Conectar();

                String sql = "DELETE FROM usuarios WHERE id_curso = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, idUsuario.toLowerCase());

                preparedStatement.executeUpdate();

                preparedStatement.close();
                connection.close();
            }
            else {
                System.out.println("El id del usuario no es valido");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
