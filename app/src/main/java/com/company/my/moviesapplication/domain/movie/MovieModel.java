package com.company.my.moviesapplication.domain.movie;

import android.os.Parcel;
import android.os.Parcelable;

import com.company.my.moviesapplication.presentation.common.SortedEntity;

/**
 * Created by Oleja on 21.02.2018.
 */

public class MovieModel implements SortedEntity, Parcelable {

    private long id;

    private String name;

    private String description;

    public MovieModel(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + description;
    }

    @Override
    public boolean areItemsTheSame(SortedEntity sortedEntity) {
        return id >=0 && id == (((MovieModel) sortedEntity).getId());
    }

    @Override
    public boolean areContentsTheSame(SortedEntity sortedEntity) {
        return equals(sortedEntity);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(description);
    }

    public static final Parcelable.Creator<MovieModel> CREATOR = new Parcelable.Creator<MovieModel>() {
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };


    private MovieModel(Parcel in) {
        id = in.readLong();
        name = in.readString();
        description = in.readString();
    }
}
