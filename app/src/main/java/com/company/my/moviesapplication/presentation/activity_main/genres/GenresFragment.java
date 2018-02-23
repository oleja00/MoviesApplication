package com.company.my.moviesapplication.presentation.activity_main.genres;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.my.moviesapplication.R;
import com.company.my.moviesapplication.databinding.FragmentGenresBinding;
import com.company.my.moviesapplication.domain.genre.GenreModel;
import com.company.my.moviesapplication.presentation.activity_main.genres.common.FragmentPagerAdapter;
import com.company.my.moviesapplication.presentation.common.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class GenresFragment extends BaseFragment implements GenresFragmentContract.View {

    public static GenresFragment newInstance() {
        return new GenresFragment();
    }

    @Inject
    GenresPresenter mPresenter;
    private FragmentGenresBinding mBinding;

    private FragmentPagerAdapter mFragmentPagerAdapter;

    private SearchViewModel mSearchViewModel;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_genres, container, false);
        mFragmentPagerAdapter = new FragmentPagerAdapter(getChildFragmentManager());
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setEventListener(mPresenter);
        mPresenter.attachView(this);
        mSearchViewModel = new SearchViewModel(mPresenter);
        mBinding.setModel(mSearchViewModel);

        mPresenter.getAllGenresWithMovies();

        mBinding.viewPager.setAdapter(mFragmentPagerAdapter);
        mBinding.tabs.setupWithViewPager(mBinding.viewPager);
        mBinding.tabs.setTabMode(TabLayout.MODE_FIXED);

        mSearchViewModel.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }

    @Override
    public void showGenres(List<GenreModel> genreModels) {
        mBinding.viewPager.setOffscreenPageLimit(mFragmentPagerAdapter.getCount());
        mFragmentPagerAdapter.setGenreModelList(genreModels);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mSearchViewModel.onSaveInstanceState(outState);
    }
}
