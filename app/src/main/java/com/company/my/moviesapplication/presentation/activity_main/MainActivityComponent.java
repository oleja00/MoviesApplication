package com.company.my.moviesapplication.presentation.activity_main;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.company.my.moviesapplication.di.activity.ActivityScope;
import com.company.my.moviesapplication.presentation.activity_main.genres.GenresFragment;
import com.company.my.moviesapplication.presentation.activity_main.genres.injection.GenresFragmentComponent;
import com.company.my.moviesapplication.presentation.activity_main.movies.MoviesFragment;
import com.company.my.moviesapplication.presentation.activity_main.movies.MoviesFragmentContract;
import com.company.my.moviesapplication.presentation.activity_main.movies.injection.MoviesFragmentComponent;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@ActivityScope
@Subcomponent(modules = {
        MainActivityComponent.MainActivityModule.class,
        MainActivityComponent.FragmentBindingsModule.class,
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }

    @Module
    class MainActivityModule {
        @Provides
        Activity provideActivity(MainActivity activity) {
            return activity;
        }
    }

    @Module(subcomponents = {GenresFragmentComponent.class,
            MoviesFragmentComponent.class})
    abstract class FragmentBindingsModule {
        @Binds
        @IntoMap
        @FragmentKey(GenresFragment.class)
        public abstract AndroidInjector.Factory<? extends Fragment> genresFragmentComponentBuilder(GenresFragmentComponent.Builder builder);

        @Binds
        @IntoMap
        @FragmentKey(MoviesFragment.class)
        public abstract AndroidInjector.Factory<? extends Fragment> moviesFragmentComponentBuilder(MoviesFragmentComponent.Builder builder);

    }

}
