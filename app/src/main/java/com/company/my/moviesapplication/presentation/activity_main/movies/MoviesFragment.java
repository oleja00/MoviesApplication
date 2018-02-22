package com.company.my.moviesapplication.presentation.activity_main.movies;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.my.moviesapplication.R;
import com.company.my.moviesapplication.databinding.FragmentMoviesBinding;
import com.company.my.moviesapplication.presentation.common.BaseFragment;

import dagger.android.support.AndroidSupportInjection;

import javax.inject.Inject;

public class MoviesFragment extends BaseFragment implements MoviesFragmentContract.View {

    @Inject
    MoviesPresenter mPresenter;
    private FragmentMoviesBinding mBinding;

    public static MoviesFragment newInstance() {
        return new MoviesFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setEventListener(mPresenter);
        mPresenter.attachView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }

}
