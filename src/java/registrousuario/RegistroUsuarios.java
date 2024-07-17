package registrousuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistroUsuarios {

    public static void main(String[] args) {
        
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection != null){
            try{
                String query = "SELECT * FROM usuarios";
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();
                
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    String email = resultSet.getString("email");
                    String password = resultSet.getString("password");
                    String fechaNacimiento = resultSet.getString("fecha_nacimiento");
                    String fechaRegistro = resultSet.getString("fecha_registro");

                    System.out.println("ID: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nEmail: " + email
                            + "\nFecha de Nacimiento: " + fechaNacimiento + "\nFecha de Registro: " + fechaRegistro);
                    System.out.println();

                }
                
            } catch (SQLException e){
                e.printStackTrace();
            } 
        } 
    }
    
    }

