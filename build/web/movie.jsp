<%-- 
    Document   : movie
    Created on : Mar 17, 2015, 3:48:22 AM
    Author     : austinchang
--%>
<%@page extends="movieapp.sql.MovieAppServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Movie</title>
    </head>
    <body>
        <h1>Thanks for adding a movie!</h1>
        
        <h3>You added the following movie:</h3>
        
        <label>Movie Title</label>
        <span>${movie.title}<span><br>
        <label>Movie Rating</label>
        <span>${movie.rating}<span><br>
        <label>Movie Genre</label>
        <span>${movie.genreId}<span><br>
                <br><br>
                <a href="index.jsp">Add another</a>
    </body>
</html>
