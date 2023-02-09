/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author emanu
 */
public class ReadTableAlumnos extends HttpServlet {

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
    final String DATABASENAME = "test";  //java
    final String URL = "jdbc:mysql:///" + DATABASENAME; //localhost
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter html = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           // Connection conexion = null;
            Statement stmt = null;
            ResultSet rs = null;
            html.println("<!DOCTYPE html>");
            html.println("<html>");
            html.println("<head>");
            html.println("<title>Servlet ReadTable</title>");            
            html.println("</head>");
            html.println("<body>");
            
            String cadenaSql = "SELECT * FROM alumnos;";
            
            html.println("<table border ='1' width = '70%'> <thead>");
            html.println("<tr>");
            //html.println("<td> id </td>");
            html.println("<td> nombre </td>");
            html.println("<td> apellido1 </td>");
            html.println("<td> apellido2 </td>");
            html.println("<td> telefono </td>");
           
            html.println("</tr> </thead>");
            
            try{
                html.println("<p>this es un parrafo</p>");
                Class.forName("com.mysql.jdbc.Driver");// driver 
                Connection conexion = DriverManager.getConnection(URL,USER,PWD);
                if(conexion != null ){ //si la conexion no está vacia
                    html.println("<h1> conexion establecida con la base de datos</h1>");
                }else{ html.println("<h1> conexion fallida</h1>");} // no entra :c
                stmt = conexion.createStatement();
                rs = stmt.executeQuery(cadenaSql);
                html.println("<tbody>");
                while(rs.next()){
                    html.println("<tr>");
                    
                    html.println("<td>" + rs.getString(2)+ "</td>");
                    html.println("<td>" + rs.getString(3)+ "</td>");
                    html.println("<td>" + rs.getString(4)+ "</td>");
                    html.println("<td>" + rs.getString(7)+ "</td>");
                    html.println("</tr>");
                }
                html.println("</tbody> </table>");
               
                
                
                
                conexion.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            
            html.println("</table>");
            html.println("<h1>Servlet ReadTable at " + request.getContextPath() + "</h1>");
            html.println("</body>");
            html.println("</html>");
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
