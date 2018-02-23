package com.company.my.moviesapplication.presentation.activity_main.genres;

import com.company.my.moviesapplication.domain.genre.GenreModel;
import com.company.my.moviesapplication.presentation.common.BaseView;

import java.util.List;

public interface GenresFragmentContract {
    interface View extends BaseView {
        void showGenres(List<GenreModel> genreModels);
    }

    interface EventListener {
        void search(String searchText);
    }

    interface EventDelegate {
    }
}