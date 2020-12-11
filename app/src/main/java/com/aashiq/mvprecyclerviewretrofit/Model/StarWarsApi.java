package com.aashiq.mvprecyclerviewretrofit.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static android.R.attr.id;

/**
 * Created by ashugupta on 01/06/17.
 */

public interface StarWarsApi {
    @GET("films/")
    Call<FilmResponse> getAllFilms();

    @GET("films/{id}/")
        Call<Film> getFilm(@Path("id") long id);

}
