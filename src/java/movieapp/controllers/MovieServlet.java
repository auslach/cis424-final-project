/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import movieapp.business.Movie;

/**
 *
 * @author austinchang
 */
public class MovieServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet MovieServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet MovieServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

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
        //processRequest(request, response);
        doPost(request, response);
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
//        processRequest(request, response);
        // get params from request
        String movieTitle = request.getParameter("movieTitle");
        String movieRating = request.getParameter("movieRating");
        String movieGenre = request.getParameter("movieGenre");
        String movieName = request.getParameter("movieName");
        
        Movie movie = new Movie();
        movie.setTitle(movieTitle);
        movie.setRating(movieRating);
        movie.setGenreId(movieGenre);
        movie.setName(movieName);
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/cis424";
            String username = "root";
            String password = "";
            Connection con = DriverManager.getConnection(dbURL, username, password);

            Statement stmt = con.createStatement();
            String insert = "INSERT INTO Movie (title, rating, genre_id, name) VALUES ('" + movieTitle + "'," + movieRating + "," + movieGenre + "," + movieName + ")";
            stmt.executeUpdate(insert);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MovieServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        request.setAttribute("movie", movie);
        
        String url = "/movie.jsp";
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        
    }
}
