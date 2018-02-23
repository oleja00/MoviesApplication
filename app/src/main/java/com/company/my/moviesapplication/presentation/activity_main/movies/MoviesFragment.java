package com.company.my.moviesapplication.presentation.activity_main.movies;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.my.moviesapplication.R;
import com.company.my.moviesapplication.databinding.FragmentMoviesBinding;
import com.company.my.moviesapplication.domain.movie.MovieModel;
import com.company.my.moviesapplication.presentation.common.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class MoviesFragment extends BaseFragment implements MoviesFragmentContract.View {

    public static final String GENRE_TAG = "genre";

    public static MoviesFragment newInstance(String genreName) {
        MoviesFragment moviesFragment = new MoviesFragment();
        Bundle args = new Bundle();
        args.putString(GENRE_TAG, genreName);
        moviesFragment.setArguments(args);
        return moviesFragment;
    }

    @Inject
    MoviesPresenter mPresenter;
    private FragmentMoviesBinding mBinding;

    private MovieAdapter mAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false);
        setRetainInstance(true);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setEventListener(mPresenter);
        mPresenter.attachView(this);

        mBinding.rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new MovieAdapter();
        mBinding.rvMovies.setAdapter(mAdapter);

        if(getArguments()!=null ){
            mPresenter.getMovies(getArguments().getString(GENRE_TAG, ""));
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }

    @Override
    public void showMovies(List<MovieModel> movies) {
        mAdapter.setData(movies);
    }

}
