/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author emanu
 */
public class DeleteAlumno extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    final String USER = "root";
    final String PWD = "mysql";
    final String DATABASENAME = "test";  
    final String URL = "jdbc:mysql:///" + DATABASENAME; //localhost
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //peticiones
            String id = request.getParameter("id");
           // String nombre = request.getParameter("nombre");    
            //String apellido1 = request.getParameter("apellido1");
           // String apellido2 = request.getParameter("apellido2");
           // String domicilio = request.getParameter("domicilio");
            //String provincia = request.getParameter("provincia");
            
            String telf = request.getParameter("telf");
            //text area...
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form acticion = '#' method = 'get' >");
            out.println("<table border = ' 1'>");
            
            out.println("<tr> <td> <label> id</label> </td> ");
            out.println("<td> <input name = 'id' type = 'text' />  </td> </tr> ");
            /*
            out.println("<tr> <td> <label> nombre</label> </td> ");
            out.println("<td> <input name = 'nombre' type = 'text' />  </td> </tr> ");
            
            out.println("<tr> <td> <label> apellido1</label> </td> ");
            out.println("<td> <input name = 'apellido1' type = 'text' />  </td> </tr> ");
            
            out.println("<tr> <td> <label> apellido2</label> </td> ");
            out.println("<td> <input name = 'apellido2' type = 'text' />  </td> </tr> ");
            
            out.println("<tr> <td> <label> domicilio</label> </td> ");
            out.println("<td> <input name = 'domicilio' type = 'text' />  </td> </tr> ");
            
            out.println("<tr> <td> <label> provincia</label> </td> ");
            out.println("<td> <input name = 'provincia' type = 'text' />  </td> </tr> ");
            
            out.println("<tr> <td> <label> telefono</label> </td> ");
            out.println("<td> <input name = 'telf' type = 'text' />  </td> </tr> ");
            */
            
            //INPUTS COMENTADOS PARA POSIBLE ELIMINACION CON ESOS ELEMENTOS NOMBRE,APELLIDO1,ETC AUN NO FUNCIONAL COMO CONSULTA
            
            //out.println("<tr> <td> <label> id</label> </td> ");
            out.println("<tr> <td > <input  type = 'submit' value = 'delete for id ' style='background : rgb(155,40,50)' />  </td> </tr> ");
            out.println("</table >");
            out.println("</form >");
            out.println("<a href='http://localhost:8080/GestionAcademia/ReadTableAlumnos'> ver tabla ReadTableAlumnos </a> ");
             //conexion
            Connection conexion = null;
            Statement stmt = null;
              
            String queryEliminar = "DELETE FROM alumnos WHERE id='"+ id +"'";
            try {
                Class.forName("com.mysql.jdbc.Driver");// driver
                conexion = DriverManager.getConnection(URL, USER, PWD);
                out.println("<h1>hola</h1>");
                stmt = conexion.createStatement();
                int cantidad = stmt.executeUpdate(queryEliminar);
                out.println("<p>prueba</p>");
                out.println("<p style = 'color:blue; border:solid red 2px;'>" + queryEliminar + "</p>");
                if (cantidad == 1) {

                    out.println("<h2 style='color: green; '>Se eliminaron los datos dados por codigo id </h2>");
                } else {

                    out.println("<h2 style = 'color: red'>No existen datos con dicho código id  para eliminar</h2>");
                }
                out.println("</body>");
                out.println("</html>");
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
