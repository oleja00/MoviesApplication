package com.company.my.moviesapplication.presentation.activity_main.genres;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.my.moviesapplication.R;
import com.company.my.moviesapplication.databinding.FragmentGenresBinding;
import com.company.my.moviesapplication.presentation.common.BaseFragment;

import dagger.android.support.AndroidSupportInjection;

import javax.inject.Inject;

public class GenresFragment extends BaseFragment implements GenresFragmentContract.View {

    @Inject
    GenresPresenter mPresenter;
    private FragmentGenresBinding mBinding;

    public static GenresFragment newInstance() {
        return new GenresFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_genres, container, false);
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

    private class FragmentPagerAdapter extends FragmentStatePagerAdapter {

//        FragmentPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int i) {
//            switch (i) {
//                case TAB_MY_IDEAS:
//                    return ContentFragment.newInstance(ContentFragment.TAB_TYPE_IDEAS, userModel.id());
//                case TAB_MY_CHALLENGES:
//                    return ContentFragment.newInstance(ContentFragment.TAB_TYPE_CHALLENGES, userModel.id());
//            }
//            return null;
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
//        }
//
//        @Override
//        public int getCount() {
//            return COUNT_TAB;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            switch (position) {
//                case TAB_MY_IDEAS:
//                    return getString(R.string.CONTENT_TAB_IDEAS);
//                case TAB_MY_CHALLENGES:
//                    return getString(R.string.CONTENT_TAB_CHALLENGES);
//                default:
//                    throw new IllegalArgumentException("Exceeded max of tabs");
//            }
//        }
    }

}
