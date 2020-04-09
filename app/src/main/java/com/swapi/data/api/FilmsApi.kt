package com.swapi.data.api

import com.swapi.data.api.model.film.Film
import com.swapi.data.api.model.film.FilmResponse
import com.swapi.data.api.model.film.FilmsResponse

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface FilmsApi {

    /**
     * Get Films
     */
    @GET(Endpoints.FILMS)
    fun getFilms(): Single<FilmsResponse>


    /**
     * Search Films
     */
    @GET(Endpoints.FILMS)
    fun searchFilms(@Query("search") search: String): Single<FilmsResponse>


    /**
     * Get Film from url
     */
    @GET
    fun getFilm(@Url url: String): Single<FilmResponse>
}