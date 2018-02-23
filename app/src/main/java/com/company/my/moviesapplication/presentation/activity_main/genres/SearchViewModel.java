package com.company.my.moviesapplication.presentation.activity_main.genres;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Bundle;
import android.text.TextUtils;

import com.company.my.moviesapplication.BR;

/**
 * Created by Oleja on 22.02.2018.
 */

public class SearchViewModel extends BaseObservable {
    private static final String SEARCH_TAG = "search";

    private String mSearchText;

    private GenresFragmentContract.EventListener mEventListener;

    public SearchViewModel(GenresFragmentContract.EventListener eventListener) {
        mEventListener = eventListener;
    }

    @Bindable
    public String getSearchText() {
        return mSearchText;
    }

    public void setSearchText(String searchText) {
        mSearchText = searchText;
        notifyPropertyChanged(BR.searchText);
        mEventListener.search(searchText);
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        if (savedInstanceState == null) return;
        Bundle bundle = savedInstanceState.getBundle(SearchViewModel.class.getCanonicalName());
        if (bundle == null) return;
        setSearchText(bundle.getString(SEARCH_TAG));
    }

    public void onSaveInstanceState(Bundle outState) {
        if (!TextUtils.isEmpty(mSearchText)) {
            if (outState == null) return;
            Bundle bundle = new Bundle();
            bundle.putString(SEARCH_TAG, mSearchText);
            outState.putParcelable(SearchViewModel.class.getCanonicalName(), bundle);
        }

    }

}
