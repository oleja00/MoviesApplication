package com.company.my.moviesapplication.presentation.activity_main.movies;

import com.company.my.moviesapplication.domain.movie.MovieModel;
import com.company.my.moviesapplication.presentation.common.BaseView;

import java.util.List;

public interface MoviesFragmentContract {
    interface View extends BaseView {
        void showMovies(List<MovieModel> movies);
    }

    interface EventListener {
    }

    interface EventDelegate {
    }
}