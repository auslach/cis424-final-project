/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp.business;

import java.io.IOException;
import java.io.Serializable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author austinchang
 */
public class Movie implements Serializable {
    
    private String title;
    private int rating;
    private int genreId;
    
    public Movie() {
        title = "";
        rating = 0;
        genreId = 0;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getRating() {
        return rating;
    }
    
    public void setRating(String rating) {
        this.rating = Integer.parseInt(rating);
    }
    
    public int getGenreId() {
        return genreId;
    }
    
    public void setGenreId(String genreId) {
        this.genreId = Integer.parseInt(genreId);
    }

}
