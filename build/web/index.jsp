<%-- 
    Document   : index
    Created on : Mar 16, 2015, 12:10:47 PM
    Author     : austinchang
--%>

<%@page extends="movieapp.sql.MovieAppServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<html>
    <head>
        <link rel="stylesheet" href="styles/common.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Ratings</title>
    </head>
    <body>
        <form action="movie" method="post">
            <h1>Enter a movie below!</h1>
            
            <label for="movieTitle">Movie Title: </label>
            <input type="text" name="movieTitle" required><br>
            
            <label for="movieRating">Movie Rating: </label>
            <select name="movieRating">
                <% for (int i=1; i < 11; i++) { %>
                    <option value="<%= i %>"><%= i %></option>
                <% } %>
            </select>
            
            <br>
            
            <label for="movieGenre">Movie Rating: </label>
            <select name="movieGenre">
                <% 
                    Statement stmt = con.createStatement();
                    String sql = "SELECT * FROM Genre;";
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        String id = rs.getString("id");
                        String genre = rs.getString("genre");
                %>
                    <option value="<%= id %>"><%= genre %></option>
                <% } %>
            </select>
            <br><br>
            <input type="submit" value="Add Movie">
        </form>
            
            <br><br><br><br>
<table>
    <tr>
        <th>Rating</th>
        <th>Movie Title</th>
        <th>Genre</th>
    </tr>                
        <%
   // Execute a query

   stmt = con.createStatement();
   sql = "SELECT * FROM Movie ORDER BY rating DESC;";
   rs = stmt.executeQuery(sql);
   while (rs.next()) {
        String movieTitle = rs.getString("title");
        String movieRating = rs.getString("rating");
        String movieGenreId = rs.getString("genre_id");
        Statement stmt2 = con.createStatement();
        String sql2 = "SELECT genre FROM Genre WHERE id=" + movieGenreId + ";";
        ResultSet rs2 = stmt2.executeQuery(sql2);
        while (rs2.next()) {
            String movieGenre = rs2.getString("genre");
%>
<tr>
    <td class="movie-rating"><%= movieRating %> / 10</td>
    <td class="movie-title"><%= movieTitle %></td>
    <td class="movie-genre"><%= movieGenre %></td>
</tr>
<%
        }
   }
   
   // Close the database objects

   rs.close();
   stmt.close();
%>
    </body>
</html>
