package com.company.my.moviesapplication.presentation.activity_main.movies;


import com.company.my.moviesapplication.R;
import com.company.my.moviesapplication.databinding.ItemMovieAdapterBinding;
import com.company.my.moviesapplication.domain.movie.MovieModel;
import com.company.my.moviesapplication.presentation.common.BindingAdapter;
import com.company.my.moviesapplication.presentation.common.BindingViewHolder;
import com.company.my.moviesapplication.presentation.common.SortedListWrapper;

import java.util.List;

public class MovieAdapter extends BindingAdapter<ItemMovieAdapterBinding> {

    private SortedListWrapper<MovieModel> mData;

    public MovieAdapter() {
        mData = new SortedListWrapper<>(this);
    }

    public void setData(List<com.company.my.moviesapplication.domain.movie.MovieModel> data) {
        mData.setData(data);
    }

    @Override
    protected void bindItem(BindingViewHolder<ItemMovieAdapterBinding> viewHolder, int position, List<Object> payload) {
        viewHolder.getBinding().setMovie(mData.get(position));
    }

    @Override
    protected int getLayoutId(int position) {
        return R.layout.item_movie_adapter;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
