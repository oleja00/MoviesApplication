package com.company.my.moviesapplication.presentation.activity_main.movies;

import android.support.annotation.Nullable;

import com.company.my.moviesapplication.domain.genre.GenreInteractor;
import com.company.my.moviesapplication.presentation.common.BasePresenter;
import com.company.my.moviesapplication.utils.RxUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public final class MoviesPresenter implements BasePresenter<MoviesFragmentContract.View>, MoviesFragmentContract.EventListener {

    private MoviesFragmentContract.View mView;
    private MoviesFragmentContract.EventDelegate mEventDelegate;
    private GenreInteractor mGenreInteractor;

    @Inject
    public MoviesPresenter(MoviesFragmentContract.EventDelegate eventDelegate, GenreInteractor genreInteractor) {
        mEventDelegate = eventDelegate;
        mGenreInteractor = genreInteractor;
    }

    @Override
    public void attachView(MoviesFragmentContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
        RxUtils.unsubscribe(this);
    }

    @Nullable
    MoviesFragmentContract.View getView() {
        return mView;
    }

    public void getMovies(String genreName) {
        // TODO: 22.02.2018 handle error
        RxUtils.manage(this, genreName, mGenreInteractor.getAllGenresWithMovies(genreName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        genreModels -> mView.showMovies(genreModels.get(0).getMovies()),
                        Throwable::printStackTrace));
    }

}