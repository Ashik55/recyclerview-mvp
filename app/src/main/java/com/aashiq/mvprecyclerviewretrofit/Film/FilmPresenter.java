package com.aashiq.mvprecyclerviewretrofit.Film;

import android.util.Log;
import android.view.View;

import com.aashiq.mvprecyclerviewretrofit.Model.Apis;
import com.aashiq.mvprecyclerviewretrofit.Model.Film;
import com.aashiq.mvprecyclerviewretrofit.Model.StarWarsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;



public class FilmPresenter implements FilmContract.FilmPresenter {
    int id;
    FilmContract.FilmView view;
    StarWarsApi api;

    FilmPresenter(int id,FilmContract.FilmView view)
    {
        this.id = id;
        this.view = view;
    }
    @Override
    public void getFilm() {
        view.showLoading();
        api = Apis.getStarWarsApi();
        Log.i(TAG, "getFilm: " + id);
        api.getFilm(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                Film film =  response.body();
                view.showTitle(film.getTitle());
                view.showCrawl(film.getOpening_crawl());
                view.showMessage("Film Loaded!");
                view.hideLoading();
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                view.hideLoading();
                view.showMessage(t.getMessage());
            }
        });
    }
}
