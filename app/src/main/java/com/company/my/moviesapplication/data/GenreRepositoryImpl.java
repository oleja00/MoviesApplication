package com.company.my.moviesapplication.data;

import android.text.TextUtils;

import com.company.my.moviesapplication.domain.genre.GenreModel;
import com.company.my.moviesapplication.domain.genre.GenreRepository;
import com.company.my.moviesapplication.domain.movie.MovieModel;
import com.company.my.moviesapplication.utils.MockMovieData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

/**
 * Created by Oleja on 22.02.2018.
 */

public class GenreRepositoryImpl implements GenreRepository {

    private static final FlowableProcessor<List<GenreModel>> processor = PublishProcessor.create();

    @Inject
    public GenreRepositoryImpl() {

    }

    @Override
    public Flowable<List<GenreModel>> getAllGenresWithFilms(String genre) {
        Flowable<List<GenreModel>> models = Flowable.just(MockMovieData.getMockFilms());
        return models.mergeWith(processor)
                .flatMap(genreModels -> Flowable.fromIterable(genreModels)
                        .filter(genreModel -> TextUtils.isEmpty(genre) || genreModel.getName().equals(genre))
                        .toList().toFlowable());

    }

    @Override
    public void setFilter(String filter) {
        List<GenreModel> genreModels = MockMovieData.getMockFilms();
        Flowable.fromIterable(genreModels)
                .flatMap(genreModel -> {
                            List<MovieModel> movieModels = new ArrayList<>();
                            return Flowable.fromIterable(genreModel.getMovies())
                                    .filter(movieModel -> movieModel.getName().toLowerCase().contains(filter.toLowerCase()))
                                    .map(movieModel -> {
                                        movieModels.add(movieModel);
                                        return genreModel;
                                    })
                                    .doOnComplete(() -> {
                                        genreModel.setMovies(movieModels);
                                    })
                                    .distinctUntilChanged();
                        }
                )
                .toList().toFlowable()
                .subscribe(processor::onNext, throwable -> {
                    // TODO: 22.02.2018 handle error
                }, () -> {
                    // TODO: 22.02.2018 handle completable
                });


    }
}
