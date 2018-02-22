package com.company.my.moviesapplication.presentation.activity_main.movies.injection;

import com.company.my.moviesapplication.di.fragment.FragmentScope;
import com.company.my.moviesapplication.presentation.activity_main.MainRouter;
import com.company.my.moviesapplication.presentation.activity_main.genres.GenresFragmentContract;
import com.company.my.moviesapplication.presentation.activity_main.movies.MoviesFragment;
import com.company.my.moviesapplication.presentation.activity_main.movies.MoviesFragmentContract;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@FragmentScope
@Subcomponent(modules = MoviesFragmentComponent.MainModule.class)
public interface MoviesFragmentComponent extends AndroidInjector<MoviesFragment> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<MoviesFragment> {
    }

    @Module
    interface MainModule {

        @Binds
        MoviesFragmentContract.EventDelegate provideRouter(MainRouter router) ;
    }
}