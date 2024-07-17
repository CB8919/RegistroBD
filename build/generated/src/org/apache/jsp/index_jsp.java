package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import registrousuario.ConexionBD;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Registro de Usuarios</title>\n");
      out.write("    <style>\n");
      out.write("        table, th, td {\n");
      out.write("            border: 1px solid black;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            padding: 5px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Registro de Usuarios</h1>\n");
      out.write("    \n");
      out.write("    ");

    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet result = null;

    try {
        conn = ConexionBD.getConnection();
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String fecha_nacimiento = request.getParameter("fecha_nacimiento");
        String password = request.getParameter("password");

        if (nombre != null && apellido != null && email != null && fecha_nacimiento != null && password != null) {
            String sql = "INSERT INTO usuarios (nombre, apellido, email, fecha_nacimiento, password) VALUES (?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setString(3, email);
            statement.setString(4, fecha_nacimiento);
            statement.setString(5, password);
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                out.println("<p>Nuevo registro creado exitosamente</p>");
            } else {
                out.println("<p>Error al crear el registro</p>");
            }
        }

        String selectSQL = "SELECT * FROM usuarios";
        statement = conn.prepareStatement(selectSQL);
        result = statement.executeQuery();
    
      out.write("\n");
      out.write("\n");
      out.write("    <form action=\"index.jsp\" method=\"post\">\n");
      out.write("        <label for=\"nombre\">Nombre:</label>\n");
      out.write("        <input type=\"text\" id=\"nombre\" name=\"nombre\" required><br>\n");
      out.write("\n");
      out.write("        <label for=\"apellido\">Apellido:</label>\n");
      out.write("        <input type=\"text\" id=\"apellido\" name=\"apellido\" required><br>\n");
      out.write("\n");
      out.write("        <label for=\"email\">Email:</label>\n");
      out.write("        <input type=\"email\" id=\"email\" name=\"email\" required><br>\n");
      out.write("\n");
      out.write("        <label for=\"fecha_nacimiento\">Fecha de Nacimiento:</label>\n");
      out.write("        <input type=\"date\" id=\"fecha_nacimiento\" name=\"fecha_nacimiento\" required><br>\n");
      out.write("\n");
      out.write("        <label for=\"password\">Contraseña:</label>\n");
      out.write("        <input type=\"password\" id=\"password\" name=\"password\" required><br>\n");
      out.write("\n");
      out.write("        <input type=\"submit\" name=\"submit\" value=\"Registrar\">\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("    ");

        if (result != null) {
    
      out.write("\n");
      out.write("    <h2>Lista de Usuarios</h2>\n");
      out.write("    <table>\n");
      out.write("        <tr>\n");
      out.write("            <th>ID</th>\n");
      out.write("            <th>Nombre</th>\n");
      out.write("            <th>Apellido</th>\n");
      out.write("            <th>Email</th>\n");
      out.write("            <th>Fecha de Nacimiento</th>\n");
      out.write("            <th>Fecha de Registro</th>\n");
      out.write("        </tr>\n");
      out.write("\n");
      out.write("        ");

            while (result.next()) {
                out.println("<tr>");
                out.println("<td>" + result.getInt("id") + "</td>");
                out.println("<td>" + result.getString("nombre") + "</td>");
                out.println("<td>" + result.getString("apellido") + "</td>");
                out.println("<td>" + result.getString("email") + "</td>");
                out.println("<td>" + result.getString("fecha_nacimiento") + "</td>");
                out.println("<td>" + result.getString("fecha_registro") + "</td>");
                out.println("</tr>");
            }
        }
    } catch (SQLException ex) {
        out.println("<p>Error en la conexión: " + ex.getMessage() + "</p>");
    } finally {
        if (result != null) try { result.close(); } catch (SQLException ignore) {}
        if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
        if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
    }
    
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
