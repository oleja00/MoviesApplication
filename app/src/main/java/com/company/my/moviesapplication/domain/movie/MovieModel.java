package com.company.my.moviesapplication.domain.movie;

/**
 * Created by Oleja on 21.02.2018.
 */

public class MovieModel {

    private long id;

    private String name;

    private String description;

    public MovieModel(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + description;
    }
}
