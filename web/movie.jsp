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
        <link rel="stylesheet" href="styles/common.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Movie</title>
    </head>
    <body>
        <h1>Thanks for adding a movie, ${movie.name}!</h1>
        
        <h3>The following movie has been added.</h3>
        
        <label>Movie: </label>
        <span><strong>${movie.title}</strong><span><br>
        <label>Rating: </label>
        <span>${movie.rating} / 10<span><br>
                <br><br>
                <a href="index.jsp">Add Another</a>
    </body>
</html>
