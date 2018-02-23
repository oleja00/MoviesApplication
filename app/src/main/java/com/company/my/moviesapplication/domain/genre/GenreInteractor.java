package com.company.my.moviesapplication.domain.genre;

import com.company.my.moviesapplication.data.GenreRepositoryImpl;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Oleja on 22.02.2018.
 */

public class GenreInteractor {

    private GenreRepository mGenreRepository;

    @Inject
    public GenreInteractor (GenreRepositoryImpl genreRepository){
        mGenreRepository = genreRepository;
    }

    public Flowable<List<GenreModel>> getAllGenresWithMovies(String genreName){
        return mGenreRepository.getAllGenresWithFilms(genreName);
    }

    public void search(String searchText){
        mGenreRepository.setFilter(searchText);
    }
}
