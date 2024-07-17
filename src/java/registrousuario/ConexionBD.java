package registrousuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author chris
 */
public class ConexionBD {
    private static Connection conn = null;
    private static final String URL = "jdbc:mysql://localhost:3306/registrousuarios";
    private static final String USER = "root"; // Reemplaza con tu usuario de MySQL
    private static final String PASSWORD = ""; // Reemplaza con tu contraseña de MySQL
    
    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver JDBC
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

        
}

