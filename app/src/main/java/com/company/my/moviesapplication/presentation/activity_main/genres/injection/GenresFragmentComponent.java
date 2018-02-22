package com.company.my.moviesapplication.presentation.activity_main.genres.injection;

import com.company.my.moviesapplication.di.fragment.FragmentScope;
import com.company.my.moviesapplication.presentation.activity_main.MainRouter;
import com.company.my.moviesapplication.presentation.activity_main.genres.GenresFragment;
import com.company.my.moviesapplication.presentation.activity_main.genres.GenresFragmentContract;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@FragmentScope
@Subcomponent(modules = GenresFragmentComponent.MainModule.class)
public interface GenresFragmentComponent extends AndroidInjector<GenresFragment> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<GenresFragment> {
    }

    @Module
    interface MainModule {

        @Binds
        GenresFragmentContract.EventDelegate provideRouter(MainRouter router) ;
    }
}