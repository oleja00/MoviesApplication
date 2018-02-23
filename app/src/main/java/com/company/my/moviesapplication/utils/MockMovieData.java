package com.company.my.moviesapplication.utils;

import com.company.my.moviesapplication.domain.genre.GenreModel;
import com.company.my.moviesapplication.domain.movie.MovieModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleja on 22.02.2018.
 */

public class MockMovieData {

    public static List<GenreModel> getMockFilms(){

        List<GenreModel> genres = new ArrayList<>();

        GenreModel genreHorror = new GenreModel();

        genreHorror.setId(0);

        genreHorror.setName("Horror");

        List<MovieModel> horrors = new ArrayList<>();

        horrors.add(new MovieModel(0, "The girl opposite", "description..."));
        horrors.add(new MovieModel(1, "The Wolf's Pit", "description..."));
        horrors.add(new MovieModel(2, "The Zodiac", "description..."));
        horrors.add(new MovieModel(3, "Texas Chainsaw Massacre", "description..."));
        horrors.add(new MovieModel(4, "The Six Demons of Emily Rose", "description..."));
        horrors.add(new MovieModel(5, "Strangers", "description..."));
        horrors.add(new MovieModel(6, "Ghosts in Connecticut", "description..."));
        horrors.add(new MovieModel(7, "The Phantom of the Red River", "description..."));
        horrors.add(new MovieModel(8, "Horror of Amitytil", "description..."));
        horrors.add(new MovieModel(9, "They", "description..."));

        genreHorror.setMovies(horrors);


        GenreModel genreComedy = new GenreModel();

        genreComedy.setId(1);

        genreComedy.setName("Comedy");

        List<MovieModel> comedies = new ArrayList<>();

        comedies.add(new MovieModel(10, "Peppers of Mr. Popper", "description..."));
        comedies.add(new MovieModel(11, "Always say \"YES\"", "description..."));
        comedies.add(new MovieModel(12, "Scammers Dick and Jane", "description..."));
        comedies.add(new MovieModel(13, "Bruce Almighty", "description..."));
        comedies.add(new MovieModel(14, " I, again I and Irene", "description..."));
        comedies.add(new MovieModel(15, "Liar, the liar", "description..."));
        comedies.add(new MovieModel(16, "Dumb and Dumber", "description..."));
        comedies.add(new MovieModel(17, "The mask", "description..."));
        comedies.add(new MovieModel(18, "Ace Ventura: The Search for Pets", "description..."));
        comedies.add(new MovieModel(19, "I Love You, Phillip Morris", "description..."));

        genreComedy.setMovies(comedies);


        GenreModel genreDrama = new GenreModel();

        genreDrama.setId(2);

        genreDrama.setName("Drama");

        List<MovieModel> dramas = new ArrayList<>();

        dramas.add(new MovieModel(20, "Artificial intelligence", "description..."));
        dramas.add(new MovieModel(21, "Hachiko: The Most Faithful Friend", "description..."));
        dramas.add(new MovieModel(22, "The Green Mile", "description..."));
        dramas.add(new MovieModel(23, "Titanic", "description..."));
        dramas.add(new MovieModel(24, "White Bim Black Ear", "description..."));
        dramas.add(new MovieModel(25, "Hurry to love", "description..."));
        dramas.add(new MovieModel(26, "The Boy in the Striped Pajamas", "description..."));
        dramas.add(new MovieModel(27, "Pay to the Other", "description..."));
        dramas.add(new MovieModel(28, "Knockin on Heaven", "description..."));
        dramas.add(new MovieModel(29, "Bridge to Terabithia", "description..."));

        genreDrama.setMovies(dramas);

        genres.add(genreHorror);
        genres.add(genreComedy);
        genres.add(genreDrama);

        return genres;
    }
}
