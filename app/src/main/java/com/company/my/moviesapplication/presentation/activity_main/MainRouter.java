package com.company.my.moviesapplication.presentation.activity_main;

import com.company.my.moviesapplication.presentation.activity_main.genres.GenresFragmentContract;
import com.company.my.moviesapplication.presentation.activity_main.movies.MoviesFragmentContract;
import com.company.my.moviesapplication.presentation.common.BaseRouter;

import javax.inject.Inject;

public class MainRouter extends BaseRouter implements
        GenresFragmentContract.EventDelegate,
        MoviesFragmentContract.EventDelegate{

    private MainActivity mActivity;

    @Inject
    MainRouter(MainActivity activity) {
        super(activity);
        mActivity = activity;
    }

}
