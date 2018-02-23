package com.company.my.moviesapplication.presentation.activity_main.genres.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.company.my.moviesapplication.domain.genre.GenreModel;
import com.company.my.moviesapplication.presentation.activity_main.movies.MoviesFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleja on 22.02.2018.
 */

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    private List<GenreModel> mGenreModelList;

    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mGenreModelList = new ArrayList<>();
    }

    public void setGenreModelList(List<GenreModel> genreModelList) {
        mGenreModelList = new ArrayList<>();
        mGenreModelList.addAll(genreModelList);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int i) {
        return MoviesFragment.newInstance(mGenreModelList.get(i).getName());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public int getCount() {
        return mGenreModelList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        int size = mGenreModelList.get(position).getMovies().size();
        return mGenreModelList.get(position).getName() + (size>0 ? "(" + size + ")" : "");
    }
}
