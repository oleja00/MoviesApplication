package com.company.my.moviesapplication.presentation.activity_main.movies;

import android.support.annotation.Nullable;

import com.company.my.moviesapplication.presentation.common.BasePresenter;
import com.company.my.moviesapplication.presentation.activity_main.movies.MoviesFragmentContract;

import javax.inject.Inject;

public final class MoviesPresenter implements BasePresenter<MoviesFragmentContract.View>, MoviesFragmentContract.EventListener {

    private MoviesFragmentContract.View mView;
    private MoviesFragmentContract.EventDelegate mEventDelegate;

    @Inject
    public MoviesPresenter(MoviesFragmentContract.EventDelegate eventDelegate) {
        mEventDelegate = eventDelegate;
    }

    @Override
    public void attachView(MoviesFragmentContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Nullable
    MoviesFragmentContract.View getView() {
        return mView;
    }

}