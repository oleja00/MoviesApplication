package com.company.my.moviesapplication.presentation.activity_main.genres;

import com.company.my.moviesapplication.domain.genre.GenreInteractor;
import com.company.my.moviesapplication.presentation.common.BasePresenter;
import com.company.my.moviesapplication.utils.RxUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public final class GenresPresenter implements BasePresenter<GenresFragmentContract.View>, GenresFragmentContract.EventListener {

    private GenresFragmentContract.View mView;
    private GenresFragmentContract.EventDelegate mEventDelegate;
    private GenreInteractor mGenreInteractor;

    @Inject
    public GenresPresenter(GenresFragmentContract.EventDelegate eventDelegate, GenreInteractor genreInteractor) {
        mEventDelegate = eventDelegate;
        mGenreInteractor = genreInteractor;
    }

    @Override
    public void attachView(GenresFragmentContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
        RxUtils.unsubscribe(this);
    }

    @Override
    public void search(String searchText) {
        mGenreInteractor.search(searchText);
    }

    public void getAllGenresWithMovies() {
        RxUtils.manage(this, mGenreInteractor.getAllGenresWithMovies("")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        genreModels -> {
                            mView.showGenres(genreModels);
                        },
                        throwable -> {
                            throwable.printStackTrace();
                            // TODO: 22.02.2018 handle error
                        }));
    }
}