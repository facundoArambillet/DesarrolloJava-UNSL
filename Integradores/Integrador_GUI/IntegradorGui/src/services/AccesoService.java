package services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import models.Usuario;
import models.UsuarioTipo;

public class AccesoService {
    private UsuarioService usuarioService;
    
    public AccesoService() {
        this.usuarioService = new UsuarioService();
    }
    
    public boolean login(Usuario usuario) {
        String nombre = usuario.getIdUsuario();
        UsuarioTipo usuarioTipo = usuario.getTipoUsuario();
        Usuario usuarioBase = this.usuarioService.mostrarPorID(nombre);

        if (usuarioBase != null) {
            if(usuarioBase.getTipoUsuario().getTipo().equals(usuario.getTipoUsuario().getTipo())){
                try {
                    MessageDigest digest = MessageDigest.getInstance("SHA-256");
                    byte[] contraseniaBytes = usuario.getContrasenia().getBytes();
                    byte[] contraseniaHash = digest.digest(contraseniaBytes);

                    StringBuilder hashHex = new StringBuilder();
                    for (byte b : contraseniaHash) {
                        hashHex.append(String.format("%02x", b));
                    }

                    if (hashHex.toString().equals(usuarioBase.getContrasenia())) {
                        System.out.println("Inicio de sesión exitoso");
                        return true;
                    } else {
                        System.out.println("Contraseña incorrecta");
                    }
                } catch (NoSuchAlgorithmException ex) {
                    System.out.println(ex.getMessage());
                }  
            } else {
                System.out.println("Tipo de usuario incorrecto");
            }
            
        } else {
            System.out.println("Nombre de usuario incorrecto");
        }
        
        return false;
    }
    
    public void registrar(Usuario usuario) {
        String nombre = usuario.getIdUsuario();
        Usuario usuarioBase = this.usuarioService.mostrarPorID(nombre);
        if(usuarioBase == null) {
            if(usuario.getContrasenia().length() >= 4 && usuario.getContrasenia().length() <= 10) {
                this.usuarioService.crearUsuario(usuario);
                System.out.println("Usuario Creado con exito");
            }
            else {
                System.out.println("La contraseña debe tener entre 4 a 10 caracteres");
            }
        }
        else {
            System.out.println("El usuario ya existe");
        }
    }
}
