package com.company.my.moviesapplication.presentation.activity_main.genres;

import android.support.annotation.Nullable;

import com.company.my.moviesapplication.presentation.common.BasePresenter;
import com.company.my.moviesapplication.presentation.activity_main.genres.GenresFragmentContract;

import javax.inject.Inject;

public final class GenresPresenter implements BasePresenter<GenresFragmentContract.View>, GenresFragmentContract.EventListener {

    private GenresFragmentContract.View mView;
    private GenresFragmentContract.EventDelegate mEventDelegate;

    @Inject
    public GenresPresenter(GenresFragmentContract.EventDelegate eventDelegate) {
        mEventDelegate = eventDelegate;
    }

    @Override
    public void attachView(GenresFragmentContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

}