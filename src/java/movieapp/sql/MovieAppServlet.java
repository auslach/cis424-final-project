/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.sql;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
/**
 *
 * @author austinchang
 */
public abstract class MovieAppServlet
extends HttpServlet
   implements HttpJspPage
{
   protected Connection con;

   /**
   * Initialize a servlet with the driver
   * class already loaded and the database
   * connection established.
   */
   @Override
   public void init(ServletConfig config)
      throws ServletException
   {
      super.init(config);
      try {
         Class.forName("com.mysql.jdbc.Driver");
          String dbURL = "jdbc:mysql://localhost:3306/cis424";
          String username = "root";
          String password = "";
          con = DriverManager.getConnection(dbURL, username, password);
                  
      }
      catch (Exception e) {
         throw new UnavailableException(e.getMessage());
      }

      jspInit();
   }

   /**
   * Closes the database connection when
   * the servlet is unloaded.
   */
   public void destroy()
   {
      try {
         if (con != null) {
            con.close();
            con = null;
         }
      }
      catch (Exception ignore) {}

      jspDestroy();
      super.destroy();
   }

   /**
   * Called when the JSP is loaded.
   * By default does nothing.
   */
   public void jspInit() {}

   /**
   * Called when the JSP is unloaded.
   * By default does nothing.
   */
   public void jspDestroy() {}

   /**
   * Invokes the JSP's _jspService method.
   */
   public final void service(
         HttpServletRequest request,
         HttpServletResponse response)
      throws ServletException, IOException
   {
      _jspService(request, response);
   }

   /**
   * Handles a service request.
   */
   public abstract void _jspService(
         HttpServletRequest request,
         HttpServletResponse response)
      throws ServletException, IOException;
}
