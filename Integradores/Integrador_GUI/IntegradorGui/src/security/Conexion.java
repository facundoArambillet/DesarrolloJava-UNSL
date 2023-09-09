package security;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    Connection conexion;
    
    public Conexion() {

    }
    
    public Connection Conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/institucion","root","123456789");
            return conexion;
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    
    public void Desconectar() {
        if(conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.out.print(ex.getMessage());
            }
        }
    }
    
}
