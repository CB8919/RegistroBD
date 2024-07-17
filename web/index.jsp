<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>
<%@ page import="registrousuario.ConexionBD" %>
<%@ page import="registrousuario.RegistroUsuarios" %>
<%@ page import="registrousuario.DatabaseConnection" %>

<html>
<head>
    <title>Lista de Usuarios</title>
</head>
<body>
    <h1>Registro de Usuarios</h1>
    
    <form method="post" action="procesarRegistro.jsp">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>
        
        <label for="apellido">Apellido:</label>
        <input type="text" id="apellido" name="apellido" required><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="password">Contraseña:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <label for="fecha_nacimiento">Fecha de Nacimiento:</label>
        <input type="date" id="fecha_nacimiento" name="fecha_nacimiento" required><br><br>
        
        <input type="submit" value="Registrar">
    </form>
    <h1>Lista de Usuarios</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Email</th>
            <th>Fecha de Registro</th>
        </tr>
        <% Connection conn = null;
           PreparedStatement statement = null;
           ResultSet result = null;
           try {
               conn = ConexionBD.getConnection();
               String selectSQL = "SELECT * FROM usuarios";
               statement = conn.prepareStatement(selectSQL);
               result = statement.executeQuery();
               while (result.next()) {
                   %>
                   <tr>
                       <td><%= result.getInt("id") %></td>
                       <td><%= result.getString("nombre") %></td>
                       <td><%= result.getString("apellido") %></td>
                       <td><%= result.getString("email") %></td>
                       <td><%= result.getDate("fecha_registro") %></td>
                   </tr>
                   <% 
               }
           } catch (SQLException e) {
               e.printStackTrace();
           } finally {
               try {
                   if (result != null) result.close();
                   if (statement != null) statement.close();
                   if (conn != null) conn.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
        %>
    </table>
</body>
</html>


