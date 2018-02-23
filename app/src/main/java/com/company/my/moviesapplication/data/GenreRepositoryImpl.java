package com.company.my.moviesapplication.data;

import android.text.TextUtils;

import com.company.my.moviesapplication.di.activity.ActivityScope;
import com.company.my.moviesapplication.domain.genre.GenreModel;
import com.company.my.moviesapplication.domain.genre.GenreRepository;
import com.company.my.moviesapplication.utils.MockMovieData;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.PublishProcessor;

/**
 * Created by Oleja on 22.02.2018.
 */

@ActivityScope
public class GenreRepositoryImpl implements GenreRepository {

    private final FlowableProcessor<List<GenreModel>> processor;

    @Inject
    public GenreRepositoryImpl() {
        processor = PublishProcessor.create();
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
                .flatMap(genreModel
                        -> Flowable.fromIterable(genreModel.getMovies())
                        .filter(movieModel -> movieModel.getName().toLowerCase().contains(filter.toLowerCase()))
                        .toList().toFlowable()
                        .flatMap(movieModels -> {
                            genreModel.setMovies(movieModels);
                            return Flowable.just(genreModel);
                        })).toList().toFlowable()
                .subscribe(processor::onNext,
                        throwable -> {
                            // TODO: 23.02.2018 handle error
                        }, () -> {
                            // TODO: 23.02.2018 handle completable
                        });


    }
}
