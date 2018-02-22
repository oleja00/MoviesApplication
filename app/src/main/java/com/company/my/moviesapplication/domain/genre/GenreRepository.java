package com.company.my.moviesapplication.domain.genre;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Oleja on 22.02.2018.
 */

public interface GenreRepository {
    Flowable<List<GenreModel>> getAllGenresWithFilms();
}
