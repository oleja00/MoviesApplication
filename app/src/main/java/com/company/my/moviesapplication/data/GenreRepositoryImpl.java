package com.company.my.moviesapplication.data;

import com.company.my.moviesapplication.domain.genre.GenreModel;
import com.company.my.moviesapplication.domain.genre.GenreRepository;
import com.company.my.moviesapplication.utils.MockMovieData;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

/**
 * Created by Oleja on 22.02.2018.
 */

public class GenreRepositoryImpl implements GenreRepository {

    @Inject
    public GenreRepositoryImpl () {

    }


    @Override
    public Flowable<List<GenreModel>> getAllGenresWithFilms() {
        return Flowable.create(e -> {
            MockMovieData.getMockFilms();
        }, BackpressureStrategy.BUFFER);
    }
}
