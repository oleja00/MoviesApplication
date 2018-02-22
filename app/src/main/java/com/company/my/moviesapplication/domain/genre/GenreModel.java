package com.company.my.moviesapplication.domain.genre;

import com.company.my.moviesapplication.domain.movie.MovieModel;

import java.util.List;

/**
 * Created by Oleja on 21.02.2018.
 */

public class GenreModel {

    private long id;

    private String name;

    private List<MovieModel> movies;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MovieModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }
}
