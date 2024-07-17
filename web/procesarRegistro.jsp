<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>
<%@ page import="registrousuario.ConexionBD" %>
<%@ page import="registrousuario.RegistroUsuarios" %>
<%@ page import="registrousuario.DatabaseConnection" %>
<%
    Connection conn = null;
    PreparedStatement statement = null;
    
    try {
        conn = ConexionBD.getConnection();
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fechaNacimiento = request.getParameter("fecha_nacimiento");
        
        // Aquí puedes validar los datos recibidos si es necesario
        
        String insertSQL = "INSERT INTO usuarios (nombre, apellido, email, password, fecha_nacimiento) VALUES (?, ?, ?, ?, ?)";
        statement = conn.prepareStatement(insertSQL);
        statement.setString(1, nombre);
        statement.setString(2, apellido);
        statement.setString(3, email);
        statement.setString(4, password);
        statement.setString(5, fechaNacimiento);
        
        int filasInsertadas = statement.executeUpdate();
        
        if (filasInsertadas > 0) {
            out.println("<h2>Registro exitoso!</h2>");
        } else {
            out.println("<h2>Error al registrar usuario</h2>");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        out.println("<h2>Error en la base de datos: " + e.getMessage() + "</h2>");
    } finally {
        try {
            if (statement != null) statement.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>

